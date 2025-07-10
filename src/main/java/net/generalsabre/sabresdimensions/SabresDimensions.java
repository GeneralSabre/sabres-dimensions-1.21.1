package net.generalsabre.sabresdimensions;

import net.fabricmc.api.ModInitializer;

import net.generalsabre.sabresdimensions.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SabresDimensions implements ModInitializer {
	public static final String MOD_ID = "sabresdimensions";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}