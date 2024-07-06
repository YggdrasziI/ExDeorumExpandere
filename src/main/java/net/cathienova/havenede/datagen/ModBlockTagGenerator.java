package net.cathienova.havenede.datagen;

import net.cathienova.havenede.HavenEDE;
import net.cathienova.havenede.block.ModBlocks;
import net.cathienova.havenede.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HavenEDE.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.golden_mechanical_hammer.get())
                .add(ModBlocks.diamond_mechanical_hammer.get())
                .add(ModBlocks.netherite_mechanical_hammer.get())
                .add(ModBlocks.creative_mechanical_hammer.get())
                .add(ModBlocks.golden_mechanical_sieve.get())
                .add(ModBlocks.diamond_mechanical_sieve.get())
                .add(ModBlocks.netherite_mechanical_sieve.get())
                .add(ModBlocks.creative_mechanical_sieve.get())
            ;

        this.tag(ModTags.Blocks.needs_stone_tool)
                .add(ModBlocks.golden_mechanical_hammer.get())
                .add(ModBlocks.golden_mechanical_sieve.get())
            ;

        this.tag(ModTags.Blocks.needs_iron_tool)

            ;

        this.tag(ModTags.Blocks.needs_diamond_tool)
                .add(ModBlocks.diamond_mechanical_hammer.get())
                .add(ModBlocks.diamond_mechanical_sieve.get())
                .add(ModBlocks.netherite_mechanical_hammer.get())
                .add(ModBlocks.creative_mechanical_hammer.get())
                .add(ModBlocks.netherite_mechanical_sieve.get())
                .add(ModBlocks.creative_mechanical_sieve.get())
            ;

        this.tag(ModTags.Blocks.needs_netherite_tool)
            ;

        this.tag(ModTags.Blocks.mechanical_hammers)
                .add(ModBlocks.golden_mechanical_hammer.get())
                .add(ModBlocks.diamond_mechanical_hammer.get())
                .add(ModBlocks.netherite_mechanical_hammer.get())
                .add(ModBlocks.creative_mechanical_hammer.get())
            ;

        this.tag(ModTags.Blocks.mechanical_sieves)
                .add(ModBlocks.golden_mechanical_sieve.get())
                .add(ModBlocks.diamond_mechanical_sieve.get())
                .add(ModBlocks.netherite_mechanical_sieve.get())
                .add(ModBlocks.creative_mechanical_sieve.get())
            ;
    }
}