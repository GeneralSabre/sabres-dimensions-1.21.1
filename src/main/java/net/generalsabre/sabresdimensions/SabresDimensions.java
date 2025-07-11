package net.generalsabre.sabresdimensions;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.item.ModItemGroups;
import net.generalsabre.sabresdimensions.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SabresDimensions implements ModInitializer {
	public static final String MOD_ID = "sabresdimensions";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.ULAU_CLUMP, 2000);
		FuelRegistry.INSTANCE.add(ModBlocks.ULAU_BLOCK, 20000);
	}
}