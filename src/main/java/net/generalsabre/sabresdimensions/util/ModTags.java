package net.generalsabre.sabresdimensions.util;

import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_ZALANT_TOOL = createTag("needs_zalant_tool");
        public static final TagKey<Block> INCORRECT_FOR_ZALANT_TOOL = createTag("incorrect_for_zalant_tool");
        public static final TagKey<Block> NEEDS_PENKAZINE_TOOL = createTag("needs_penkazine_tool");
        public static final TagKey<Block> INCORRECT_FOR_PENKAZINE_TOOL = createTag("incorrect_for_penkazine_tool");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SabresDimensions.MOD_ID, name));
        }

    }
    public static class Items{
        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SabresDimensions.MOD_ID, name));
        }

    }

    public static class Enchantments{

        public static final TagKey<Enchantment> BOOTS_EXCLUSIVE_SET_2 = createTag("boots_exclusive_set_2");

        private static TagKey<Enchantment> createTag(String name){
            return TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(SabresDimensions.MOD_ID, name));
        }
    }

}
