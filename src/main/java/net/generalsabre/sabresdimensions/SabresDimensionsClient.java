package net.generalsabre.sabresdimensions;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.generalsabre.sabresdimensions.fluid.ModFluids;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class SabresDimensionsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MOLTEN_DELETERIUM, ModFluids.FLOWING_MOLTEN_DELETERIUM,
                new SimpleFluidRenderHandler(
                        Identifier.of(SabresDimensions.MOD_ID, "block/molten_deleterium_still"),
                        Identifier.of(SabresDimensions.MOD_ID, "block/molten_deleterium_flow"),
                        0xA1E038D0
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_MOLTEN_DELETERIUM, ModFluids.FLOWING_MOLTEN_DELETERIUM);
    }
}

