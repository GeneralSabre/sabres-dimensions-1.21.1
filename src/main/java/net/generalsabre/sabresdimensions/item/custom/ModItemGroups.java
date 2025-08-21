package net.generalsabre.sabresdimensions.item.custom;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.enchantment.ModEnchantments;
import net.generalsabre.sabresdimensions.fluid.ModFluids;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup SABRES_DIMENSIONS_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SabresDimensions.MOD_ID, "sabres_dimensions_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ARAKITE_BRICKS))
                    .displayName(Text.translatable("itemgroup.sabresdimensions.sabres_dimensions_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ARAKITE);
                        entries.add(ModBlocks.ARAKITE_SLAB);
                        entries.add(ModBlocks.ARAKITE_STAIRS);
                        entries.add(ModBlocks.ARAKITE_WALL);
                        entries.add(ModBlocks.ARAKITE_PRESSURE_PLATE);
                        entries.add(ModBlocks.ARAKITE_BUTTON);
                        entries.add(ModBlocks.ARAKITE_BRICKS);
                        entries.add(ModBlocks.ARAKITE_BRICK_SLAB);
                        entries.add(ModBlocks.ARAKITE_BRICK_STAIRS);
                        entries.add(ModBlocks.ARAKITE_BRICK_WALL);
                        entries.add(ModBlocks.CORRODED_ARAKITE);
                        entries.add(ModBlocks.POLISHED_ARAKITE);
                        entries.add(ModBlocks.POLISHED_ARAKITE_BUTTON);
                        entries.add(ModBlocks.POLISHED_ARAKITE_SLAB);
                        entries.add(ModBlocks.POLISHED_ARAKITE_STAIRS);
                        entries.add(ModBlocks.POLISHED_ARAKITE_WALL);
                        entries.add(ModBlocks.POLISHED_ARAKITE_PRESSURE_PLATE);
                        entries.add(ModBlocks.ARAKITE_TILES);
                        entries.add(ModBlocks.ARAKITE_TILE_SLAB);
                        entries.add(ModBlocks.ARAKITE_TILE_STAIRS);

                        entries.add(ModBlocks.CHORAZINE_ORE);
                        entries.add(ModBlocks.CHORAZINE_POWDER_BLOCK);

                        entries.add(ModBlocks.DALAMINE_BLOCK);
                        entries.add(ModBlocks.DALAMINE_ORE);

                        entries.add(ModBlocks.PENKAZ_BLOCK);
                        entries.add(ModBlocks.PENKAZ_ORE);
                        entries.add(ModBlocks.RAW_PENKAZ_BLOCK);

                        entries.add(ModBlocks.ZALANT_BLOCK);
                        entries.add(ModBlocks.ZALANT_DOOR);
                        entries.add(ModBlocks.ZALANT_TRAPDOOR);
                        entries.add(ModBlocks.ZALANT_PRESSURE_PLATE);
                        entries.add(ModBlocks.RAW_ZALANT_BLOCK);
                        entries.add(ModBlocks.ZALANT_ORE);
                        entries.add(ModBlocks.PENKAZINE_ALLOY_BLOCK);

                        entries.add(ModBlocks.ELASTAU_LOG);
                        entries.add(ModBlocks.ELASTAU_WOOD);
                        entries.add(ModBlocks.STRIPPED_ELASTAU_LOG);
                        entries.add(ModBlocks.STRIPPED_ELASTAU_WOOD);
                        entries.add(ModBlocks.ELASTAU_LEAVES);
                        entries.add(ModBlocks.ELASTAU_SAPLING);

                        entries.add(ModBlocks.ELASTAU_PLANKS);
                        entries.add(ModBlocks.ELASTAU_STAIRS);
                        entries.add(ModBlocks.ELASTAU_SLAB);
                        entries.add(ModBlocks.ELASTAU_FENCE);
                        entries.add(ModBlocks.ELASTAU_FENCE_GATE);
                        entries.add(ModBlocks.ELASTAU_BUTTON);
                        entries.add(ModBlocks.ELASTAU_PRESSURE_PLATE);
                        entries.add(ModBlocks.ELASTAU_DOOR);
                        entries.add(ModBlocks.ELASTAU_TRAPDOOR);

                        entries.add(ModBlocks.KOGNOLI_LOG);
                        entries.add(ModBlocks.KOGNOLI_WOOD);
                        entries.add(ModBlocks.STRIPPED_KOGNOLI_LOG);
                        entries.add(ModBlocks.STRIPPED_KOGNOLI_WOOD);
                        entries.add(ModBlocks.KOGNOLI_LEAVES);
                        entries.add(ModBlocks.KOGNOLI_SAPLING);

                        entries.add(ModBlocks.KOGNOLI_PLANKS);
                        entries.add(ModBlocks.KOGNOLI_STAIRS);
                        entries.add(ModBlocks.KOGNOLI_SLAB);
                        entries.add(ModBlocks.KOGNOLI_FENCE);
                        entries.add(ModBlocks.KOGNOLI_FENCE_GATE);
                        entries.add(ModBlocks.KOGNOLI_BUTTON);
                        entries.add(ModBlocks.KOGNOLI_PRESSURE_PLATE);
                        entries.add(ModBlocks.KOGNOLI_DOOR);
                        entries.add(ModBlocks.KOGNOLI_TRAPDOOR);

                        entries.add(ModBlocks.COULIEM_FLOWER);
                        entries.add(ModBlocks.COULIEM_LEAVES);
                        entries.add(ModBlocks.COULIEM_STEM);

                        entries.add(ModBlocks.ULAU_BLOCK);
                        entries.add(ModBlocks.LUPAMOONE_BLOCK);
                        entries.add(ModBlocks.LUPAMOONE_ORE);

                        entries.add(ModBlocks.ORAXIUM_ORE);
                        entries.add(ModBlocks.DELETERIUM_BLOCK);
                    })

                    .build());
            public static final ItemGroup SABRES_DIMENSIONS_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SabresDimensions.MOD_ID, "sabres_dimensions_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CHORAZINE_DUST))
                    .displayName(Text.translatable("itemgroup.sabresdimensions.sabres_dimensions_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ARAKITE_ROD);
                        entries.add(ModItems.ZALANT_ROD);
                        entries.add(ModItems.RAW_ZALANT);

                        entries.add(ModItems.ZALANT_INGOT);
                        entries.add(ModItems.ZALANT_SWORD);
                        entries.add(ModItems.ZALANT_SHOVEL);
                        entries.add(ModItems.ZALANT_PICKAXE);
                        entries.add(ModItems.ZALANT_AXE);
                        entries.add(ModItems.ZALANT_HOE);
                        entries.add(ModItems.HZC);

                        entries.add(ModItems.ZALANT_HELMET);
                        entries.add(ModItems.ZALANT_CHESTPLATE);
                        entries.add(ModItems.ZALANT_LEGGINGS);
                        entries.add(ModItems.ZALANT_BOOTS);

                        entries.add(ModItems.PENKAZ_INGOT);
                        entries.add(ModItems.RAW_PENKAZ);
                        entries.add(ModItems.DALAMINE_CRYSTAL);

                        entries.add(ModItems.PENKAZINE_ALLOY_INGOT);
                        entries.add(ModItems.PENKAZINE_ALLOY_SWORD);
                        entries.add(ModItems.PENKAZINE_ALLOY_SHOVEL);
                        entries.add(ModItems.PENKAZINE_ALLOY_PICKAXE);
                        entries.add(ModItems.PENKAZINE_ALLOY_AXE);
                        entries.add(ModItems.PENKAZINE_ALLOY_HOE);

                        entries.add(ModItems.PENKAZINE_ALLOY_HELMET);
                        entries.add(ModItems.PENKAZINE_ALLOY_CHESTPLATE);
                        entries.add(ModItems.PENKAZINE_ALLOY_LEGGINGS);
                        entries.add(ModItems.PENKAZINE_ALLOY_BOOTS);

                        entries.add(ModItems.CHORAZINE_DUST);
                        entries.add(ModItems.ULAU_CLUMP);
                        entries.add(ModItems.COATED_STRING);
                        entries.add(ModItems.LUPAMOONE);
                        entries.add(ModItems.LUPAMOONE_PROCESSOR);
                        entries.add(ModItems.LOGIC_CHIP);
                        entries.add(ModItems.LUPAMOONE_CORE);

                        entries.add(ModItems.CRUSHED_ORAXIUM);
                        entries.add(ModItems.RAW_ORAXIUM);
                        entries.add(ModItems.COOLED_SLAG);
                        entries.add(ModItems.DELETERIUM_INGOT);

                        entries.add(ModBlocks.TARRO_PLANT);
                    })
                    .build());
    public static final ItemGroup SABRES_DIMENSIONS_MISC = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SabresDimensions.MOD_ID, "sabres_dimensions_misc"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModFluids.BUCKET_OF_MOLTEN_DELETERIUM))
                    .displayName(Text.translatable("itemgroup.sabresdimensions.sabres_dimensions_misc"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModFluids.BUCKET_OF_MOLTEN_DELETERIUM);
                        entries.add(ModBlocks.ALLOY_FURNACE);
                        entries.add(ModBlocks.CRUSHER);
                        entries.add(ModBlocks.INGOT_PRESS);
                        entries.add(ModBlocks.INDUSTRIAL_FURNACE);

                    })
                    .build());

    public static void registerItemGroups(){
        SabresDimensions.LOGGER.info("Registering item groups for " + SabresDimensions.MOD_ID);
    }
}
