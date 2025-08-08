package net.generalsabre.sabresdimensions.enchantment;

import net.generalsabre.sabresdimensions.SabresDimensions;
import net.generalsabre.sabresdimensions.enchantment.custom.JumpJetEnchantmentEffect;
import net.generalsabre.sabresdimensions.util.ModTags;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> JUMP_JET =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(SabresDimensions.MOD_ID, "jump_jet"));

    public static void bootstrap(Registerable<Enchantment> registerable){
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, JUMP_JET, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                items.getOrThrow(ItemTags.FOOT_ARMOR),
                5,
                3,
                Enchantment.leveledCost(5, 7),
                Enchantment.leveledCost(25, 9),
                5,
                AttributeModifierSlot.FEET))
                .exclusiveSet(enchantments.getOrThrow(ModTags.Enchantments.BOOTS_EXCLUSIVE_SET_2))
                .addEffect(EnchantmentEffectComponentTypes.LOCATION_CHANGED,
                        new JumpJetEnchantmentEffect()));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder){
        registry.register(key, builder.build(key.getValue()));
    }
}
