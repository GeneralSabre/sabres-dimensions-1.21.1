package net.generalsabre.sabresdimensions.block.entity.custom;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.generalsabre.sabresdimensions.block.entity.ImplementedInventory;
import net.generalsabre.sabresdimensions.block.entity.ModBlockEntities;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.generalsabre.sabresdimensions.screen.custom.AlloyFurnaceScreenHandler;
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

public class AlloyFurnaceBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int OUTPUT_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 300;

    public AlloyFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ALLOY_FURNACE_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> AlloyFurnaceBlockEntity.this.progress;
                    case 1 -> AlloyFurnaceBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0: AlloyFurnaceBlockEntity.this.progress = value;
                    case 1: AlloyFurnaceBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.sabresdimensions.alloy_furnace");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AlloyFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public void tick(World world1, BlockPos pos, BlockState state1) {
        if (hasRecipe()){
            incrementProgress();
            markDirty(world, pos, state1);
            if (hasCraftingFinished()){
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }

        /*
        * if (burning == true) then incrementBurn()
        *
        * if (hasFuel() && hasRecipe()) then burnFuel()
        *
        * if (hasBurningFinished()) then resetBurn(), takeFuel()
        *
        * hasFuel() -> check if there's fuel
        * hasBurningFinished() -> check if burnTime >= maxBurnTime
         */

    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT_1, 1);
        this.removeStack(INPUT_SLOT_2, 1);

        ItemStack output = new ItemStack(ModItems.PENKAZINE_ALLOY_INGOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = 300;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void incrementProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Item input1 = ModItems.CHORAZINE_DUST;
        Item input2 = ModItems.PENKAZ_INGOT;
        ItemStack output = new ItemStack(ModItems.PENKAZINE_ALLOY_INGOT, 1);

        return this.getStack(INPUT_SLOT_1).isOf(input1) && this.getStack(INPUT_SLOT_2).isOf(input2)
                && canInsertItemIntoOutputSlot(output) && canInsertAmountIntoOutputSlot(output.getCount());

    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(OUTPUT_SLOT).getCount();

        return maxCount >=  currentCount + count;
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("alloy_furnace.progress", progress);
        nbt.putInt("alloy_furnace.max_progress", maxProgress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("alloy_furnace.progress");
        maxProgress = nbt.getInt("alloy_furnace.max_progress");
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
