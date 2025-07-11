package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ARAKITE)
                .add(ModBlocks.ARAKITE_BRICKS)
                .add(ModBlocks.ARAKITE_TILES)
                .add(ModBlocks.POLISHED_ARAKITE)
                .add(ModBlocks.CORRODED_ARAKITE)
                .add(ModBlocks.CHORAZINE_ORE)
                .add(ModBlocks.DALAMINE_BLOCK)
                .add(ModBlocks.DALAMINE_ORE)
                .add(ModBlocks.PENKAZ_BLOCK)
                .add(ModBlocks.RAW_PENKAZ_BLOCK)
                .add(ModBlocks.PENKAZ_ORE)
                .add(ModBlocks.ZALANT_BLOCK)
                .add(ModBlocks.RAW_ZALANT_BLOCK)
                .add(ModBlocks.ZALANT_ORE)
                .add(ModBlocks.PENKAZINE_ALLOY_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PENKAZ_ORE)
                .add(ModBlocks.PENKAZ_BLOCK)
                .add(ModBlocks.RAW_PENKAZ_BLOCK)
                .add(ModBlocks.CHORAZINE_ORE)
                .add(ModBlocks.DALAMINE_ORE)
                .add(ModBlocks.DALAMINE_BLOCK)
                .add(ModBlocks.PENKAZINE_ALLOY_BLOCK)
                .add(ModBlocks.ZALANT_BLOCK)
                .add(ModBlocks.RAW_ZALANT_BLOCK)
                .add(ModBlocks.ZALANT_ORE);

    }
}
