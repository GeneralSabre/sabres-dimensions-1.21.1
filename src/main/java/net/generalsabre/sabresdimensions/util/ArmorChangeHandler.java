package net.generalsabre.sabresdimensions.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.generalsabre.sabresdimensions.enchantment.JumpJetEffectHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.server.network.ServerPlayerEntity;



public class ArmorChangeHandler {
    public static void register(ServerPlayerEntity playerEntity, int[] chargeList) {
        ServerEntityEvents.EQUIPMENT_CHANGE.register((LivingEntity entity, EquipmentSlot slot, ItemStack prev, ItemStack curr) -> {

            int currentCharge1 = 0;
            int maxCharge1 = 0;


            if (entity instanceof PlayerEntity player && slot == EquipmentSlot.FEET) {
                chargeList[0] = getMaxCharge(playerEntity, maxCharge1);
                chargeList[1] = setCurrentCharge(currentCharge1);

            }
        });
    }

    public static Integer getMaxCharge(ServerPlayerEntity player, int maxCharge){
        int level = 0;
        level = EnchantmentHelper.getEquipmentLevel(JumpJetEffectHandler.getJumpJetEntry(DynamicRegistryManager.EMPTY, player), player);

        if (level == 1){
            maxCharge = 10;
        } else if (level == 2){
            maxCharge = 15;
        } else if (level ==3){
            maxCharge = 20;
        }
        return maxCharge;
    }

    public static Integer setCurrentCharge(int maxCharge) {
        return maxCharge;
    }
}
