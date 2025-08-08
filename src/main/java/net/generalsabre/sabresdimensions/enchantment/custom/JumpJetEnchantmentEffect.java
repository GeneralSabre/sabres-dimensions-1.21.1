package net.generalsabre.sabresdimensions.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.EnchantmentLocationBasedEffect;
import net.minecraft.enchantment.effect.entity.SpawnParticlesEnchantmentEffect;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public record JumpJetEnchantmentEffect() implements EnchantmentLocationBasedEffect {

    public static final MapCodec<JumpJetEnchantmentEffect> CODEC = MapCodec.unit(JumpJetEnchantmentEffect::new);

    private static final Map<UUID, Boolean> lastOnGroundMap = new HashMap<>();

    private void triggerEnchantmentEffect(ServerPlayerEntity player, int level, Vec3d pos) {
        if (level == 1){
            player.addVelocity(0, .5, 0);
        } else if (level == 2){
            player.addVelocity(0, 1, 0);
        } else if (level == 3){
            player.addVelocity(0, 2, 0);
        }
    }

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos, boolean newlyApplied) {
        if (!(user instanceof ServerPlayerEntity player)) return;

        boolean wasOnGround = lastOnGroundMap.getOrDefault(player.getUuid(), false);
        boolean onGroundNow = player.isOnGround();

        if (!onGroundNow && wasOnGround && player.getVelocity().y > 0) {
            triggerEnchantmentEffect(player, level, pos);
        }

        lastOnGroundMap.put(player.getUuid(), onGroundNow);
    }

    @Override
    public MapCodec<? extends EnchantmentLocationBasedEffect> getCodec() {
        return CODEC;
    }
}
