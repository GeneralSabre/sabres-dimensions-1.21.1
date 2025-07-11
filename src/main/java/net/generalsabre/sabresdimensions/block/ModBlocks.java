package net.generalsabre.sabresdimensions.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.TranslucentBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
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


    // Arakite Blocks
    public static final Block ARAKITE = registerBlock("arakite",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block ARAKITE_BRICKS = registerBlock("arakite_bricks",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_BRICKS)));
    public static final Block POLISHED_ARAKITE = registerBlock("polished_arakite",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block ARAKITE_TILES = registerBlock("arakite_tiles",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE_TILES)));
    public static final Block CORRODED_ARAKITE = registerBlock("corroded_arakite",
            new Block(AbstractBlock.Settings.create().strength(2f,3.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

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
            new Block(AbstractBlock.Settings.create().strength(1.5f,1.5f).sounds(BlockSoundGroup.SAND)));

    public static final Block PENKAZ_BLOCK = registerBlock("penkaz_block",
            new Block(AbstractBlock.Settings.create().strength(5f,6f).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_PENKAZ_BLOCK = registerBlock("raw_penkaz_block",
            new Block(AbstractBlock.Settings.create().strength(2.5f,5f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block PENKAZINE_ALLOY_BLOCK = registerBlock("penkazine_alloy_block",
            new Block(AbstractBlock.Settings.create().strength(5f,6f).requiresTool().sounds(BlockSoundGroup.METAL)));

    // Misc.
    public static final Block ULAU_BLOCK = registerBlock("ulau_block",
            new TranslucentBlock(AbstractBlock.Settings.create().strength(0.5f,0.5f).sounds(BlockSoundGroup.SLIME).nonOpaque()));


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
