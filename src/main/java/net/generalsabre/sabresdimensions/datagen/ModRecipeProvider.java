package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        // 3x3 -> compressed block
        // See Kaupenjoe's datagen video for explanation of shapeless recipe code
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.PENKAZ_INGOT, RecipeCategory.MISC, ModBlocks.PENKAZ_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_INGOT, RecipeCategory.MISC, ModBlocks.PENKAZINE_ALLOY_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.RAW_PENKAZ, RecipeCategory.MISC, ModBlocks.RAW_PENKAZ_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.RAW_ZALANT, RecipeCategory.MISC, ModBlocks.RAW_ZALANT_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.ZALANT_INGOT, RecipeCategory.MISC, ModBlocks.ZALANT_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.CHORAZINE_DUST, RecipeCategory.MISC, ModBlocks.CHORAZINE_POWDER_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.DALAMINE_CRYSTAL, RecipeCategory.MISC, ModBlocks.DALAMINE_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.ULAU_CLUMP, RecipeCategory.MISC, ModBlocks.ULAU_BLOCK);
        // Stonecutter
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILES,ModBlocks.POLISHED_ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_BRICKS,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILES,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.POLISHED_ARAKITE,ModBlocks.ARAKITE,1);
        // Furnace, Blast Furnace, & Smoker
        List<ItemConvertible> ZALANT_INGOT_SMELTABLES = List.of(ModItems.RAW_ZALANT,ModBlocks.ZALANT_ORE);
        offerSmelting(recipeExporter, ZALANT_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.ZALANT_INGOT,0.2f,200,"zalant_ingot");
        offerBlasting(recipeExporter, ZALANT_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.ZALANT_INGOT,0.2f,100,"zalant_ingot");
        List<ItemConvertible> PENKAZ_INGOT_SMELTABLES = List.of(ModItems.RAW_PENKAZ,ModBlocks.PENKAZ_ORE);
        offerBlasting(recipeExporter, PENKAZ_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.PENKAZ_INGOT,0.4f,100,"penkaz_ingot");
        offerSmelting(recipeExporter, PENKAZ_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.PENKAZ_INGOT,0.4f,200,"penkaz_ingot");
        List<ItemConvertible> ARAKITE_SMELTABLES = List.of(ModBlocks.CORRODED_ARAKITE);
        offerSmelting(recipeExporter, ARAKITE_SMELTABLES, RecipeCategory.MISC, ModBlocks.ARAKITE,0.2f,260,"arakite");
    }
}
