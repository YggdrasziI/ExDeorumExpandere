package net.yggdraszil.edexpandere.block;

import net.yggdraszil.edexpandere.EDExpandere;
import net.yggdraszil.edexpandere.block.mechanicalhammers.CreativeMechanicalHammerBlockEntity;
import net.yggdraszil.edexpandere.block.mechanicalhammers.DiamondMechanicalHammerBlockEntity;
import net.yggdraszil.edexpandere.block.mechanicalhammers.GoldenMechanicalHammerBlockEntity;
import net.yggdraszil.edexpandere.block.mechanicalhammers.NetheriteMechanicalHammerBlockEntity;
import net.yggdraszil.edexpandere.block.mechanicalsieves.CreativeMechanicalSieveBlockEntity;
import net.yggdraszil.edexpandere.block.mechanicalsieves.DiamondMechanicalSieveBlockEntity;
import net.yggdraszil.edexpandere.block.mechanicalsieves.GoldenMechanicalSieveBlockEntity;
import net.yggdraszil.edexpandere.block.mechanicalsieves.NetheriteMechanicalSieveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EDExpandere.MOD_ID);

    public static final RegistryObject<BlockEntityType<GoldenMechanicalHammerBlockEntity>> GOLDEN_MECHANICAL_HAMMER = BLOCK_ENTITIES.register("golden_mechanical_hammer",
            () -> BlockEntityType.Builder.of(GoldenMechanicalHammerBlockEntity::new, ModBlocks.golden_mechanical_hammer.get()).build(null));

    public static final RegistryObject<BlockEntityType<DiamondMechanicalHammerBlockEntity>> DIAMOND_MECHANICAL_HAMMER = BLOCK_ENTITIES.register("diamond_mechanical_hammer",
            () -> BlockEntityType.Builder.of(DiamondMechanicalHammerBlockEntity::new, ModBlocks.diamond_mechanical_hammer.get()).build(null));

    public static final RegistryObject<BlockEntityType<NetheriteMechanicalHammerBlockEntity>> NETHERITE_MECHANICAL_HAMMER = BLOCK_ENTITIES.register("netherite_mechanical_hammer",
            () -> BlockEntityType.Builder.of(NetheriteMechanicalHammerBlockEntity::new, ModBlocks.netherite_mechanical_hammer.get()).build(null));

    public static final RegistryObject<BlockEntityType<CreativeMechanicalHammerBlockEntity>> CREATIVE_MECHANICAL_HAMMER = BLOCK_ENTITIES.register("creative_mechanical_hammer",
            () -> BlockEntityType.Builder.of(CreativeMechanicalHammerBlockEntity::new, ModBlocks.creative_mechanical_hammer.get()).build(null));

    public static final RegistryObject<BlockEntityType<GoldenMechanicalSieveBlockEntity>> GOLDEN_MECHANICAL_SIEVE = BLOCK_ENTITIES.register("golden_mechanical_sieve",
            () -> BlockEntityType.Builder.of(GoldenMechanicalSieveBlockEntity::new, ModBlocks.golden_mechanical_sieve.get()).build(null));

    public static final RegistryObject<BlockEntityType<DiamondMechanicalSieveBlockEntity>> DIAMOND_MECHANICAL_SIEVE = BLOCK_ENTITIES.register("diamond_mechanical_sieve",
            () -> BlockEntityType.Builder.of(DiamondMechanicalSieveBlockEntity::new, ModBlocks.diamond_mechanical_sieve.get()).build(null));

    public static final RegistryObject<BlockEntityType<NetheriteMechanicalSieveBlockEntity>> NETHERITE_MECHANICAL_SIEVE = BLOCK_ENTITIES.register("netherite_mechanical_sieve",
            () -> BlockEntityType.Builder.of(NetheriteMechanicalSieveBlockEntity::new, ModBlocks.netherite_mechanical_sieve.get()).build(null));

    public static final RegistryObject<BlockEntityType<CreativeMechanicalSieveBlockEntity>> CREATIVE_MECHANICAL_SIEVE = BLOCK_ENTITIES.register("creative_mechanical_sieve",
            () -> BlockEntityType.Builder.of(CreativeMechanicalSieveBlockEntity::new, ModBlocks.creative_mechanical_sieve.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }
}
