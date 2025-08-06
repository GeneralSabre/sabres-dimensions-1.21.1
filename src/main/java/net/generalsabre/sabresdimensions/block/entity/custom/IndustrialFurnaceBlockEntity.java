package net.generalsabre.sabresdimensions.block.entity.custom;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.block.entity.ImplementedInventory;
import net.generalsabre.sabresdimensions.block.entity.ModBlockEntities;
import net.generalsabre.sabresdimensions.fluid.ModFluids;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.generalsabre.sabresdimensions.screen.custom.IndustrialFurnaceScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

import static net.generalsabre.sabresdimensions.block.custom.IndustrialFurnaceBlock.ACTIVE;

public class IndustrialFurnaceBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {

    private Integer burnProgress = 0;
    private Integer maxBurnProgress = 0;
    boolean isBurning = false;

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int OUTPUT_SLOT_1 = 2;
    private static final int OUTPUT_SLOT_2 = 3;
    private static final int FUEL_SLOT = 4;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 1200;

    public IndustrialFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.INDUSTRIAL_FURNACE_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> IndustrialFurnaceBlockEntity.this.progress;
                    case 1 -> IndustrialFurnaceBlockEntity.this.maxProgress;
                    case 2 -> IndustrialFurnaceBlockEntity.this.burnProgress;
                    case 3 -> IndustrialFurnaceBlockEntity.this.maxBurnProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0: IndustrialFurnaceBlockEntity.this.progress = value;
                            break;
                    case 1: IndustrialFurnaceBlockEntity.this.maxProgress = value;
                            break;
                    case 2: IndustrialFurnaceBlockEntity.this.burnProgress = value;
                            break;
                    case 3: IndustrialFurnaceBlockEntity.this.maxBurnProgress = value;
                            break;
                }
            }

            @Override
            public int size() {
                return 4;
            }
        };
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.sabresdimensions.industrial_furnace");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new IndustrialFurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public void tick(World world, BlockPos pos, BlockState state) {

        if (isMultiblockCompleted()){
            if (isBurning){
                incrementBurn();
                world.setBlockState(pos, state.with(ACTIVE, true));
            } else {
                world.setBlockState(pos, state.with(ACTIVE, false));
            }

            if (hasRecipe() && isBurningFinished() && hasFuel()){
                takeFuel();
                maxBurnProgress = getMaxBurnTime(getStack(FUEL_SLOT));
                burnProgress = getBurnTime(getStack(FUEL_SLOT));
                isBurning = true;
                burnProgress--;

            } else if (hasRecipe() && isBurningFinished() && !hasFuel()){
                isBurning = false;
            }

            if (hasRecipe() && isBurning){
                incrementProgress();
                markDirty(world, pos, state);
                if (hasCraftingFinished()){
                    craftItem();
                    resetProgress();
                }
            } else {
                resetProgress();
            }
        }
    }

    public final Map<BlockPos, Block> MULTIBLOCK_STRUCTURE = Map.ofEntries(
            // Bottom Layer

            // Left, Middle, Right
            Map.entry(new BlockPos(1,-1,0), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(1,-1,-1), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(1,-1,-2), ModBlocks.ARAKITE_BRICKS),

            Map.entry(new BlockPos(0,-1,0), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(0,-1,-1), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(0,-1,-2), ModBlocks.ARAKITE_BRICKS),

            Map.entry(new BlockPos(-1,-1,0), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(-1,-1,-1), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(-1,-1,-2), ModBlocks.ARAKITE_BRICKS),


            // Middle Layer
            Map.entry(new BlockPos(1,0,0), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(1,0,-1), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(1,0,-2), ModBlocks.ARAKITE_BRICKS),

            // Origin Pt
            Map.entry(new BlockPos(0,0,-1), Blocks.AIR),
            Map.entry(new BlockPos(0,0,-2), ModBlocks.ARAKITE_BRICKS),

            Map.entry(new BlockPos(-1,0,0), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(-1,0,-1), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(-1,0,-2), ModBlocks.ARAKITE_BRICKS),


            // Top Layer
            Map.entry(new BlockPos(1,1,0), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(1,1,-1), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(1,1,-2), ModBlocks.ARAKITE_BRICKS),

            Map.entry(new BlockPos(0,1,0), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(0,1,-1), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(0,1,-2), ModBlocks.ARAKITE_BRICKS),

            Map.entry(new BlockPos(-1,1,0), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(-1,1,-1), ModBlocks.ARAKITE_BRICKS),
            Map.entry(new BlockPos(-1,1,-2), ModBlocks.ARAKITE_BRICKS)

    );

    private BlockPos rotateOffset(BlockPos offset, Direction facing) {
        int x = offset.getX();
        int y = offset.getY();
        int z = offset.getZ();

        return switch (facing) {
            case NORTH -> new BlockPos(x, y, z);         // no change
            case SOUTH -> new BlockPos(-x, y, -z);       // 180°
            case WEST  -> new BlockPos(z, y, -x);        // 90° left
            case EAST  -> new BlockPos(-z, y, x);        // 90° right
            default -> offset;
        };
    }

    private boolean isMultiblockCompleted() {

        BlockPos origin = this.pos;
        World world = this.world;

        for (Direction facing : Direction.Type.HORIZONTAL){
            boolean isCompleted = true;
            for (Map.Entry<BlockPos, Block> entry : MULTIBLOCK_STRUCTURE.entrySet()){

                BlockPos rotatedOffset = rotateOffset(entry.getKey(), facing);
                BlockPos worldPos = origin.add(rotatedOffset);

                BlockState actual = world.getBlockState(worldPos);
                Block expected = entry.getValue();

                if (!actual.isOf(expected)) {
                    isCompleted = false;
                    break;
                }
            }

            if (isCompleted){
                return true;
            }
        }

        return false;
    }

    private Integer getBurnTime(ItemStack stack) {
        burnProgress = FuelRegistry.INSTANCE.get(stack.getItem());
        return burnProgress != null ? burnProgress : 0;
    }

    private int getMaxBurnTime(ItemStack stack) {
        maxBurnProgress = FuelRegistry.INSTANCE.get(stack.getItem());
        return maxBurnProgress != null ? maxBurnProgress : 0;
    }

    private boolean hasFuel() {
        return this.getStack(FUEL_SLOT).getCount()>0;
    }

    private boolean isBurningFinished() {
        return this.burnProgress <= 0;
    }

    private void takeFuel() {
        this.removeStack(FUEL_SLOT, 1);
    }

    private void incrementBurn() {
        burnProgress--;
    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT_1, 1);
        this.removeStack(INPUT_SLOT_2, 1);

        ItemStack output1 = new ItemStack(ModItems.COOLED_SLAG, 1);
        ItemStack output2 = new ItemStack(ModFluids.BUCKET_OF_MOLTEN_DELETERIUM, 1);

        this.setStack(OUTPUT_SLOT_1, new ItemStack(output1.getItem(),
                this.getStack(OUTPUT_SLOT_1).getCount() + output1.getCount()));
        this.setStack(OUTPUT_SLOT_2, new ItemStack(output2.getItem(),
                this.getStack(OUTPUT_SLOT_2).getCount() + output2.getCount()));
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = 1200;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void incrementProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Item input1 = ModItems.CRUSHED_ORAXIUM;
        Item input2 = Items.BUCKET;
        ItemStack output1 = new ItemStack(ModItems.COOLED_SLAG, 1);
        ItemStack output2 = new ItemStack(ModFluids.BUCKET_OF_MOLTEN_DELETERIUM, 1);

        return this.getStack(INPUT_SLOT_1).isOf(input1) && this.getStack(INPUT_SLOT_2).isOf(input2)
                && canInsertItemIntoOutputSlot(output1, output2) && canInsertAmountIntoOutputSlot(output1.getCount(), output2.getCount());

    }

    private boolean canInsertAmountIntoOutputSlot(int count1, int count2) {
        int maxCount1 = this.getStack(OUTPUT_SLOT_1).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT_1).getMaxCount();
        int maxCount2 = this.getStack(OUTPUT_SLOT_2).isEmpty() ? 1 : this.getStack(OUTPUT_SLOT_2).getMaxCount();
        int currentCount1 = this.getStack(OUTPUT_SLOT_1).getCount();
        int currentCount2 = this.getStack(OUTPUT_SLOT_2).getCount();

        return (maxCount1 >=  currentCount1 + count1) && (currentCount2 < maxCount2);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output1, ItemStack output2) {
        return (this.getStack(OUTPUT_SLOT_1).isEmpty() || this.getStack(OUTPUT_SLOT_1).getItem() == output1.getItem())
                && this.getStack(OUTPUT_SLOT_2).isEmpty();
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("industrial_furnace.progress", progress);
        nbt.putInt("industrial_furnace.max_progress", maxProgress);
        nbt.putInt("industrial_furnace.burn_progress", burnProgress);
        nbt.putInt("industrial_furnace.max_burn_progress", maxBurnProgress);
        nbt.putBoolean("isBurning", isBurning);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("industrial_furnace.progress");
        maxProgress = nbt.getInt("industrial_furnace.max_progress");
        burnProgress = nbt.getInt("industrial_furnace.burn_progress");
        maxBurnProgress = nbt.getInt("industrial_furnace.max_burn_progress");
        isBurning = nbt.getBoolean("isBurning");
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
