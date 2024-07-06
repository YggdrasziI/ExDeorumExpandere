package net.cathienova.havenede.block;

import net.cathienova.havenede.HavenEDE;
import net.cathienova.havenede.block.mechanicalhammers.*;
import net.cathienova.havenede.block.mechanicalsieves.*;
import net.cathienova.havenede.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HavenEDE.MOD_ID);

    public static final RegistryObject<Block> golden_mechanical_hammer = registerBlock("golden_mechanical_hammer",
            () -> new GoldenMechanicalHammerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));

    public static final RegistryObject<Block> diamond_mechanical_hammer = registerBlock("diamond_mechanical_hammer",
            () -> new DiamondMechanicalHammerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));

    public static final RegistryObject<Block> netherite_mechanical_hammer = registerBlock("netherite_mechanical_hammer",
            () -> new NetheriteMechanicalHammerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));

    public static final RegistryObject<Block> creative_mechanical_hammer = registerBlock("creative_mechanical_hammer",
            () -> new CreativeMechanicalHammerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));

    public static final RegistryObject<Block> golden_mechanical_sieve = registerBlock("golden_mechanical_sieve",
            () -> new GoldenMechanicalSieveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));

    public static final RegistryObject<Block> diamond_mechanical_sieve = registerBlock("diamond_mechanical_sieve",
            () -> new DiamondMechanicalSieveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));

    public static final RegistryObject<Block> netherite_mechanical_sieve = registerBlock("netherite_mechanical_sieve",
            () -> new NetheriteMechanicalSieveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));

    public static final RegistryObject<Block> creative_mechanical_sieve = registerBlock("creative_mechanical_sieve",
            () -> new CreativeMechanicalSieveBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL)
                    .requiresCorrectToolForDrops().strength(5.0F, 1200.0F)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
