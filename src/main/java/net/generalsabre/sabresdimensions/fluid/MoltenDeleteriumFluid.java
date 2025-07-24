package net.generalsabre.sabresdimensions.fluid;

import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public abstract class MoltenDeleteriumFluid extends ModFluids{

    @Override
    public FlowableFluid getStill() {
        return ModFluids.STILL_MOLTEN_DELETERIUM;
    }

    @Override
    public FlowableFluid getFlowing() {
        return ModFluids.FLOWING_MOLTEN_DELETERIUM;
    }

    @Override
    public Item getBucketItem() {
        return ModFluids.BUCKET_OF_MOLTEN_DELETERIUM;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return MOLTEN_DELETERIUM_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends MoltenDeleteriumFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        protected boolean isInfinite(World world) {
            return false;
        }

        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 0;
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends MoltenDeleteriumFluid {
        @Override
        protected boolean isInfinite(World world) {
            return false;
        }

        @Override
        protected int getMaxFlowDistance(WorldView world) {
            return 0;
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }


}
