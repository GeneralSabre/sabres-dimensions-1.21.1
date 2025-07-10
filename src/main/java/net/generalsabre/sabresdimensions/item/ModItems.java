package net.generalsabre.sabresdimensions.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ZALANT_INGOT = registerItem("zalant_ingot", new Item(new Item.Settings()));
    public static final Item RAW_ZALANT = registerItem("raw_zalant", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(SabresDimensions.MOD_ID, name), item);
    }


    public static void registerModItems(){
        SabresDimensions.LOGGER.info("Registering mod items for " + SabresDimensions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ZALANT_INGOT);
            fabricItemGroupEntries.add(RAW_ZALANT);
        });
    }

}
