package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.minecraft.registry.RegistryWrapper;
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
                .add(ModItems.ZALANT_SWORD);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.ZALANT_SHOVEL);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.ZALANT_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.ZALANT_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.ZALANT_HOE);


    }
}
