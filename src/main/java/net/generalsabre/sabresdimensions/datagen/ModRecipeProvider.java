package net.generalsabre.sabresdimensions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.item.custom.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
        createDoorRecipe(ModBlocks.ZALANT_DOOR, Ingredient.ofItems(ModItems.ZALANT_INGOT));
        createTrapdoorRecipe(ModBlocks.ZALANT_TRAPDOOR, Ingredient.ofItems(ModItems.ZALANT_INGOT));
        offerPressurePlateRecipe(recipeExporter, ModBlocks.ZALANT_PRESSURE_PLATE, ModItems.ZALANT_INGOT);


        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.CHORAZINE_DUST, RecipeCategory.MISC, ModBlocks.CHORAZINE_POWDER_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.DALAMINE_CRYSTAL, RecipeCategory.MISC, ModBlocks.DALAMINE_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.LUPAMOONE, RecipeCategory.MISC, ModBlocks.LUPAMOONE_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.ULAU_CLUMP, RecipeCategory.MISC, ModBlocks.ULAU_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.TORCH, 6)
                .pattern("   ")
                .pattern(" U ")
                .pattern(" S ")
                .input('U', ModItems.ULAU_CLUMP)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ULAU_CLUMP), conditionsFromItem(ModItems.ULAU_CLUMP))
                .offerTo(recipeExporter);

        offerSlabRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.ARAKITE_SLAB, ModBlocks.ARAKITE);
        offerSlabRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.ARAKITE_BRICK_SLAB, ModBlocks.ARAKITE_BRICKS);
        offerSlabRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.ARAKITE_TILE_SLAB, ModBlocks.ARAKITE_TILES);
        offerSlabRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.POLISHED_ARAKITE_SLAB, ModBlocks.POLISHED_ARAKITE);

        offerWallRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.ARAKITE_WALL, ModBlocks.ARAKITE);
        offerWallRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.ARAKITE_BRICK_WALL, ModBlocks.ARAKITE_BRICKS);
        offerWallRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.POLISHED_ARAKITE_WALL, ModBlocks.POLISHED_ARAKITE);


        offerPressurePlateRecipe(recipeExporter, ModBlocks.ARAKITE_PRESSURE_PLATE, ModBlocks.ARAKITE);
        offerPressurePlateRecipe(recipeExporter, ModBlocks.POLISHED_ARAKITE_PRESSURE_PLATE, ModBlocks.POLISHED_ARAKITE);



        // Stonecutter
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILES,ModBlocks.POLISHED_ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_BRICKS,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILES,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.POLISHED_ARAKITE,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_SLAB,ModBlocks.ARAKITE,2);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_STAIRS,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_WALL,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_BRICK_WALL,ModBlocks.ARAKITE_BRICKS,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_BRICK_WALL,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_BRICK_SLAB,ModBlocks.ARAKITE_BRICKS,2);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_BRICK_SLAB,ModBlocks.ARAKITE,2);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_BRICK_STAIRS,ModBlocks.ARAKITE_BRICKS,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_BRICK_STAIRS,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILE_STAIRS,ModBlocks.ARAKITE_TILES,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILE_STAIRS,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILE_STAIRS,ModBlocks.POLISHED_ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILE_SLAB,ModBlocks.ARAKITE_TILES,2);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILE_SLAB,ModBlocks.ARAKITE,2);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.ARAKITE_TILE_SLAB,ModBlocks.POLISHED_ARAKITE,2);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.POLISHED_ARAKITE_SLAB,ModBlocks.POLISHED_ARAKITE,2);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.POLISHED_ARAKITE_SLAB,ModBlocks.ARAKITE,2);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.POLISHED_ARAKITE_STAIRS,ModBlocks.POLISHED_ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.POLISHED_ARAKITE_STAIRS,ModBlocks.ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.POLISHED_ARAKITE_WALL,ModBlocks.POLISHED_ARAKITE,1);
        offerStonecuttingRecipe(recipeExporter,RecipeCategory.MISC,ModBlocks.POLISHED_ARAKITE_WALL,ModBlocks.ARAKITE,1);




        // Furnace, Blast Furnace, & Smoker
        List<ItemConvertible> ZALANT_INGOT_SMELTABLES = List.of(ModItems.RAW_ZALANT,ModBlocks.ZALANT_ORE);
        offerSmelting(recipeExporter, ZALANT_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.ZALANT_INGOT,0.2f,200,"zalant_ingot");
        offerBlasting(recipeExporter, ZALANT_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.ZALANT_INGOT,0.2f,100,"zalant_ingot");
        List<ItemConvertible> PENKAZ_INGOT_SMELTABLES = List.of(ModItems.RAW_PENKAZ,ModBlocks.PENKAZ_ORE);
        offerBlasting(recipeExporter, PENKAZ_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.PENKAZ_INGOT,0.4f,100,"penkaz_ingot");
        offerSmelting(recipeExporter, PENKAZ_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.PENKAZ_INGOT,0.4f,200,"penkaz_ingot");
        List<ItemConvertible> ARAKITE_SMELTABLES = List.of(ModBlocks.CORRODED_ARAKITE);
        offerSmelting(recipeExporter, ARAKITE_SMELTABLES, RecipeCategory.MISC, ModBlocks.ARAKITE,0.2f,260,"arakite");



        // Tools & Armor

        // Arakite
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STONE_SWORD)
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .input('A', ModBlocks.ARAKITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.ARAKITE), conditionsFromItem(ModBlocks.ARAKITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STONE_SHOVEL)
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .input('A', ModBlocks.ARAKITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.ARAKITE), conditionsFromItem(ModBlocks.ARAKITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STONE_PICKAXE)
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .input('A', ModBlocks.ARAKITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.ARAKITE), conditionsFromItem(ModBlocks.ARAKITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STONE_AXE)
                .pattern("AA ")
                .pattern("AS ")
                .pattern(" S ")
                .input('A', ModBlocks.ARAKITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.ARAKITE), conditionsFromItem(ModBlocks.ARAKITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.STONE_HOE)
                .pattern("AA ")
                .pattern(" S ")
                .pattern(" S ")
                .input('A', ModBlocks.ARAKITE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.ARAKITE), conditionsFromItem(ModBlocks.ARAKITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.FURNACE)
                .pattern("AAA")
                .pattern("A A")
                .pattern("AAA")
                .input('A', ModBlocks.ARAKITE)
                .criterion(hasItem(ModBlocks.ARAKITE), conditionsFromItem(ModBlocks.ARAKITE))
                .offerTo(recipeExporter);


        // Zalant
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZALANT_SWORD)
                .pattern(" Z ")
                .pattern(" Z ")
                .pattern(" S ")
                .input('Z', ModItems.ZALANT_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ZALANT_INGOT), conditionsFromItem(ModItems.ZALANT_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZALANT_SHOVEL)
                .pattern(" Z ")
                .pattern(" S ")
                .pattern(" S ")
                .input('Z', ModItems.ZALANT_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ZALANT_INGOT), conditionsFromItem(ModItems.ZALANT_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZALANT_PICKAXE)
                .pattern("ZZZ")
                .pattern(" S ")
                .pattern(" S ")
                .input('Z', ModItems.ZALANT_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ZALANT_INGOT), conditionsFromItem(ModItems.ZALANT_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZALANT_AXE)
                .pattern("ZZ ")
                .pattern("ZS ")
                .pattern(" S ")
                .input('Z', ModItems.ZALANT_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ZALANT_INGOT), conditionsFromItem(ModItems.ZALANT_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZALANT_HOE)
                .pattern("ZZ ")
                .pattern(" S ")
                .pattern(" S ")
                .input('Z', ModItems.ZALANT_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.ZALANT_INGOT), conditionsFromItem(ModItems.ZALANT_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZALANT_HELMET)
                .pattern("ZZZ")
                .pattern("Z Z")
                .pattern("   ")
                .input('Z', ModItems.ZALANT_INGOT)
                .criterion(hasItem(ModItems.ZALANT_INGOT), conditionsFromItem(ModItems.ZALANT_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZALANT_CHESTPLATE)
                .pattern("Z Z")
                .pattern("ZZZ")
                .pattern("ZZZ")
                .input('Z', ModItems.ZALANT_INGOT)
                .criterion(hasItem(ModItems.ZALANT_INGOT), conditionsFromItem(ModItems.ZALANT_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZALANT_LEGGINGS)
                .pattern("ZZZ")
                .pattern("Z Z")
                .pattern("Z Z")
                .input('Z', ModItems.ZALANT_INGOT)
                .criterion(hasItem(ModItems.ZALANT_INGOT), conditionsFromItem(ModItems.ZALANT_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ZALANT_BOOTS)
                .pattern("   ")
                .pattern("Z Z")
                .pattern("Z Z")
                .input('Z', ModItems.ZALANT_INGOT)
                .criterion(hasItem(ModItems.ZALANT_INGOT), conditionsFromItem(ModItems.ZALANT_INGOT))
                .offerTo(recipeExporter);

        // Penkazine Alloy
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_SWORD)
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" S ")
                .input('P', ModItems.PENKAZINE_ALLOY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PENKAZINE_ALLOY_INGOT), conditionsFromItem(ModItems.PENKAZINE_ALLOY_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_SHOVEL)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PENKAZINE_ALLOY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PENKAZINE_ALLOY_INGOT), conditionsFromItem(ModItems.PENKAZINE_ALLOY_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_PICKAXE)
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PENKAZINE_ALLOY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PENKAZINE_ALLOY_INGOT), conditionsFromItem(ModItems.PENKAZINE_ALLOY_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_AXE)
                .pattern("PP ")
                .pattern("PS ")
                .pattern(" S ")
                .input('P', ModItems.PENKAZINE_ALLOY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PENKAZINE_ALLOY_INGOT), conditionsFromItem(ModItems.PENKAZINE_ALLOY_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_HOE)
                .pattern("PP ")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PENKAZINE_ALLOY_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.PENKAZINE_ALLOY_INGOT), conditionsFromItem(ModItems.PENKAZINE_ALLOY_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_HELMET)
                .pattern("ZZZ")
                .pattern("Z Z")
                .pattern("   ")
                .input('Z', ModItems.PENKAZINE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.PENKAZINE_ALLOY_INGOT), conditionsFromItem(ModItems.PENKAZINE_ALLOY_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_CHESTPLATE)
                .pattern("Z Z")
                .pattern("ZZZ")
                .pattern("ZZZ")
                .input('Z', ModItems.PENKAZINE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.PENKAZINE_ALLOY_INGOT), conditionsFromItem(ModItems.PENKAZINE_ALLOY_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_LEGGINGS)
                .pattern("ZZZ")
                .pattern("Z Z")
                .pattern("Z Z")
                .input('Z', ModItems.PENKAZINE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.PENKAZINE_ALLOY_INGOT), conditionsFromItem(ModItems.PENKAZINE_ALLOY_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PENKAZINE_ALLOY_BOOTS)
                .pattern("   ")
                .pattern("Z Z")
                .pattern("Z Z")
                .input('Z', ModItems.PENKAZINE_ALLOY_INGOT)
                .criterion(hasItem(ModItems.PENKAZINE_ALLOY_INGOT), conditionsFromItem(ModItems.PENKAZINE_ALLOY_INGOT))
                .offerTo(recipeExporter);

        // LUPAMOONE SHIT

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUPAMOONE_PROCESSOR)
                .pattern(" R ")
                .pattern("RLR")
                .pattern(" R ")
                .input('L', ModItems.LUPAMOONE)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(ModItems.LUPAMOONE), conditionsFromItem(ModItems.LUPAMOONE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LOGIC_CHIP)
                .pattern("RCR")
                .pattern("LLL")
                .pattern("RIR")
                .input('L', ModItems.LUPAMOONE_PROCESSOR)
                .input('C', Blocks.COMPARATOR)
                .input('I', Items.COPPER_INGOT)
                .input('R', Items.REDSTONE)
                .criterion(hasItem(ModItems.LUPAMOONE_PROCESSOR), conditionsFromItem(ModItems.LUPAMOONE_PROCESSOR))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUPAMOONE_CORE)
                .pattern("LML")
                .pattern("MCM")
                .pattern("LML")
                .input('L', ModItems.LOGIC_CHIP)
                .input('M', ModItems.LUPAMOONE)
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(ModItems.LOGIC_CHIP), conditionsFromItem(ModItems.LOGIC_CHIP))
                .offerTo(recipeExporter);
    }
}
