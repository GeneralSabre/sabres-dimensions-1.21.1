package net.generalsabre.sabresdimensions.enchantment;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.generalsabre.sabresdimensions.datagen.ModEnchantmentTagProvider;
import net.generalsabre.sabresdimensions.util.EnchantmentUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.server.network.ServerPlayerEntity;

public class JumpJetEffectHandler {

    public static void tickEffectHandler(ServerPlayerEntity player){
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            JumpJetEffectHandler.ApplyEffect(player);
        });
    }

    public boolean hasJumpJet(ServerPlayerEntity player){
        int x = 0;
        x = EnchantmentHelper.getEquipmentLevel(EnchantmentUtil.getJumpJetEntry(DynamicRegistryManager.EMPTY), player);
        return x > 0;
    }

    public static Integer JumpJetLevel(ServerPlayerEntity player){
        int level = 0;
        level = EnchantmentHelper.getEquipmentLevel(EnchantmentUtil.getJumpJetEntry(DynamicRegistryManager.EMPTY), player);
        return level;
    }

    public static void ApplyEffect(ServerPlayerEntity player){
        MinecraftClient client = MinecraftClient.getInstance();
        if (JumpJetLevel(player) == 1){
            if((client.options.jumpKey.isPressed())){
                player.addVelocity(0, 0.25, 0);
            }
        } else if (JumpJetLevel(player) == 2){
            if((client.options.jumpKey.isPressed())){
                player.addVelocity(0, 0.5, 0);
            }
        } else if (JumpJetLevel(player) == 3){
            if((client.options.jumpKey.isPressed())){
                player.addVelocity(0, 0.75, 0);
            }
        }
    }
}
