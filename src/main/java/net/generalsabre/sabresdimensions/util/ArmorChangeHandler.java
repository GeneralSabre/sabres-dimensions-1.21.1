package net.generalsabre.sabresdimensions.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.generalsabre.sabresdimensions.enchantment.JumpJetEffectHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;



public class ArmorChangeHandler {
    public static void register(ServerPlayerEntity playerEntity, int currentCharge, int maxCharge) {
        ServerEntityEvents.EQUIPMENT_CHANGE.register((LivingEntity entity, EquipmentSlot slot, ItemStack prev, ItemStack curr) -> {
            if (entity instanceof PlayerEntity player && slot == EquipmentSlot.FEET) {
                JumpJetEffectHandler.onArmorEquip(playerEntity, currentCharge, maxCharge);
            }
        });
    }
}
