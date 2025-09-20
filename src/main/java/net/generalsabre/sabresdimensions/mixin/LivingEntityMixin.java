package net.generalsabre.sabresdimensions.mixin;

import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject( // This is adding the shit and telling if it will work
            method = "damage",
            at = @At(
                    value = "HEAD",
                    target = "Lnet/minecraft/entity/LivingEntity;damageEquipment(Lnet/minecraft/entity/damage/DamageSource;F[Lnet/minecraft/entity/EquipmentSlot;)V"

            )
    )
    private void onDamage(
            DamageSource source,
            float amount,
            CallbackInfoReturnable<Boolean> cir
    ) {
        LivingEntity self = (LivingEntity)(Object)this;

        // Ensure attacker exists and is holding the tool we care about
        if (source.getAttacker() instanceof LivingEntity attacker) {
            ItemStack weapon = attacker.getMainHandStack();

            if (weapon.isOf(ModItems.DELETERIUM_INGOT)) {
                // Loop through armor pieces
                for (ItemStack armorPiece : self.getArmorItems()) {
                    if (!armorPiece.isEmpty()) {
                        // Extra damage to durability: e.g., +2 durability per hit
                        armorPiece.damage(100, self, null);
                    }
                }
            }
        }
    }
}
