package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.generalsabre.sabresdimensions.enchantment.ModEnchantments;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.generalsabre.sabresdimensions.util.ModTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.ZALANT_SWORD)
                .add(ModItems.PENKAZINE_ALLOY_SWORD);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ZALANT_SHOVEL)
                .add(ModItems.PENKAZINE_ALLOY_SHOVEL);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ZALANT_PICKAXE)
                .add(ModItems.PENKAZINE_ALLOY_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ZALANT_AXE)
                .add(ModItems.PENKAZINE_ALLOY_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ZALANT_HOE)
                .add(ModItems.PENKAZINE_ALLOY_HOE);

        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.ZALANT_SWORD)
                .add(ModItems.PENKAZINE_ALLOY_SWORD);

        getOrCreateTagBuilder(ItemTags.CROSSBOW_ENCHANTABLE)
                .add(ModItems.HZC);

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.ZALANT_AXE)
                .add(ModItems.PENKAZINE_ALLOY_AXE)
                .add(ModItems.ZALANT_HOE)
                .add(ModItems.PENKAZINE_ALLOY_HOE)
                .add(ModItems.ZALANT_SWORD)
                .add(ModItems.PENKAZINE_ALLOY_SWORD)
                .add(ModItems.ZALANT_PICKAXE)
                .add(ModItems.PENKAZINE_ALLOY_PICKAXE)
                .add(ModItems.ZALANT_SHOVEL)
                .add(ModItems.PENKAZINE_ALLOY_SHOVEL)
                .add(ModItems.ZALANT_HELMET)
                .add(ModItems.ZALANT_CHESTPLATE)
                .add(ModItems.ZALANT_LEGGINGS)
                .add(ModItems.ZALANT_BOOTS)
                .add(ModItems.PENKAZINE_ALLOY_HELMET)
                .add(ModItems.PENKAZINE_ALLOY_CHESTPLATE)
                .add(ModItems.PENKAZINE_ALLOY_LEGGINGS)
                .add(ModItems.HZC)
                .add(ModItems.PENKAZINE_ALLOY_BOOTS);

        getOrCreateTagBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(ModItems.ZALANT_HELMET)
                .add(ModItems.ZALANT_CHESTPLATE)
                .add(ModItems.ZALANT_LEGGINGS)
                .add(ModItems.ZALANT_BOOTS)
                .add(ModItems.PENKAZINE_ALLOY_HELMET)
                .add(ModItems.PENKAZINE_ALLOY_CHESTPLATE)
                .add(ModItems.PENKAZINE_ALLOY_LEGGINGS)
                .add(ModItems.PENKAZINE_ALLOY_BOOTS);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.ZALANT_AXE)
                .add(ModItems.PENKAZINE_ALLOY_AXE)
                .add(ModItems.ZALANT_HOE)
                .add(ModItems.PENKAZINE_ALLOY_HOE)
                .add(ModItems.ZALANT_PICKAXE)
                .add(ModItems.PENKAZINE_ALLOY_PICKAXE)
                .add(ModItems.ZALANT_SHOVEL)
                .add(ModItems.PENKAZINE_ALLOY_SHOVEL);

        getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(ModItems.ZALANT_SWORD)
                .add(ModItems.PENKAZINE_ALLOY_SWORD);

        getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .add(ModItems.ZALANT_AXE)
                .add(ModItems.PENKAZINE_ALLOY_AXE)
                .add(ModItems.ZALANT_HOE)
                .add(ModItems.PENKAZINE_ALLOY_HOE)
                .add(ModItems.ZALANT_SWORD)
                .add(ModItems.PENKAZINE_ALLOY_SWORD)
                .add(ModItems.HZC)
                .add(ModItems.ZALANT_PICKAXE)
                .add(ModItems.PENKAZINE_ALLOY_PICKAXE)
                .add(ModItems.ZALANT_SHOVEL)
                .add(ModItems.PENKAZINE_ALLOY_SHOVEL)
                .add(ModItems.ZALANT_HELMET)
                .add(ModItems.ZALANT_CHESTPLATE)
                .add(ModItems.ZALANT_LEGGINGS)
                .add(ModItems.ZALANT_BOOTS)
                .add(ModItems.PENKAZINE_ALLOY_HELMET)
                .add(ModItems.PENKAZINE_ALLOY_CHESTPLATE)
                .add(ModItems.PENKAZINE_ALLOY_LEGGINGS)
                .add(ModItems.PENKAZINE_ALLOY_BOOTS);

        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.ZALANT_AXE)
                .add(ModItems.PENKAZINE_ALLOY_AXE)
                .add(ModItems.ZALANT_HOE)
                .add(ModItems.PENKAZINE_ALLOY_HOE)
                .add(ModItems.ZALANT_PICKAXE)
                .add(ModItems.PENKAZINE_ALLOY_PICKAXE)
                .add(ModItems.ZALANT_SHOVEL)
                .add(ModItems.PENKAZINE_ALLOY_SHOVEL);

        getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(ModItems.ZALANT_SWORD)
                .add(ModItems.PENKAZINE_ALLOY_SWORD)
                .add(ModItems.ZALANT_AXE)
                .add(ModItems.PENKAZINE_ALLOY_AXE);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.ZALANT_HELMET)
                .add(ModItems.PENKAZINE_ALLOY_HELMET);


        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.ZALANT_CHESTPLATE)
                .add(ModItems.PENKAZINE_ALLOY_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.ZALANT_LEGGINGS)
                .add(ModItems.PENKAZINE_ALLOY_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.ZALANT_BOOTS)
                .add(ModItems.PENKAZINE_ALLOY_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ZALANT_HELMET)
                .add(ModItems.ZALANT_CHESTPLATE)
                .add(ModItems.ZALANT_LEGGINGS)
                .add(ModItems.ZALANT_BOOTS)
                .add(ModItems.PENKAZINE_ALLOY_HELMET)
                .add(ModItems.PENKAZINE_ALLOY_CHESTPLATE)
                .add(ModItems.PENKAZINE_ALLOY_LEGGINGS)
                .add(ModItems.PENKAZINE_ALLOY_BOOTS);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.ZALANT_HELMET)
                .add(ModItems.ZALANT_CHESTPLATE)
                .add(ModItems.ZALANT_LEGGINGS)
                .add(ModItems.ZALANT_BOOTS)
                .add(ModItems.PENKAZINE_ALLOY_HELMET)
                .add(ModItems.PENKAZINE_ALLOY_CHESTPLATE)
                .add(ModItems.PENKAZINE_ALLOY_LEGGINGS)
                .add(ModItems.PENKAZINE_ALLOY_BOOTS);
    }
}
