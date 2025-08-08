package net.generalsabre.sabresdimensions.util;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.generalsabre.sabresdimensions.enchantment.custom.JumpJetEnchantmentEffect;

public class ModKeyHandler {

    public static void registerKeyHandler(){
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {

            while (ModKeyBindings.JUMP_JET_KEY.wasPressed()){
                if (!JumpJetEnchantmentEffect.isJumpJetOn){
                    JumpJetEnchantmentEffect.isJumpJetOn = true;

                } else {
                    JumpJetEnchantmentEffect.isJumpJetOn = false;
                }
            }

        });
    }
}
