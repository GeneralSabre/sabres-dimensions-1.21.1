package net.generalsabre.sabresdimensions.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.generalsabre.sabresdimensions.block.entity.ImplementedInventory;
import net.generalsabre.sabresdimensions.block.entity.ModBlockEntities;
import net.generalsabre.sabresdimensions.fluid.ModFluids;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.generalsabre.sabresdimensions.screen.custom.CrusherScreenHandler;
import net.generalsabre.sabresdimensions.screen.custom.IngotPressScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.generalsabre.sabresdimensions.block.custom.IngotPressBlock.ACTIVE;
import static net.generalsabre.sabresdimensions.block.custom.IngotPressBlock.POWERED;

public class IngotPressBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT_1 = 1;
    private static final int OUTPUT_SLOT_2 = 2;

    private int progress = 0;
    private int maxProgress = 500;

    private int power = 0;
    public boolean canCraft = false;
    public boolean isCrafting = false;

    protected final PropertyDelegate propertyDelegate;

    public IngotPressBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.INGOT_PRESS_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate(){

            @Override
            public int get(int index) {
                return switch (index){
                  case 0 -> IngotPressBlockEntity.this.progress;
                  case 1 -> IngotPressBlockEntity.this.maxProgress;
                  case 2 -> IngotPressBlockEntity.this.power;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0: IngotPressBlockEntity.this.progress = value;
                        break;
                    case 1: IngotPressBlockEntity.this.maxProgress = value;
                        break;
                    case 2: IngotPressBlockEntity.this.power = value;
                        break;
                }
            }

            @Override
            public int size() {
                return 3;
            }
        };
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.sabresdimensions.ingot_press");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new IngotPressScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state){

        if (isPowered()){
            world.setBlockState(pos, state.with(POWERED, true), Block.NOTIFY_ALL);
            power = 1;
            canCraft = true;

            if (isCrafting){
                incrementProgress();
                markDirty(world, pos, state);
                world.setBlockState(pos, state.with(ACTIVE, true), Block.NOTIFY_ALL);
            } else {
                world.setBlockState(pos, state.with(ACTIVE, false), Block.NOTIFY_ALL);
            }

            if (isCraftingFinished()){
                resetProgress();
                craftItem();
            }


        } else {
            world.setBlockState(pos, state.with(POWERED, false), Block.NOTIFY_ALL);
            power = 0;
            canCraft = false;
        }

        if (canCraft && hasRecipe()){
            isCrafting = true;
        } else if (!canCraft || !hasRecipe()){
            resetProgress();
            isCrafting = false;
        }
    }

    private boolean isPowered() {
        assert world != null;
        return world.isReceivingRedstonePower(pos);
    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT,1);
        ItemStack output1 = new ItemStack(ModItems.DELETERIUM_INGOT, 1);
        ItemStack output2 = new ItemStack(Items.BUCKET, 1);

        this.setStack(OUTPUT_SLOT_1, new ItemStack(output1.getItem(),
                this.getStack(OUTPUT_SLOT_1).getCount() + output1.getCount()));
        this.setStack(OUTPUT_SLOT_2, new ItemStack(output2.getItem(),
                this.getStack(OUTPUT_SLOT_2).getCount() + output2.getCount()));
    }

    private void resetProgress() {
        progress = 0;
    }

    private boolean hasRecipe() {
        Item input = ModFluids.BUCKET_OF_MOLTEN_DELETERIUM;
        ItemStack output1 = new ItemStack(ModItems.DELETERIUM_INGOT, 1);
        ItemStack output2 = new ItemStack(Items.BUCKET, 1);

        return this.getStack(INPUT_SLOT).isOf(input) && canInsertItemIntoOutputSlot(output1, output2)
                && canInsertAmountIntoOutputSlot(output1.getCount(), output2.getCount());

    }

    private boolean canInsertAmountIntoOutputSlot(int count1, int count2) {
        int maxCount1 = this.getStack(OUTPUT_SLOT_1).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT_1).getMaxCount();
        int maxCount2 = this.getStack(OUTPUT_SLOT_2).isEmpty() ? 16 : this.getStack(OUTPUT_SLOT_2).getMaxCount();
        int currentCount1 = this.getStack(OUTPUT_SLOT_1).getCount();
        int currentCount2 = this.getStack(OUTPUT_SLOT_2).getCount();

        return maxCount1 >= currentCount1 + count1 && maxCount2 >= currentCount2 + count2;
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output1, ItemStack output2) {
        return (this.getStack(OUTPUT_SLOT_1).isEmpty() || this.getStack(OUTPUT_SLOT_1).getItem() == output1.getItem())
                && (this.getStack(OUTPUT_SLOT_2).isEmpty() || this.getStack(OUTPUT_SLOT_2).getItem() == output2.getItem());
    }

    private boolean isCraftingFinished() {
        return progress >= maxProgress;
    }

    private void incrementProgress() {
        progress++;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("ingot_press.progress", progress);
        nbt.putInt("ingot_press.max_progress", maxProgress);
        nbt.putBoolean("ingot_press.isCrafting", isCrafting);

    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("ingot_press.progress");
        maxProgress = nbt.getInt("ingot_press.max_progress");
        isCrafting = nbt.getBoolean("ingot_press.isCrafting");

    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
