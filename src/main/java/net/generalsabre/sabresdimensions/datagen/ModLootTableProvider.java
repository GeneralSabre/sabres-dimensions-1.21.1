package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ARAKITE);
        addDrop(ModBlocks.ARAKITE_STAIRS);
        addDrop(ModBlocks.ARAKITE_WALL);
        addDrop(ModBlocks.ARAKITE_BUTTON);
        addDrop(ModBlocks.ARAKITE_PRESSURE_PLATE);
        addDrop(ModBlocks.ARAKITE_SLAB, slabDrops(ModBlocks.ARAKITE_SLAB));
        addDrop(ModBlocks.ARAKITE_BRICKS);
        addDrop(ModBlocks.ARAKITE_BRICK_SLAB,slabDrops(ModBlocks.ARAKITE_BRICK_SLAB));
        addDrop(ModBlocks.ARAKITE_BRICK_STAIRS);
        addDrop(ModBlocks.ARAKITE_BRICK_WALL);
        addDrop(ModBlocks.ARAKITE_TILES);
        addDrop(ModBlocks.ARAKITE_TILE_SLAB,slabDrops(ModBlocks.ARAKITE_TILE_SLAB));
        addDrop(ModBlocks.ARAKITE_TILE_STAIRS);
        addDrop(ModBlocks.CORRODED_ARAKITE);
        addDrop(ModBlocks.POLISHED_ARAKITE_BUTTON);
        addDrop(ModBlocks.POLISHED_ARAKITE_PRESSURE_PLATE);
        addDrop(ModBlocks.POLISHED_ARAKITE_WALL);
        addDrop(ModBlocks.POLISHED_ARAKITE_STAIRS);
        addDrop(ModBlocks.POLISHED_ARAKITE_SLAB,slabDrops(ModBlocks.POLISHED_ARAKITE_SLAB));
        addDrop(ModBlocks.POLISHED_ARAKITE);

        addDrop(ModBlocks.CHORAZINE_POWDER_BLOCK);
        addDrop(ModBlocks.CHORAZINE_ORE, oreDrops(ModBlocks.CHORAZINE_ORE, ModItems.CHORAZINE_DUST));

        addDrop(ModBlocks.DALAMINE_BLOCK);
        addDrop(ModBlocks.LUPAMOONE_BLOCK);
        addDrop(ModBlocks.DALAMINE_ORE, oreDrops(ModBlocks.DALAMINE_ORE, ModItems.DALAMINE_CRYSTAL));
        addDrop(ModBlocks.LUPAMOONE_ORE, oreDrops(ModBlocks.LUPAMOONE_ORE, ModItems.LUPAMOONE));

        addDrop(ModBlocks.PENKAZ_BLOCK);
        addDrop(ModBlocks.RAW_PENKAZ_BLOCK);
        addDrop(ModBlocks.PENKAZ_ORE, oreDrops(ModBlocks.PENKAZ_ORE, ModItems.RAW_PENKAZ));

        addDrop(ModBlocks.PENKAZINE_ALLOY_BLOCK);

        addDrop(ModBlocks.ULAU_BLOCK);

        addDrop(ModBlocks.ZALANT_BLOCK);
        addDrop(ModBlocks.ZALANT_DOOR,doorDrops(ModBlocks.ZALANT_DOOR));
        addDrop(ModBlocks.ZALANT_TRAPDOOR);
        addDrop(ModBlocks.RAW_ZALANT_BLOCK);

        addDrop(ModBlocks.ZALANT_ORE, oreDrops(ModBlocks.ZALANT_ORE, ModItems.RAW_ZALANT));

        addDrop(ModBlocks.ORAXIUM_ORE, oreDrops(ModBlocks.ORAXIUM_ORE, ModItems.RAW_ORAXIUM));
        addDrop(ModBlocks.DELETERIUM_BLOCK);

    }
}
