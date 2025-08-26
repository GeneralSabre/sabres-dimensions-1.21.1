package net.generalsabre.sabresdimensions.block;

import net.generalsabre.sabresdimensions.block.custom.*;
import net.generalsabre.sabresdimensions.effect.ModEffects;
import net.minecraft.block.*;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.enchantment.effect.AllOfEnchantmentEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    // Zalant Blocks
    public static final Block ZALANT_BLOCK = registerBlock("zalant_block",
            new Block(AbstractBlock.Settings.create().strength(5f,6f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_ZALANT_BLOCK = registerBlock("raw_zalant_block",
            new Block(AbstractBlock.Settings.create().strength(5f,6f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block ZALANT_ORE = registerBlock("zalant_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create().strength(5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block ZALANT_DOOR = registerBlock("zalant_door",
            new DoorBlock(BlockSetType.IRON,AbstractBlock.Settings.create().strength(1.5f,6f).requiresTool().sounds(BlockSoundGroup.METAL).nonOpaque()));
    public static final Block ZALANT_TRAPDOOR = registerBlock("zalant_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,AbstractBlock.Settings.create().strength(1.5f,6f).requiresTool().sounds(BlockSoundGroup.METAL).nonOpaque()));
    public static final Block ZALANT_PRESSURE_PLATE = registerBlock("zalant_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(1.5f,6f).requiresTool().sounds(BlockSoundGroup.METAL)));






    // Arakite Blocks
    public static final Block ARAKITE = registerBlock("arakite",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block ARAKITE_STAIRS = registerBlock("arakite_stairs",
            new StairsBlock(ModBlocks.ARAKITE.getDefaultState(),
                    AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block ARAKITE_SLAB = registerBlock("arakite_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block ARAKITE_BUTTON = registerBlock("arakite_button",
            new ButtonBlock(BlockSetType.STONE,10,AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE).noCollision()));
    public static final Block ARAKITE_PRESSURE_PLATE = registerBlock("arakite_pressure_plate",
            new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block ARAKITE_WALL = registerBlock("arakite_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block ARAKITE_BRICKS = registerBlock("arakite_bricks",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));
    public static final Block ARAKITE_BRICK_STAIRS = registerBlock("arakite_brick_stairs",
            new StairsBlock(ModBlocks.ARAKITE_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));
    public static final Block ARAKITE_BRICK_SLAB = registerBlock("arakite_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));
    public static final Block ARAKITE_BRICK_WALL = registerBlock("arakite_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));

    public static final Block POLISHED_ARAKITE = registerBlock("polished_arakite",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block POLISHED_ARAKITE_STAIRS = registerBlock("polished_arakite_stairs",
            new StairsBlock(ModBlocks.POLISHED_ARAKITE.getDefaultState(),
                    AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block POLISHED_ARAKITE_SLAB = registerBlock("polished_arakite_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block POLISHED_ARAKITE_WALL = registerBlock("polished_arakite_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block POLISHED_ARAKITE_BUTTON = registerBlock("polished_arakite_button",
            new ButtonBlock(BlockSetType.STONE,10,AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE).noCollision()));
    public static final Block POLISHED_ARAKITE_PRESSURE_PLATE = registerBlock("polished_arakite_pressure_plate",
            new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));

    public static final Block ARAKITE_TILES = registerBlock("arakite_tiles",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));
    public static final Block ARAKITE_TILE_STAIRS = registerBlock("arakite_tile_stairs",
            new StairsBlock(ModBlocks.ARAKITE_TILES.getDefaultState(),
                    AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));
    public static final Block ARAKITE_TILE_SLAB = registerBlock("arakite_tile_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(1.25f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));

    public static final Block CORRODED_ARAKITE = registerBlock("corroded_arakite",
            new Block(AbstractBlock.Settings.create().strength(2f,3.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));


    // Keralan
    public static final Block KERALAN = registerBlock("keralan",
            new Block(AbstractBlock.Settings.create().strength(9f, 6f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block COBBLED_KERALAN = registerBlock("cobbled_keralan",
            new Block(AbstractBlock.Settings.create().strength(7f, 5.5f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block KERALAN_BRICKS = registerBlock("keralan_bricks",
            new Block(AbstractBlock.Settings.create().strength(7f, 5.5f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block KERALAN_STAIRS = registerBlock("keralan_stairs",
            new StairsBlock(ModBlocks.KERALAN.getDefaultState(),
                    AbstractBlock.Settings.create().strength(9f, 6f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block KERALAN_SLAB = registerBlock("keralan_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(9f, 6f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block KERALAN_BUTTON = registerBlock("keralan_button",
            new ButtonBlock(BlockSetType.STONE,20,AbstractBlock.Settings.create().strength(9f, 6f).requiresTool().sounds(BlockSoundGroup.STONE).noCollision()));
    public static final Block KERALAN_PRESSURE_PLATE = registerBlock("keralan_pressure_plate",
            new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.create().strength(9f, 6f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block KERALAN_WALL = registerBlock("keralan_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(9f, 6f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block KERALAN_BRICK_STAIRS = registerBlock("keralan_brick_stairs",
            new StairsBlock(ModBlocks.KERALAN_BRICKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(7f, 5.5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block KERALAN_BRICK_SLAB = registerBlock("keralan_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(7f, 5.5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block KERALAN_BRICK_WALL = registerBlock("keralan_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(7f, 5.5f).requiresTool().sounds(BlockSoundGroup.STONE)));




    // Dalamine Blocks
    public static final Block DALAMINE_BLOCK = registerBlock("dalamine_block",
            new Block(AbstractBlock.Settings.create().strength(1.5f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block DALAMINE_ORE = registerBlock("dalamine_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4,8), (AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE))));
    // Penkazine Blocks
    public static final Block CHORAZINE_ORE = registerBlock("chorazine_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1,3), (AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE))));
    public static final Block PENKAZ_ORE = registerBlock("penkaz_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), (AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE))));

    public static final Block CHORAZINE_POWDER_BLOCK = registerBlock("chorazine_powder_block",
            new ColoredFallingBlock(new ColorCode(14406560),
                    AbstractBlock.Settings.create().strength(0.5F).sounds(BlockSoundGroup.SAND)));

    public static final Block PENKAZ_BLOCK = registerBlock("penkaz_block",
            new Block(AbstractBlock.Settings.create().strength(5f,6f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_PENKAZ_BLOCK = registerBlock("raw_penkaz_block",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block PENKAZINE_ALLOY_BLOCK = registerBlock("penkazine_alloy_block",
            new Block(AbstractBlock.Settings.create().strength(5f,6f).requiresTool().sounds(BlockSoundGroup.METAL)));






    // Misc.
    public static final Block ULAU_BLOCK = registerBlock("ulau_block",
            new TranslucentBlock(AbstractBlock.Settings.create().strength(0.25f,0.25f).sounds(BlockSoundGroup.HONEY).nonOpaque()));
    public static final Block IRP_WEAVE = registerBlock("irp_weave",
            new HayBlock(AbstractBlock.Settings.create().strength(0.4f,0f).sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()));
    
    public static final Block LUPAMOONE_BLOCK = registerBlock("lupamoone_block",
            new TranslucentBlock(AbstractBlock.Settings.create().strength(3f,3f).sounds(BlockSoundGroup.METAL).requiresTool()));
    public static final Block LUPAMOONE_ORE = registerBlock("lupamoone_ore",
            new TranslucentBlock(AbstractBlock.Settings.create().strength(2.5f,2.5f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block COULIEM_FLOWER = registerBlock("couliem_flower",
            new Block(AbstractBlock.Settings.create().strength(0.1f,0f).sounds(BlockSoundGroup.BIG_DRIPLEAF)));
    public static final Block COULIEM_LEAVES = registerBlock("couliem_leaves",
            new Block(AbstractBlock.Settings.create().strength(0.25f,0f).sounds(BlockSoundGroup.BIG_DRIPLEAF).requiresTool()));
    public static final Block COULIEM_STEM = registerBlock("couliem_stem",
            new PillarBlock(AbstractBlock.Settings.create().strength(2f,0.5f).sounds(BlockSoundGroup.BAMBOO_WOOD).requiresTool()));

    public static final Block GIRADO_SOIL = registerBlock("girado_soil",
            new Block(AbstractBlock.Settings.create().strength(0.6f, 0.25f).sounds(BlockSoundGroup.ROOTED_DIRT).requiresTool()));

    public static final Block TARRO_PLANT = registerBlock("tarro_plant",
            new ModFlowerBlock(ModEffects.GROUNDED, 10, AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));
    public static final Block GIRADO_WEEDS = registerBlock("girado_weeds",
            new ModFlowerBlock(ModEffects.GROUNDED, 2, AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));
    public static final Block GIRADO_GRASS = registerBlock("girado_grass",
            new ModFlowerBlock(ModEffects.GROUNDED, 5, AbstractBlock.Settings.create().noCollision().sounds(BlockSoundGroup.GRASS)));

    public static final Block ALLOY_FURNACE = registerBlock("alloy_furnace",
            new AlloyFurnaceBlock(AbstractBlock.Settings.create().strength(1.0f).hardness(1.0f).requiresTool()));
    public static final Block CRUSHER = registerBlock("crusher",
            new CrusherBlock(AbstractBlock.Settings.create().strength(1.0f,1.0f).requiresTool()));
    public static final Block INGOT_PRESS = registerBlock("ingot_press",
            new IngotPressBlock(AbstractBlock.Settings.create().strength(1.0f).hardness(1.0f).requiresTool()));
    public static final Block INDUSTRIAL_FURNACE = registerBlock("industrial_furnace",
            new IndustrialFurnaceBlock(AbstractBlock.Settings.create().strength(1.0f).hardness(1.0f).requiresTool()));

    // Deleterium / Oraxium
    public static final Block ORAXIUM_ORE = registerBlock("oraxium_ore",
            new TranslucentBlock(AbstractBlock.Settings.create().strength(2.5f,2.5f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block DELETERIUM_BLOCK = registerBlock("deleterium_block",
            new TranslucentBlock(AbstractBlock.Settings.create().strength(2.5f,2.5f).sounds(BlockSoundGroup.METAL).requiresTool()));

    // Elastau
    public static final Block ELASTAU_LOG = registerBlock("elastau_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG)));
    public static final Block ELASTAU_WOOD = registerBlock("elastau_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)));
    public static final Block STRIPPED_ELASTAU_LOG = registerBlock("stripped_elastau_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_SPRUCE_LOG)));
    public static final Block STRIPPED_ELASTAU_WOOD = registerBlock("stripped_elastau_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_SPRUCE_WOOD)));

    public static final Block ELASTAU_PLANKS = registerBlock("elastau_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)));
    public static final Block ELASTAU_STAIRS = registerBlock("elastau_stairs",
            new StairsBlock(ModBlocks.ELASTAU_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f,0f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block ELASTAU_SLAB = registerBlock("elastau_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f,0f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block ELASTAU_BUTTON = registerBlock("elastau_button",
            new ButtonBlock(BlockSetType.SPRUCE,20,AbstractBlock.Settings.create().strength(2f,0f).sounds(BlockSoundGroup.WOOD).requiresTool().noCollision()));
    public static final Block ELASTAU_PRESSURE_PLATE = registerBlock("elastau_pressure_plate",
            new PressurePlateBlock(BlockSetType.SPRUCE, AbstractBlock.Settings.create().strength(2f,0f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block ELASTAU_FENCE = registerBlock("elastau_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f,0f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block ELASTAU_FENCE_GATE = registerBlock("elastau_fence_gate",
            new FenceGateBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().strength(2f,0f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block ELASTAU_DOOR = registerBlock("elastau_door",
            new DoorBlock(BlockSetType.SPRUCE,AbstractBlock.Settings.create().strength(2f,0f).sounds(BlockSoundGroup.WOOD).requiresTool().nonOpaque()));
    public static final Block ELASTAU_TRAPDOOR = registerBlock("elastau_trapdoor",
            new TrapdoorBlock(BlockSetType.SPRUCE,AbstractBlock.Settings.create().strength(2f,0f).sounds(BlockSoundGroup.WOOD).requiresTool().nonOpaque()));

    // Kognoli
    public static final Block KOGNOLI_LOG = registerBlock("kognoli_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_LOG).strength(5f,1f)));
    public static final Block KOGNOLI_WOOD = registerBlock("kognoli_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD).strength(5f,1f)));
    public static final Block STRIPPED_KOGNOLI_LOG = registerBlock("stripped_kognoli_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_ACACIA_LOG).strength(5f,1f)));
    public static final Block STRIPPED_KOGNOLI_WOOD = registerBlock("stripped_kognoli_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_ACACIA_WOOD).strength(5f,1f)));

    public static final Block KOGNOLI_PLANKS = registerBlock("kognoli_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).strength(5f,1f)));
    public static final Block KOGNOLI_STAIRS = registerBlock("kognoli_stairs",
            new StairsBlock(ModBlocks.KOGNOLI_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(5f,1f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block KOGNOLI_SLAB = registerBlock("kognoli_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(5f,1f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block KOGNOLI_BUTTON = registerBlock("kognoli_button",
            new ButtonBlock(BlockSetType.ACACIA,40,AbstractBlock.Settings.create().strength(5f,1f).sounds(BlockSoundGroup.WOOD).requiresTool().noCollision()));
    public static final Block KOGNOLI_PRESSURE_PLATE = registerBlock("kognoli_pressure_plate",
            new PressurePlateBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(5f,1f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block KOGNOLI_FENCE = registerBlock("kognoli_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(5f,1f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block KOGNOLI_FENCE_GATE = registerBlock("kognoli_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(5f,1f).sounds(BlockSoundGroup.WOOD).requiresTool()));
    public static final Block KOGNOLI_DOOR = registerBlock("kognoli_door",
            new DoorBlock(BlockSetType.ACACIA,AbstractBlock.Settings.create().strength(5f,1f).sounds(BlockSoundGroup.WOOD).requiresTool().nonOpaque()));
    public static final Block KOGNOLI_TRAPDOOR = registerBlock("kognoli_trapdoor",
            new TrapdoorBlock(BlockSetType.ACACIA,AbstractBlock.Settings.create().strength(5f,1f).sounds(BlockSoundGroup.WOOD).requiresTool().nonOpaque()));





    public static final Block ELASTAU_LEAVES = registerBlock("elastau_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES)));

    public static final Block ELASTAU_SAPLING = registerBlock("elastau_sapling",
            new SaplingBlock(SaplingGenerator.SPRUCE,AbstractBlock.Settings.copy(Blocks.SPRUCE_SAPLING)));

    public static final Block KOGNOLI_LEAVES = registerBlock("kognoli_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES)));

    public static final Block KOGNOLI_SAPLING = registerBlock("kognoli_sapling",
            new SaplingBlock(SaplingGenerator.ACACIA,AbstractBlock.Settings.copy(Blocks.ACACIA_SAPLING)));



    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(SabresDimensions.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SabresDimensions.MOD_ID, name), block);
    }

    public static void registerModBlocks(){
        SabresDimensions.LOGGER.info("Registering mod blocks for " + SabresDimensions.MOD_ID);
    }
}
