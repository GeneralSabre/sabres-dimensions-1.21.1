package net.generalsabre.sabresdimensions.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoltenDeleteriumBlock extends FluidBlock {

    public MoltenDeleteriumBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!entity.isFireImmune()) {
            entity.setFireTicks(entity.getFireTicks() + 1);
            if (entity.getFireTicks() == 0) {
                entity.setOnFireFor(8.0F);
            }
        }

        int damage = 3;
        entity.damage(world.getDamageSources().inFire(), damage);
        super.onEntityCollision(state, world, pos, entity);
    }
}
