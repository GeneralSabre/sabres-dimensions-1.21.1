package net.generalsabre.sabresdimensions.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
    // DALAMINE
    public static final Item DALAMINE_CRYSTAL = registerItem("dalamine_crystal", new Item(new Item.Settings()));
    // PENKAZINE
    public static final Item CHORAZINE_DUST = registerItem("chorazine_dust", new Item(new Item.Settings()));
    public static final Item PENKAZ_INGOT = registerItem("penkaz_ingot", new Item(new Item.Settings()));
    public static final Item RAW_PENKAZ = registerItem("raw_penkaz", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(SabresDimensions.MOD_ID, name), item);
    }


    public static void registerModItems(){
        SabresDimensions.LOGGER.info("Registering mod items for " + SabresDimensions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ZALANT_INGOT);
            fabricItemGroupEntries.add(RAW_ZALANT);
            fabricItemGroupEntries.add(DALAMINE_CRYSTAL);
            fabricItemGroupEntries.add(ZALANT_ROD);
            fabricItemGroupEntries.add(ARAKITE_ROD);
            fabricItemGroupEntries.add(CHORAZINE_DUST);
            fabricItemGroupEntries.add(PENKAZ_INGOT);
            fabricItemGroupEntries.add(RAW_PENKAZ);
        });
    }

}
