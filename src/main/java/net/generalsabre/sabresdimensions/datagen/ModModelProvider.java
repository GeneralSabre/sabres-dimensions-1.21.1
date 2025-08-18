package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.fluid.ModFluids;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool arakitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ARAKITE);
        BlockStateModelGenerator.BlockTexturePool arakiteBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ARAKITE_BRICKS);
        BlockStateModelGenerator.BlockTexturePool arakiteTilePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ARAKITE_TILES);
        BlockStateModelGenerator.BlockTexturePool polishedArakitePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_ARAKITE);
        arakitePool.slab(ModBlocks.ARAKITE_SLAB);
        arakitePool.stairs(ModBlocks.ARAKITE_STAIRS);
        arakitePool.button(ModBlocks.ARAKITE_BUTTON);
        arakitePool.pressurePlate(ModBlocks.ARAKITE_PRESSURE_PLATE);
        arakitePool.wall(ModBlocks.ARAKITE_WALL);
        arakiteBrickPool.slab(ModBlocks.ARAKITE_BRICK_SLAB);
        arakiteBrickPool.wall(ModBlocks.ARAKITE_BRICK_WALL);
        arakiteBrickPool.stairs(ModBlocks.ARAKITE_BRICK_STAIRS);
        arakiteTilePool.stairs(ModBlocks.ARAKITE_TILE_STAIRS);
        arakiteTilePool.slab(ModBlocks.ARAKITE_TILE_SLAB);
        polishedArakitePool.slab(ModBlocks.POLISHED_ARAKITE_SLAB);
        polishedArakitePool.stairs(ModBlocks.POLISHED_ARAKITE_STAIRS);
        polishedArakitePool.wall(ModBlocks.POLISHED_ARAKITE_WALL);
        polishedArakitePool.button(ModBlocks.POLISHED_ARAKITE_BUTTON);
        polishedArakitePool.pressurePlate(ModBlocks.POLISHED_ARAKITE_PRESSURE_PLATE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRODED_ARAKITE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHORAZINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHORAZINE_POWDER_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DALAMINE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUPAMOONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DALAMINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUPAMOONE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PENKAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PENKAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PENKAZ_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PENKAZINE_ALLOY_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ULAU_BLOCK);

        BlockStateModelGenerator.BlockTexturePool zalantPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ZALANT_BLOCK);
        zalantPool.pressurePlate(ModBlocks.ZALANT_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.ZALANT_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ZALANT_TRAPDOOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZALANT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ZALANT_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORAXIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DELETERIUM_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INGOT_PRESS);

        blockStateModelGenerator.registerLog(ModBlocks.ELASTAU_LOG).log(ModBlocks.ELASTAU_LOG).wood(ModBlocks.ELASTAU_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ELASTAU_LOG).log(ModBlocks.STRIPPED_ELASTAU_LOG).wood(ModBlocks.STRIPPED_ELASTAU_WOOD);

        BlockStateModelGenerator.BlockTexturePool elastauPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ELASTAU_PLANKS);
        elastauPool.slab(ModBlocks.ELASTAU_SLAB);
        elastauPool.stairs(ModBlocks.ELASTAU_STAIRS);
        elastauPool.button(ModBlocks.ELASTAU_BUTTON);
        elastauPool.pressurePlate(ModBlocks.ELASTAU_PRESSURE_PLATE);
        elastauPool.fence(ModBlocks.ELASTAU_FENCE);
        elastauPool.fenceGate(ModBlocks.ELASTAU_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.ELASTAU_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ELASTAU_TRAPDOOR);

        blockStateModelGenerator.registerSingleton(ModBlocks.ELASTAU_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.ELASTAU_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ARAKITE_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHORAZINE_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.DALAMINE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PENKAZ_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PENKAZ, Models.GENERATED);

        itemModelGenerator.register(ModItems.PENKAZINE_ALLOY_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.PENKAZINE_ALLOY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PENKAZINE_ALLOY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PENKAZINE_ALLOY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PENKAZINE_ALLOY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PENKAZINE_ALLOY_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PENKAZINE_ALLOY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PENKAZINE_ALLOY_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PENKAZINE_ALLOY_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PENKAZINE_ALLOY_BOOTS));


        itemModelGenerator.register(ModItems.RAW_ZALANT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZALANT_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ZALANT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZALANT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZALANT_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZALANT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZALANT_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZALANT_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZALANT_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZALANT_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ZALANT_BOOTS));

        itemModelGenerator.register(ModItems.ZALANT_ROD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ULAU_CLUMP, Models.GENERATED);
        itemModelGenerator.register(ModItems.COATED_STRING, Models.GENERATED);

        itemModelGenerator.register(ModItems.LUPAMOONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUPAMOONE_PROCESSOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.LOGIC_CHIP, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUPAMOONE_CORE, Models.GENERATED);

        itemModelGenerator.register(ModFluids.BUCKET_OF_MOLTEN_DELETERIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUSHED_ORAXIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ORAXIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOLED_SLAG, Models.GENERATED);
        itemModelGenerator.register(ModItems.DELETERIUM_INGOT, Models.GENERATED);
    }
}
