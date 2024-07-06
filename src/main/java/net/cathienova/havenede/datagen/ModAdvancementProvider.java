package net.cathienova.havenede.datagen;

import net.cathienova.havenede.HavenEDE;
import net.cathienova.havenede.block.ModBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ImpossibleTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends ForgeAdvancementProvider {

    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper fileHelper) {
        super(output, registries, fileHelper, List.of(new ModAdvancements()));
    }

    public static class ModAdvancements implements AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
            Advancement root = Advancement.Builder.advancement()
                    .display(ModBlocks.diamond_mechanical_sieve.get(),
                            Component.translatable("advancements.havenede.root.title"),
                            Component.translatable("advancements.havenede.root.description"),
                            new ResourceLocation(HavenEDE.MOD_ID, "textures/block/sand.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("tick", new ImpossibleTrigger.TriggerInstance())
                    .save(consumer, new ResourceLocation(HavenEDE.MOD_ID, "root").toString());

            Advancement goldenMechanicalSieve = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModBlocks.golden_mechanical_sieve.get(),
                            Component.translatable("advancements.havenede.golden_mechanical_sieve.title"),
                            Component.translatable("advancements.havenede.golden_mechanical_sieve.description"),
                            new ResourceLocation(HavenEDE.MOD_ID, "textures/block/sand.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("golden_mechanical_sieve", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.golden_mechanical_sieve.get()).build()))
                    .save(consumer, new ResourceLocation(HavenEDE.MOD_ID, "golden_mechanical_sieve").toString());

            Advancement diamondMechanicalSieve = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModBlocks.diamond_mechanical_sieve.get(),
                            Component.translatable("advancements.havenede.diamond_mechanical_sieve.title"),
                            Component.translatable("advancements.havenede.diamond_mechanical_sieve.description"),
                            new ResourceLocation(HavenEDE.MOD_ID, "textures/block/sand.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("diamond_mechanical_sieve", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.diamond_mechanical_sieve.get()).build()))
                    .save(consumer, new ResourceLocation(HavenEDE.MOD_ID, "diamond_mechanical_sieve").toString());

            Advancement netheriteMechanicalSieve = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModBlocks.netherite_mechanical_sieve.get(),
                            Component.translatable("advancements.havenede.netherite_mechanical_sieve.title"),
                            Component.translatable("advancements.havenede.netherite_mechanical_sieve.description"),
                            new ResourceLocation(HavenEDE.MOD_ID, "textures/block/sand.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("netherite_mechanical_sieve", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.netherite_mechanical_sieve.get()).build()))
                    .save(consumer, new ResourceLocation(HavenEDE.MOD_ID, "netherite_mechanical_sieve").toString());

            Advancement creativeMechanicalSieve = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModBlocks.creative_mechanical_sieve.get(),
                            Component.translatable("advancements.havenede.creative_mechanical_sieve.title"),
                            Component.translatable("advancements.havenede.creative_mechanical_sieve.description"),
                            new ResourceLocation(HavenEDE.MOD_ID, "textures/block/sand.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("creative_mechanical_sieve", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.creative_mechanical_sieve.get()).build()))
                    .save(consumer, new ResourceLocation(HavenEDE.MOD_ID, "creative_mechanical_sieve").toString());

            Advancement goldenMechanicalHammer = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModBlocks.golden_mechanical_hammer.get(),
                            Component.translatable("advancements.havenede.golden_mechanical_hammer.title"),
                            Component.translatable("advancements.havenede.golden_mechanical_hammer.description"),
                            new ResourceLocation(HavenEDE.MOD_ID, "textures/block/sand.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("golden_mechanical_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.golden_mechanical_hammer.get()).build()))
                    .save(consumer, new ResourceLocation(HavenEDE.MOD_ID, "golden_mechanical_hammer").toString());

            Advancement diamondMechanicalHammer = Advancement.Builder.advancement()
                    .parent(goldenMechanicalHammer)
                    .display(ModBlocks.diamond_mechanical_hammer.get(),
                            Component.translatable("advancements.havenede.diamond_mechanical_hammer.title"),
                            Component.translatable("advancements.havenede.diamond_mechanical_hammer.description"),
                            new ResourceLocation(HavenEDE.MOD_ID, "textures/block/sand.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("diamond_mechanical_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.diamond_mechanical_hammer.get()).build()))
                    .save(consumer, new ResourceLocation(HavenEDE.MOD_ID, "diamond_mechanical_hammer").toString());

            Advancement netheriteMechanicalHammer = Advancement.Builder.advancement()
                    .parent(diamondMechanicalHammer)
                    .display(ModBlocks.netherite_mechanical_hammer.get(),
                            Component.translatable("advancements.havenede.netherite_mechanical_hammer.title"),
                            Component.translatable("advancements.havenede.netherite_mechanical_hammer.description"),
                            new ResourceLocation(HavenEDE.MOD_ID, "textures/block/sand.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("netherite_mechanical_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.netherite_mechanical_hammer.get()).build()))
                    .save(consumer, new ResourceLocation(HavenEDE.MOD_ID, "netherite_mechanical_hammer").toString());

            Advancement creativeMechanicalHammer = Advancement.Builder.advancement()
                    .parent(netheriteMechanicalHammer)
                    .display(ModBlocks.creative_mechanical_hammer.get(),
                            Component.translatable("advancements.havenede.creative_mechanical_hammer.title"),
                            Component.translatable("advancements.havenede.creative_mechanical_hammer.description"),
                            new ResourceLocation(HavenEDE.MOD_ID, "textures/block/sand.png"),
                            FrameType.TASK, true, true, false)
                    .addCriterion("creative_mechanical_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModBlocks.creative_mechanical_hammer.get()).build()))
                    .save(consumer, new ResourceLocation(HavenEDE.MOD_ID, "creative_mechanical_hammer").toString());
        }
    }
}
