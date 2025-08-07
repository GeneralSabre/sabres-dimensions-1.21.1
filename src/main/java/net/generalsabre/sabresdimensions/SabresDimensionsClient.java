package net.generalsabre.sabresdimensions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.fluid.ModFluids;
import net.generalsabre.sabresdimensions.screen.ModScreenHandlers;
import net.generalsabre.sabresdimensions.screen.custom.CrusherScreen;
import net.generalsabre.sabresdimensions.screen.custom.IndustrialFurnaceScreen;
import net.generalsabre.sabresdimensions.screen.custom.IngotPressScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.generalsabre.sabresdimensions.screen.custom.AlloyFurnaceScreen;

public class SabresDimensionsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ZALANT_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ZALANT_DOOR, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MOLTEN_DELETERIUM, ModFluids.FLOWING_MOLTEN_DELETERIUM,
                new SimpleFluidRenderHandler(
                        Identifier.of(SabresDimensions.MOD_ID, "block/molten_deleterium_still"),
                        Identifier.of(SabresDimensions.MOD_ID, "block/molten_deleterium_flow"),
                        0xA1E038D0
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_MOLTEN_DELETERIUM, ModFluids.FLOWING_MOLTEN_DELETERIUM);

        HandledScreens.register(ModScreenHandlers.ALLOY_FURNACE_SCREEN_HANDLER, AlloyFurnaceScreen::new);
        HandledScreens.register(ModScreenHandlers.CRUSHER_SCREEN_HANDLER, CrusherScreen::new);
        HandledScreens.register(ModScreenHandlers.INGOT_PRESS_SCREEN_HANDLER, IngotPressScreen::new);
        HandledScreens.register(ModScreenHandlers.INDUSTRIAL_FURNACE_SCREEN_HANDLER, IndustrialFurnaceScreen::new);
    }
}

