package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.util.ModTags;
import net.minecraft.block.Block;
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
                .add(ModBlocks.ARAKITE_WALL)
                .add(ModBlocks.ARAKITE_BUTTON)
                .add(ModBlocks.ARAKITE_PRESSURE_PLATE)
                .add(ModBlocks.ARAKITE_STAIRS)
                .add(ModBlocks.ARAKITE_SLAB)
                .add(ModBlocks.ARAKITE_BRICKS)
                .add(ModBlocks.ARAKITE_BRICK_SLAB)
                .add(ModBlocks.ARAKITE_BRICK_WALL)
                .add(ModBlocks.ARAKITE_BRICK_STAIRS)
                .add(ModBlocks.ARAKITE_TILES)
                .add(ModBlocks.ARAKITE_TILE_SLAB)
                .add(ModBlocks.ARAKITE_TILE_STAIRS)
                .add(ModBlocks.POLISHED_ARAKITE)
                .add(ModBlocks.POLISHED_ARAKITE_WALL)
                .add(ModBlocks.POLISHED_ARAKITE_BUTTON)
                .add(ModBlocks.POLISHED_ARAKITE_SLAB)
                .add(ModBlocks.POLISHED_ARAKITE_PRESSURE_PLATE)
                .add(ModBlocks.POLISHED_ARAKITE_STAIRS)

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
                .add(ModBlocks.ZALANT_DOOR)
                .add(ModBlocks.ZALANT_TRAPDOOR)

                .add(ModBlocks.PENKAZINE_ALLOY_BLOCK)
                .add(ModBlocks.LUPAMOONE_BLOCK)
                .add(ModBlocks.LUPAMOONE_ORE)

                .add(ModBlocks.ORAXIUM_ORE)
                .add(ModBlocks.DELETERIUM_BLOCK)
                .add(ModBlocks.ALLOY_FURNACE)
                .add(ModBlocks.INGOT_PRESS)
                .add(ModBlocks.CRUSHER);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.ELASTAU_FENCE_GATE)
                .add(ModBlocks.ELASTAU_FENCE)
                .add(ModBlocks.ELASTAU_SLAB)
                .add(ModBlocks.ELASTAU_STAIRS)
                .add(ModBlocks.ELASTAU_BUTTON)
                .add(ModBlocks.ELASTAU_PRESSURE_PLATE)
                .add(ModBlocks.ELASTAU_PLANKS)
                .add(ModBlocks.ELASTAU_DOOR)
                .add(ModBlocks.ELASTAU_TRAPDOOR);

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
                .add(ModBlocks.ZALANT_ORE)
                .add(ModBlocks.LUPAMOONE_BLOCK)
                .add(ModBlocks.LUPAMOONE_ORE);


        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add((ModBlocks.ORAXIUM_ORE));

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ARAKITE_WALL)
                .add(ModBlocks.ARAKITE_BRICK_WALL)
                .add(ModBlocks.POLISHED_ARAKITE_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ZALANT_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_PENKAZINE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.ELASTAU_LOG)
                .add(ModBlocks.STRIPPED_ELASTAU_LOG)
                .add(ModBlocks.ELASTAU_WOOD)
                .add(ModBlocks.STRIPPED_ELASTAU_WOOD);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.ELASTAU_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ELASTAU_FENCE_GATE);
    }
}
