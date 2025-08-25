package net.generalsabre.sabresdimensions.block.custom;

import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModFlowerBlock extends FlowerBlock {

    public ModFlowerBlock(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, Settings settings) {
        super(stewEffect, effectLengthInSeconds, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return super.canPlantOnTop(floor, world, pos) || canPlantOnModBlock(floor, world, pos);
    }

    protected boolean canPlantOnModBlock(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.GIRADO_SOIL);
    }
}
