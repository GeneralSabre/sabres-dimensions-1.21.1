package net.generalsabre.sabresdimensions.util;

import net.generalsabre.sabresdimensions.enchantment.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;

public class EnchantmentUtil{
    public static RegistryEntry<Enchantment> getJumpJetEntry(DynamicRegistryManager registryManager) {
        return registryManager.get(RegistryKeys.ENCHANTMENT)
                .getEntry(ModEnchantments.JUMP_JET)
                .orElseThrow(() -> new IllegalStateException("Jump Jet enchantment not registered!"));
    }
}




