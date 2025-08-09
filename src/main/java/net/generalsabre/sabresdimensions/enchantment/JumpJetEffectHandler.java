package net.generalsabre.sabresdimensions.enchantment;

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
    public static int i = 0;

    public static RegistryEntry<Enchantment> getJumpJetEntry(DynamicRegistryManager registryManager, ServerPlayerEntity player) {
        ServerWorld world = player.getServerWorld(); // safer than player.getWorld()
        registryManager = world.getRegistryManager();
        //System.out.println("i see the entry!!");
        return registryManager.get(RegistryKeys.ENCHANTMENT)
                .getEntry(ModEnchantments.JUMP_JET)
                .orElseThrow();
    }

    public static Integer JumpJetLevel(ServerPlayerEntity player){
        int level = 0;
        level = EnchantmentHelper.getEquipmentLevel(JumpJetEffectHandler.getJumpJetEntry(DynamicRegistryManager.EMPTY, player), player);
        return level;
    }

    public static void ApplyEffect(ServerPlayerEntity player, Vec3d vec3d, int[] chargeList){
        MinecraftClient client = MinecraftClient.getInstance();
        System.out.println("is jump jet on? " + isJumpJetOn);
        chargeList[1] = getCurrentCharge(player, chargeList);

        if (isJumpJetOn){
            if (JumpJetLevel(player) == 1){
                if(client.options.jumpKey.isPressed() && chargeList[1]>0){
                    player.addVelocity(0, 0.25, 0);
                    player.velocityModified = true;
                    chargeList[1]--;
                }
            } else if (JumpJetLevel(player) == 2){
                if(client.options.jumpKey.isPressed() && chargeList[1]>0){
                    player.addVelocity(0, 0.25, 0);
                    player.velocityModified = true;
                    chargeList[1]--;
                }
            } else if (JumpJetLevel(player) == 3){
                if(client.options.jumpKey.isPressed() && chargeList[1]>0){
                    player.addVelocity(0, 0.25, 0);
                    player.velocityModified = true;
                    chargeList[1]--;
                    System.out.println("i see the inputs!");
                }
            }
        }
    }

    private static Integer getCurrentCharge(ServerPlayerEntity player, int[] chargeList) {
        if (player.isOnGround() && chargeList[1]<chargeList[0]){
            //chargeList[1]++;
            i++;
            if (i==4){
                chargeList[1]++;
                i=0;
            }
        }

        return chargeList[1];
    }
}
