package net.generalsabre.sabresdimensions.enchantment;

import com.mojang.serialization.MapCodec;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.generalsabre.sabresdimensions.enchantment.custom.JumpJetEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.EnchantmentLocationBasedEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentLocationBasedEffect> JUMP_JET =
            registerLocationBasedEffect("jump_jet", JumpJetEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentLocationBasedEffect> registerLocationBasedEffect(String name,
                                                                                    MapCodec<? extends EnchantmentLocationBasedEffect> codec){

        return Registry.register(Registries.ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE, Identifier.of(SabresDimensions.MOD_ID, name), codec);
    }

    public static void registerModEnchantmentEffects(){
        SabresDimensions.LOGGER.info("Registering Mod Enchantment Effects for: " + SabresDimensions.MOD_ID);
    }
}
