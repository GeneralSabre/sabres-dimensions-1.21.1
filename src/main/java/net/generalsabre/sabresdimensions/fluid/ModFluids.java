package net.generalsabre.sabresdimensions.fluid;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;


public abstract class ModFluids extends FlowableFluid{

    public static FlowableFluid STILL_MOLTEN_DELETERIUM;
    public static FlowableFluid FLOWING_MOLTEN_DELETERIUM;
    public static Block MOLTEN_DELETERIUM_BLOCK;
    public static Item BUCKET_OF_MOLTEN_DELETERIUM;

    Identifier id = Identifier.of(SabresDimensions.MOD_ID, "bucket_of_molten_deleterium");


    public static void register(){

        STILL_MOLTEN_DELETERIUM = Registry.register(Registries.FLUID,
                Identifier.of(SabresDimensions.MOD_ID, "molten_deleterium"), new MoltenDeleteriumFluid.Still());
        FLOWING_MOLTEN_DELETERIUM = Registry.register(Registries.FLUID,
                Identifier.of(SabresDimensions.MOD_ID, "flowing_molten_deleterium"), new MoltenDeleteriumFluid.Flowing());
        MOLTEN_DELETERIUM_BLOCK = Registry.register(Registries.BLOCK,
                Identifier.of(SabresDimensions.MOD_ID, "molten_deleterium_block"),
                new FluidBlock(ModFluids.STILL_MOLTEN_DELETERIUM, FabricBlockSettings.copyOf(Blocks.LAVA)){});
        BUCKET_OF_MOLTEN_DELETERIUM = Registry.register(Registries.ITEM,
                Identifier.of(SabresDimensions.MOD_ID, "bucket_of_molten_deleterium"),
                new BucketItem(ModFluids.STILL_MOLTEN_DELETERIUM, new Item.Settings().maxCount(1).recipeRemainder(Items.BUCKET)));
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected boolean canBeReplacedWith(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
        return true;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView worldView) {
        return 2;
    }


    @Override
    public int getTickRate(WorldView worldView) {
        return 15;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }
}
