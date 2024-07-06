package net.cathienova.havenede.datagen.recipes;

import net.cathienova.havenede.HavenEDE;
import net.cathienova.havenede.block.ModBlocks;
import net.cathienova.havenede.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import thedarkcolour.exdeorum.registry.EBlocks;
import thedarkcolour.exdeorum.registry.EItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(PackOutput pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> output)
    {
        mechanicalHammerRecipe(output, ModBlocks.golden_mechanical_hammer.get(), Items.GOLD_INGOT, Items.GOLD_BLOCK, EBlocks.MECHANICAL_HAMMER.get());
        mechanicalSieveRecipe(output, ModBlocks.golden_mechanical_sieve.get(), Items.GOLD_BLOCK, EBlocks.MECHANICAL_SIEVE.get());

        mechanicalHammerRecipe(output, ModBlocks.diamond_mechanical_hammer.get(), Items.DIAMOND, Items.DIAMOND_BLOCK, ModBlocks.golden_mechanical_hammer.get());
        mechanicalSieveRecipe(output, ModBlocks.diamond_mechanical_sieve.get(), Items.DIAMOND_BLOCK, ModBlocks.golden_mechanical_sieve.get());

        upgradeSmithing(output, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModBlocks.diamond_mechanical_hammer.get(), Items.NETHERITE_BLOCK, ModBlocks.netherite_mechanical_hammer.get().asItem());
        upgradeSmithing(output, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModBlocks.diamond_mechanical_sieve.get(), Items.NETHERITE_BLOCK, ModBlocks.netherite_mechanical_sieve.get().asItem());
    }

    protected static void mechanicalHammerRecipe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient, ItemLike ingredient2, ItemLike machine)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("III")
                .pattern("IMI")
                .pattern("BBB")
                .define('I', ingredient)
                .define('M', machine)
                .define('B', ingredient2)
                .unlockedBy("has_" + getItemName(machine), has(machine))
                .save(consumer, HavenEDE.MOD_ID + ":craft/" + getItemName(result));
    }

    protected static void mechanicalSieveRecipe(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike ingredient, ItemLike machine)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result, 1)
                .pattern("BGB")
                .pattern("IMI")
                .pattern("I I")
                .define('G', Tags.Items.GLASS)
                .define('B', ingredient)
                .define('M', machine)
                .define('I', Items.IRON_BARS)
                .unlockedBy("has_" + getItemName(machine), has(machine))
                .save(consumer, HavenEDE.MOD_ID + ":craft/" + getItemName(result));
    }

    protected static void upgradeSmithing(Consumer<FinishedRecipe> consumer, ItemLike template, ItemLike base, ItemLike addition, Item result)
    {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(base), Ingredient.of(addition), RecipeCategory.MISC, result)
                .unlocks("has_" + getItemName(base), has(base))
                .save(consumer, HavenEDE.MOD_ID + ":smithing/" + getItemName(result));
    }
}
