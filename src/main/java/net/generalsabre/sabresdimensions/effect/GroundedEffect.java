package net.generalsabre.sabresdimensions.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class GroundedEffect extends StatusEffect {

    protected GroundedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (entity.getVelocity().y > 0){
            Vec3d currentVelo = entity.getVelocity();
            Vec3d newVelo = new Vec3d(currentVelo.x, -0.25D, currentVelo.z);
            entity.setVelocity(newVelo.multiply(0.4D));
            return true;
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
