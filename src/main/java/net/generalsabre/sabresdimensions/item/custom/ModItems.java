package net.generalsabre.sabresdimensions.item.custom;

import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // ARAKITE
    public static final Item ARAKITE_ROD = registerItem("arakite_rod", new Item(new Item.Settings()));
    // ZALANT
    public static final Item ZALANT_INGOT = registerItem("zalant_ingot", new Item(new Item.Settings()));
    public static final Item RAW_ZALANT = registerItem("raw_zalant", new Item(new Item.Settings()));
    public static final Item ZALANT_ROD = registerItem("zalant_rod", new Item(new Item.Settings()));
    public static final Item ZALANT_SWORD = registerItem("zalant_sword",
            new SwordItem(ModToolMaterials.ZALANT, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ZALANT,3,-2.2f))));
    public static final Item ZALANT_SHOVEL = registerItem("zalant_shovel",
            new ShovelItem(ModToolMaterials.ZALANT, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ZALANT,1.5f,-3f))));
    public static final Item ZALANT_PICKAXE = registerItem("zalant_pickaxe",
            new PickaxeItem(ModToolMaterials.ZALANT, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ZALANT,1,-2.8f))));
    public static final Item ZALANT_AXE = registerItem("zalant_axe",
            new AxeItem(ModToolMaterials.ZALANT, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ZALANT,6,-3.2f))));
    public static final Item ZALANT_HOE = registerItem("zalant_hoe",
            new HoeItem(ModToolMaterials.ZALANT, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.ZALANT,0,-3f))));
    public static final Item ZALANT_HELMET = registerItem("zalant_helmet",
            new ArmorItem(ModArmorMaterials.ZALANT_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item ZALANT_CHESTPLATE = registerItem("zalant_chestplate",
            new ArmorItem(ModArmorMaterials.ZALANT_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item ZALANT_LEGGINGS = registerItem("zalant_leggings",
            new ArmorItem(ModArmorMaterials.ZALANT_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item ZALANT_BOOTS = registerItem("zalant_boots",
            new ArmorItem(ModArmorMaterials.ZALANT_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    // DALAMINE
    public static final Item DALAMINE_CRYSTAL = registerItem("dalamine_crystal", new Item(new Item.Settings()));
    // PENKAZINE
    public static final Item CHORAZINE_DUST = registerItem("chorazine_dust", new Item(new Item.Settings()));
    public static final Item PENKAZ_INGOT = registerItem("penkaz_ingot", new Item(new Item.Settings()));
    public static final Item RAW_PENKAZ = registerItem("raw_penkaz", new Item(new Item.Settings()));
    public static final Item PENKAZINE_ALLOY_INGOT = registerItem("penkazine_alloy_ingot", new Item(new Item.Settings()));
    public static final Item PENKAZINE_ALLOY_SWORD = registerItem("penkazine_alloy_sword",
            new SwordItem(ModToolMaterials.PENKAZINE_ALLOY, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.PENKAZINE_ALLOY,3,-2.4f))));
    public static final Item PENKAZINE_ALLOY_SHOVEL = registerItem("penkazine_alloy_shovel",
            new ShovelItem(ModToolMaterials.PENKAZINE_ALLOY, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.PENKAZINE_ALLOY,1.5f,-3f))));
    public static final Item PENKAZINE_ALLOY_PICKAXE = registerItem("penkazine_alloy_pickaxe",
            new PickaxeItem(ModToolMaterials.PENKAZINE_ALLOY, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.PENKAZINE_ALLOY,1,-2.8f))));
    public static final Item PENKAZINE_ALLOY_AXE = registerItem("penkazine_alloy_axe",
            new AxeItem(ModToolMaterials.PENKAZINE_ALLOY, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.PENKAZINE_ALLOY,6,-3.2f))));
    public static final Item PENKAZINE_ALLOY_HOE = registerItem("penkazine_alloy_hoe",
            new HoeItem(ModToolMaterials.PENKAZINE_ALLOY, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.PENKAZINE_ALLOY,0,-3f))));
    public static final Item PENKAZINE_ALLOY_HELMET = registerItem("penkazine_alloy_helmet",
            new ArmorItem(ModArmorMaterials.PENKAZINE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40))));
    public static final Item PENKAZINE_ALLOY_CHESTPLATE = registerItem("penkazine_alloy_chestplate",
            new ArmorItem(ModArmorMaterials.PENKAZINE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40))));
    public static final Item PENKAZINE_ALLOY_LEGGINGS = registerItem("penkazine_alloy_leggings",
            new ArmorItem(ModArmorMaterials.PENKAZINE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40))));
    public static final Item PENKAZINE_ALLOY_BOOTS = registerItem("penkazine_alloy_boots",
            new ArmorItem(ModArmorMaterials.PENKAZINE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40))));
    // MISC
    public static final Item ULAU_CLUMP = registerItem("ulau_clump", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(SabresDimensions.MOD_ID, name), item);
    }


    public static void registerModItems(){
        SabresDimensions.LOGGER.info("Registering mod items for " + SabresDimensions.MOD_ID);

    }

}
