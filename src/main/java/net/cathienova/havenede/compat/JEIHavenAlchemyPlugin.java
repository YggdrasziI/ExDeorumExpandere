package net.cathienova.havenede.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.handlers.IGuiClickableArea;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.cathienova.havenede.HavenEDE;
import net.cathienova.havenede.block.ModBlocks;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fml.ModList;
import thedarkcolour.exdeorum.client.screen.MechanicalHammerScreen;
import thedarkcolour.exdeorum.client.screen.MechanicalSieveScreen;
import thedarkcolour.exdeorum.client.screen.RedstoneControlWidget;
import thedarkcolour.exdeorum.compat.GroupedSieveRecipe;
import thedarkcolour.exdeorum.compat.jei.ExDeorumJeiPlugin;
import thedarkcolour.exdeorum.recipe.hammer.HammerRecipe;
import thedarkcolour.exdeorum.registry.EItems;

import java.util.Collection;
import java.util.List;

@JeiPlugin
public class JEIHavenAlchemyPlugin implements IModPlugin
{
    @Override
    public ResourceLocation getPluginUid()
    {
        return new ResourceLocation(HavenEDE.MOD_ID, "jei_plugin");
    }
    static final RecipeType<HammerRecipe> HAMMER = recipeType("hammer", HammerRecipe.class);
    static final RecipeType<GroupedSieveRecipe> SIEVE = recipeType("sieve", GroupedSieveRecipe.class);

    private static <T> RecipeType<T> recipeType(String path, Class<? extends T> type) {
        String namespace = ModList.get().isLoaded("emi") ? "exdeorum_emi" : "exdeorum";
        return RecipeType.create(namespace, path, type);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {

    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.golden_mechanical_sieve.get()), new RecipeType[]{SIEVE});
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.diamond_mechanical_sieve.get()), new RecipeType[]{SIEVE});
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.netherite_mechanical_sieve.get()), new RecipeType[]{SIEVE});
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.creative_mechanical_sieve.get()), new RecipeType[]{SIEVE});

        registration.addRecipeCatalyst(new ItemStack(ModBlocks.golden_mechanical_hammer.get()), new RecipeType[]{HAMMER});
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.diamond_mechanical_hammer.get()), new RecipeType[]{HAMMER});
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.netherite_mechanical_hammer.get()), new RecipeType[]{HAMMER});
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.creative_mechanical_hammer.get()), new RecipeType[]{HAMMER});
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        Component[] mechanical_hammer = new Component[] {
                Component.translatable("jei.havenede.mechanical_hammers.desc.line")
        };
        Component[] mechanical_sieve = new Component[] {
                Component.translatable("jei.havenede.mechanical_sieves.desc.line")
        };

        ItemStack golden_mechanical_hammer = new ItemStack(ModBlocks.golden_mechanical_hammer.get());
        registration.addIngredientInfo(golden_mechanical_hammer, VanillaTypes.ITEM_STACK, mechanical_hammer);

        ItemStack diamond_mechanical_hammer = new ItemStack(ModBlocks.diamond_mechanical_hammer.get());
        registration.addIngredientInfo(diamond_mechanical_hammer, VanillaTypes.ITEM_STACK, mechanical_hammer);

        ItemStack netherite_mechanical_hammer = new ItemStack(ModBlocks.netherite_mechanical_hammer.get());
        registration.addIngredientInfo(netherite_mechanical_hammer, VanillaTypes.ITEM_STACK, mechanical_hammer);

        ItemStack creative_mechanical_hammer = new ItemStack(ModBlocks.creative_mechanical_hammer.get());
        registration.addIngredientInfo(creative_mechanical_hammer, VanillaTypes.ITEM_STACK, mechanical_hammer);

        ItemStack golden_mechanical_sieve = new ItemStack(ModBlocks.golden_mechanical_sieve.get());
        registration.addIngredientInfo(golden_mechanical_sieve, VanillaTypes.ITEM_STACK, mechanical_sieve);

        ItemStack diamond_mechanical_sieve = new ItemStack(ModBlocks.diamond_mechanical_sieve.get());
        registration.addIngredientInfo(diamond_mechanical_sieve, VanillaTypes.ITEM_STACK, mechanical_sieve);

        ItemStack netherite_mechanical_sieve = new ItemStack(ModBlocks.netherite_mechanical_sieve.get());
        registration.addIngredientInfo(netherite_mechanical_sieve, VanillaTypes.ITEM_STACK, mechanical_sieve);

        ItemStack creative_mechanical_sieve = new ItemStack(ModBlocks.creative_mechanical_sieve.get());
        registration.addIngredientInfo(creative_mechanical_sieve, VanillaTypes.ITEM_STACK, mechanical_sieve);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addGuiContainerHandler(MechanicalSieveScreen.class, new IGuiContainerHandler<MechanicalSieveScreen>() {
            public Collection<IGuiClickableArea> getGuiClickableAreas(MechanicalSieveScreen containerScreen, double mouseX, double mouseY) {
                IGuiClickableArea clickableArea = IGuiClickableArea.createBasic(51, 42, 21, 14, new RecipeType[]{SIEVE});
                return ModList.get().isLoaded("emi") ? List.of() : List.of(clickableArea);
            }

            public List<Rect2i> getGuiExtraAreas(MechanicalSieveScreen containerScreen) {
                RedstoneControlWidget widget = containerScreen.getRedstoneControlWidget();
                return widget != null ? widget.getJeiBounds() : List.of();
            }
        });
        registration.addGuiContainerHandler(MechanicalHammerScreen.class, new IGuiContainerHandler<MechanicalHammerScreen>() {
            public Collection<IGuiClickableArea> getGuiClickableAreas(MechanicalHammerScreen containerScreen, double mouseX, double mouseY) {
                IGuiClickableArea clickableArea = IGuiClickableArea.createBasic(80, 34, 23, 16, new RecipeType[]{HAMMER});
                return ModList.get().isLoaded("emi") ? List.of() : List.of(clickableArea);
            }

            public List<Rect2i> getGuiExtraAreas(MechanicalHammerScreen containerScreen) {
                RedstoneControlWidget widget = containerScreen.getRedstoneControlWidget();
                return widget != null ? widget.getJeiBounds() : List.of();
            }
        });
    }
}
