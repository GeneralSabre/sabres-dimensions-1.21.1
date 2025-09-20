package net.generalsabre.sabresdimensions;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.block.entity.ModBlockEntities;
import net.generalsabre.sabresdimensions.effect.ModEffects;
import net.generalsabre.sabresdimensions.enchantment.JumpJetEffectHandler;
import net.generalsabre.sabresdimensions.enchantment.ModEnchantmentEffects;
import net.generalsabre.sabresdimensions.fluid.ModFluids;
import net.generalsabre.sabresdimensions.item.custom.ModItemGroups;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.generalsabre.sabresdimensions.screen.ModScreenHandlers;
import net.generalsabre.sabresdimensions.util.ArmorChangeHandler;
import net.generalsabre.sabresdimensions.util.ModKeyBindings;
import net.generalsabre.sabresdimensions.util.ModKeyHandler;
import net.generalsabre.sabresdimensions.util.ModModelPredicates;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
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

		ModFluids.register();
		ModScreenHandlers.registerScreenHandlers();
		ModBlockEntities.registerBlockEntities();
		ModEffects.registerEffects();
		ModModelPredicates.registerModelPredicates();

		ModKeyBindings.registerModKeyBindings();
		ModKeyHandler.registerKeyHandler();

		ModEnchantmentEffects.registerModEnchantmentEffects();

		StrippableBlockRegistry.register(ModBlocks.ELASTAU_LOG, ModBlocks.STRIPPED_ELASTAU_LOG);
		StrippableBlockRegistry.register(ModBlocks.ELASTAU_WOOD, ModBlocks.STRIPPED_ELASTAU_WOOD);

		int[] chargeList = new int[2];
		chargeList[0] = 0; // max
		chargeList[1] = 1; // current

		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

				ArmorChangeHandler.register(player, chargeList);

				//System.out.println("charge, max: " + chargeList[0]);
				//System.out.println("charge, current: " + chargeList[1]);

				JumpJetEffectHandler.ApplyEffect(player, new Vec3d(0, 0,0), chargeList);

			}
		});

	}
}