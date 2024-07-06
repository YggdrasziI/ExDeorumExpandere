package net.cathienova.havenede.datagen.loot;

import net.cathienova.havenede.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
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
