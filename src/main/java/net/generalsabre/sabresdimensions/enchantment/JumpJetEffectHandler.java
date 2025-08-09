package net.generalsabre.sabresdimensions.enchantment;

import net.minecraft.client.MinecraftClient;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
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

    public static void onArmorEquip(ServerPlayerEntity player, int currentCharge, int maxCharge){
        getMaxCharge(player, currentCharge, maxCharge);
    }

    public static void getMaxCharge(ServerPlayerEntity player, int maxCharge, int currentCharge){
        int level = 0;
        level = EnchantmentHelper.getEquipmentLevel(JumpJetEffectHandler.getJumpJetEntry(DynamicRegistryManager.EMPTY, player), player);
        if (level == 1){
            maxCharge = 100;
        } else if (level == 2){
            maxCharge = 200;
        } else if (level ==3){
            maxCharge = 300;
        }

        setCurrentCharge(currentCharge, maxCharge);

        //player.onEquipStack(EquipmentSlot.FEET, ItemStack.EMPTY, ItemStack.areItemsEqual());
    }

    private static void setCurrentCharge(int currentCharge, int maxCharge) {
        currentCharge = maxCharge;
    }



    public static void ApplyEffect(ServerPlayerEntity player, Vec3d vec3d, int currentCharge, int maxCharge){

        MinecraftClient client = MinecraftClient.getInstance();
        System.out.println("is jump jet on? " + isJumpJetOn);


        if (isJumpJetOn){
            if (JumpJetLevel(player) == 1){
                if(client.options.jumpKey.isPressed() && currentCharge>0){
                    player.addVelocity(0, 0.25, 0);
                    player.velocityModified = true;
                    currentCharge--;
                }
            } else if (JumpJetLevel(player) == 2){
                if(client.options.jumpKey.isPressed() && currentCharge>0){
                    player.addVelocity(0, 0.5, 0);
                    player.velocityModified = true;
                    currentCharge--;
                }
            } else if (JumpJetLevel(player) == 3){
                if(client.options.jumpKey.isPressed() && currentCharge>0){
                    player.addVelocity(0, 0.75, 0);
                    player.velocityModified = true;
                    currentCharge--;
                    //System.out.println("i see the inputs!");
                }
            }
        }

        getCurrentCharge(player, currentCharge, maxCharge);

    }

    private static void getCurrentCharge(ServerPlayerEntity player, int currentCharge, int maxCharge) {
        if (player.isOnGround() && currentCharge<maxCharge){
            currentCharge++;
        }
    }
}
