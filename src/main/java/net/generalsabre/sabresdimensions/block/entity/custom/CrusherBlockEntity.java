package net.generalsabre.sabresdimensions.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.generalsabre.sabresdimensions.block.entity.ImplementedInventory;
import net.generalsabre.sabresdimensions.block.entity.ModBlockEntities;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.generalsabre.sabresdimensions.screen.custom.AlloyFurnaceScreenHandler;
import net.generalsabre.sabresdimensions.screen.custom.CrusherScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

import static net.generalsabre.sabresdimensions.block.custom.CrusherBlock.ACTIVE;
import static net.generalsabre.sabresdimensions.block.custom.CrusherBlock.POWERED;

public class CrusherBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    private int progress = 0;
    private int maxProgress = 80;

    private int power = 0;
    public boolean canCraft = false;
    public boolean isCrafting = false;

    protected final PropertyDelegate propertyDelegate;

    public CrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CRUSHER_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate(){

            @Override
            public int get(int index) {
                return switch (index){
                  case 0 -> CrusherBlockEntity.this.progress;
                  case 1 -> CrusherBlockEntity.this.maxProgress;
                  case 2 -> CrusherBlockEntity.this.power;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0: CrusherBlockEntity.this.progress = value;
                        break;
                    case 1: CrusherBlockEntity.this.maxProgress = value;
                        break;
                    case 2: CrusherBlockEntity.this.power = value;
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
        return Text.translatable("block.sabresdimensions.crusher");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrusherScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state){

        if (isPowered()){
            world.setBlockState(pos, state.with(POWERED, true), Block.NOTIFY_ALL);
            power = 1;
            canCraft = true;
        } else {
            world.setBlockState(pos, state.with(POWERED, false), Block.NOTIFY_ALL);
            power = 0;
            canCraft = false;
        }

        if (isCrafting){
            incrementProgress();
            markDirty(world, pos, state);
            world.setBlockState(pos, state.with(ACTIVE, true), Block.NOTIFY_ALL);
        } else {
            world.setBlockState(pos, state.with(ACTIVE, false), Block.NOTIFY_ALL);
        }

        if (canCraft && hasRecipe()){
            isCrafting = true;
        } else if (!canCraft || !hasRecipe()){
            resetProgress();
            isCrafting = false;
        }

        if (isCraftingFinished()){
            resetProgress();
            craftItem();
        }
    }

    private boolean isPowered() {
        assert world != null;
        return world.isReceivingRedstonePower(pos);
    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT,1);
        ItemStack output = new ItemStack(ModItems.CRUSHED_ORAXIUM, 1);

        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private void resetProgress() {
        progress = 0;
    }

    private boolean hasRecipe() {
        Item input = ModItems.RAW_ORAXIUM;
        ItemStack output = new ItemStack(ModItems.CRUSHED_ORAXIUM, 1);

        return this.getStack(INPUT_SLOT).isOf(input) && canInsertItemIntoOutputSlot(output)
                && canInsertAmountIntoOutputSlot(output.getCount());

    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(OUTPUT_SLOT).getCount();

        return maxCount >=  currentCount + count;
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
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
        nbt.putInt("crusher.progress", progress);
        nbt.putInt("crusher.max_progress", maxProgress);
        nbt.putBoolean("crusher.isCrafting", isCrafting);

    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("crusher.progress");
        maxProgress = nbt.getInt("crusher.max_progress");
        isCrafting = nbt.getBoolean("crusher.isCrafting");

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
