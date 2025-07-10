package net.generalsabre.sabresdimensions.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // Zalant Blocks
    public static final Block ZALANT_BLOCK = registerBlock("zalant_block",
            new Block(AbstractBlock.Settings.create().strength(5f,6f).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block RAW_ZALANT_BLOCK = registerBlock("raw_zalant_block",
            new Block(AbstractBlock.Settings.create().strength(5f,6f).requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block ZALANT_ORE = registerBlock("zalant_ore",
            new Block(AbstractBlock.Settings.create().strength(3f,3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));


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
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ZALANT_BLOCK);
            fabricItemGroupEntries.add(RAW_ZALANT_BLOCK);
            fabricItemGroupEntries.add(ZALANT_ORE);
            fabricItemGroupEntries.add(ARAKITE);
            fabricItemGroupEntries.add(ARAKITE_BRICKS);
            fabricItemGroupEntries.add(POLISHED_ARAKITE);
            fabricItemGroupEntries.add(ARAKITE_TILES);
            fabricItemGroupEntries.add(CORRODED_ARAKITE);
        });
    }
}
