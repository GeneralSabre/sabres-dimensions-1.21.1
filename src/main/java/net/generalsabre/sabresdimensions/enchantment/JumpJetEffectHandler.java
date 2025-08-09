package net.generalsabre.sabresdimensions.enchantment;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.generalsabre.sabresdimensions.datagen.ModEnchantmentTagProvider;
import net.generalsabre.sabresdimensions.datagen.ModRegistryDataGenerator;
import net.generalsabre.sabresdimensions.util.EnchantmentUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class JumpJetEffectHandler {

    public static boolean isJumpJetOn = false;

    public static RegistryEntry<Enchantment> getJumpJetEntry(DynamicRegistryManager registryManager, ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld(); // safer than player.getWorld()
        registryManager = world.getRegistryManager();
        //System.out.println("i see the entry!!");
        return registryManager.get(RegistryKeys.ENCHANTMENT)
                .getEntry(ModEnchantments.JUMP_JET)
                .orElseThrow();
    }

    public boolean hasJumpJet(ServerPlayerEntity player){
        int x = 0;
        x = EnchantmentHelper.getEquipmentLevel(JumpJetEffectHandler.getJumpJetEntry(DynamicRegistryManager.EMPTY, player), player);
        return x > 0;
    }

    public static Integer JumpJetLevel(ServerPlayerEntity player){
        int level = 0;
        level = EnchantmentHelper.getEquipmentLevel(JumpJetEffectHandler.getJumpJetEntry(DynamicRegistryManager.EMPTY, player), player);
        return level;
    }

    public static void ApplyEffect(ServerPlayerEntity player, Vec3d vec3d){
        MinecraftClient client = MinecraftClient.getInstance();
        System.out.println("is jump jet on? " + isJumpJetOn);
        if (isJumpJetOn){
            if (JumpJetLevel(player) == 1){
                if((client.options.jumpKey.isPressed())){
                    player.addVelocity(0, 0.25, 0);
                    player.velocityModified = true;
                }
            } else if (JumpJetLevel(player) == 2){
                if((client.options.jumpKey.isPressed())){
                    player.addVelocity(0, 0.5, 0);
                    player.velocityModified = true;
                }
            } else if (JumpJetLevel(player) == 3){
                if((client.options.jumpKey.isPressed())){
                    player.addVelocity(0, 0.75, 0);
                    player.velocityModified = true;
                    //System.out.println("i see the inputs!");
                }
            }
        }
    }
}
