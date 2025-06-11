package net.yggdraszil.edexpandere.datagen;

import net.yggdraszil.edexpandere.EDExpandere;
import net.yggdraszil.edexpandere.block.ModBlocks;
import net.yggdraszil.edexpandere.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                               CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, EDExpandere.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        this.tag(ModTags.Items.mechanical_hammers)
                .add(ModBlocks.golden_mechanical_hammer.get().asItem())
                .add(ModBlocks.diamond_mechanical_hammer.get().asItem())
                .add(ModBlocks.netherite_mechanical_hammer.get().asItem())
                .add(ModBlocks.creative_mechanical_hammer.get().asItem())
            ;

        this.tag(ModTags.Items.mechanical_sieves)
                .add(ModBlocks.golden_mechanical_sieve.get().asItem())
                .add(ModBlocks.diamond_mechanical_sieve.get().asItem())
                .add(ModBlocks.netherite_mechanical_sieve.get().asItem())
                .add(ModBlocks.creative_mechanical_sieve.get().asItem())
            ;
    }
}
