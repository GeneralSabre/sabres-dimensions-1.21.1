package net.generalsabre.sabresdimensions;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.block.entity.ModBlockEntities;
import net.generalsabre.sabresdimensions.enchantment.JumpJetEffectHandler;
import net.generalsabre.sabresdimensions.enchantment.ModEnchantmentEffects;
import net.generalsabre.sabresdimensions.fluid.ModFluids;
import net.generalsabre.sabresdimensions.item.custom.ModItemGroups;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.generalsabre.sabresdimensions.screen.ModScreenHandlers;
import net.generalsabre.sabresdimensions.util.ModKeyBindings;
import net.generalsabre.sabresdimensions.util.ModKeyHandler;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.tick.Tick;
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

		ModKeyBindings.registerModKeyBindings();
		ModKeyHandler.registerKeyHandler();

		ModEnchantmentEffects.registerModEnchantmentEffects();

		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				JumpJetEffectHandler.ApplyEffect(player, new Vec3d(0, 0,0));

			}
		});

	}
}