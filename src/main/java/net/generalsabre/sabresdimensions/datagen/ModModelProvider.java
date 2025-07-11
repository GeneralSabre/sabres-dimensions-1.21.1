package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARAKITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARAKITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARAKITE_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLISHED_ARAKITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRODED_ARAKITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHORAZINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHORAZINE_POWDER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DALAMINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DALAMINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PENKAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PENKAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PENKAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PENKAZINE_ALLOY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ULAU_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZALANT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZALANT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ZALANT_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ARAKITE_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHORAZINE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.DALAMINE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PENKAZ_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PENKAZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.PENKAZINE_ALLOY_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ZALANT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZALANT_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZALANT_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ULAU_CLUMP, Models.GENERATED);
    }
}
