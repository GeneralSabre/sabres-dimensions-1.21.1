package net.generalsabre.sabresdimensions.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.generalsabre.sabresdimensions.screen.custom.AlloyFurnaceScreen;
import net.generalsabre.sabresdimensions.screen.custom.AlloyFurnaceScreenHandler;
import net.generalsabre.sabresdimensions.screen.custom.CrusherScreenHandler;
import net.generalsabre.sabresdimensions.screen.custom.IngotPressScreenHandler;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;



public class ModScreenHandlers {

     public static final ScreenHandlerType<AlloyFurnaceScreenHandler> ALLOY_FURNACE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SabresDimensions.MOD_ID, "alloy_furnace_screen_handler"),
                   new ExtendedScreenHandlerType<>(AlloyFurnaceScreenHandler::new, BlockPos.PACKET_CODEC));
     public static final ScreenHandlerType<CrusherScreenHandler> CRUSHER_SCREEN_HANDLER =
             Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SabresDimensions.MOD_ID,"crusher_screen_handler"),
                     new ExtendedScreenHandlerType<>(CrusherScreenHandler::new, BlockPos.PACKET_CODEC));
     public static final ScreenHandlerType<IngotPressScreenHandler> INGOT_PRESS_SCREEN_HANDLER =
             Registry.register(Registries.SCREEN_HANDLER, Identifier.of(SabresDimensions.MOD_ID,"ingot_press_screen_handler"),
                     new ExtendedScreenHandlerType<>(IngotPressScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers(){
        SabresDimensions.LOGGER.info("Registering Screen Handlers for " + SabresDimensions.MOD_ID);
    }
}
