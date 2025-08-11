package net.generalsabre.sabresdimensions.effect;

import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> GROUNDED = registerStatusEffect("grounded",
            new GroundedEffect(StatusEffectCategory.HARMFUL, 0)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            Identifier.of(SabresDimensions.MOD_ID, "grounded"), -0.1f,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(SabresDimensions.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        SabresDimensions.LOGGER.info("Registering mod effects for: " + SabresDimensions.MOD_ID);
    }
}
