package net.yggdraszil.edexpandere.datagen.loot;

import net.yggdraszil.edexpandere.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate()
    {
        this.dropSelf(ModBlocks.golden_mechanical_hammer.get());
        this.dropSelf(ModBlocks.diamond_mechanical_hammer.get());
        this.dropSelf(ModBlocks.netherite_mechanical_hammer.get());
        this.dropSelf(ModBlocks.creative_mechanical_hammer.get());

        this.dropSelf(ModBlocks.golden_mechanical_sieve.get());
        this.dropSelf(ModBlocks.diamond_mechanical_sieve.get());
        this.dropSelf(ModBlocks.netherite_mechanical_sieve.get());
        this.dropSelf(ModBlocks.creative_mechanical_sieve.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
