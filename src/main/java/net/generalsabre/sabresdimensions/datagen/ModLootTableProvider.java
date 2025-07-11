package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.item.ModItems;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ARAKITE);
        addDrop(ModBlocks.ARAKITE_BRICKS);
        addDrop(ModBlocks.ARAKITE_TILES);
        addDrop(ModBlocks.CORRODED_ARAKITE);
        addDrop(ModBlocks.POLISHED_ARAKITE);
        addDrop(ModBlocks.CHORAZINE_POWDER_BLOCK);
        addDrop(ModBlocks.CHORAZINE_ORE, oreDrops(ModBlocks.CHORAZINE_ORE, ModItems.CHORAZINE_DUST));
        addDrop(ModBlocks.DALAMINE_BLOCK);
        addDrop(ModBlocks.DALAMINE_ORE, oreDrops(ModBlocks.DALAMINE_ORE, ModItems.DALAMINE_CRYSTAL));
        addDrop(ModBlocks.PENKAZ_BLOCK);
        addDrop(ModBlocks.RAW_PENKAZ_BLOCK);
        addDrop(ModBlocks.PENKAZ_ORE, oreDrops(ModBlocks.PENKAZ_ORE, ModItems.RAW_PENKAZ));
        addDrop(ModBlocks.PENKAZINE_ALLOY_BLOCK);
        addDrop(ModBlocks.ULAU_BLOCK);
        addDrop(ModBlocks.ZALANT_BLOCK);
        addDrop(ModBlocks.RAW_ZALANT_BLOCK);
        addDrop(ModBlocks.ZALANT_ORE, oreDrops(ModBlocks.ZALANT_ORE, ModItems.RAW_ZALANT));

    }
}
