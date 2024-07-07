package net.cathienova.havenede;

import com.mojang.logging.LogUtils;
import net.cathienova.havenede.block.ModBlockEntities;
import net.cathienova.havenede.block.ModBlocks;
import net.cathienova.havenede.commands.ModCommands;
import net.cathienova.havenede.config.CommonConfig;
import net.cathienova.havenede.item.*;
import net.cathienova.havenede.menu.ModMenu;
import net.cathienova.havenede.networking.ModMessages;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.commons.lang3.tuple.Pair;
import thedarkcolour.exdeorum.registry.EGlobalLootModifiers;

@Mod(HavenEDE.MOD_ID)
public class HavenEDE
{
    public static final String MOD_ID = "havenede";
    public static final String MOD_NAME = "HavenExDeorumExpansion";
    static final ForgeConfigSpec commonSpec;
    public static final CommonConfig c_config;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        commonSpec = specPair.getRight();
        c_config = specPair.getLeft();
    }

    public HavenEDE()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, commonSpec, MOD_NAME + "-Config.toml");
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModMessages.register();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> HavenEDEClient::new);
        ModMenu.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void Log(String message)
    {
        LogUtils.getLogger().info("["+ MOD_NAME +"] " + message);
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
    ModCommands.register(event.getDispatcher());
}

    private void setup(final FMLCommonSetupEvent event)
    {
    }
}
