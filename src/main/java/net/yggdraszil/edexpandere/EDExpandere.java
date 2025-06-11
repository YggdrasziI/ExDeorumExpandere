package net.yggdraszil.edexpandere;

import com.mojang.logging.LogUtils;
import net.yggdraszil.edexpandere.block.ModBlockEntities;
import net.yggdraszil.edexpandere.block.ModBlocks;
import net.yggdraszil.edexpandere.commands.ModCommands;
import net.yggdraszil.edexpandere.config.CommonConfig;
import net.yggdraszil.edexpandere.item.ModCreativeModTabs;
import net.yggdraszil.edexpandere.item.ModItems;
import net.yggdraszil.edexpandere.menu.ModMenu;
import net.yggdraszil.edexpandere.networking.ModMessages;
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

@Mod(EDExpandere.MOD_ID)
public class EDExpandere
{
    public static final String MOD_ID = "edexpandere";
    public static final String MOD_NAME = "Ex Deorum Expandere";
    static final ForgeConfigSpec commonSpec;
    public static final CommonConfig c_config;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        commonSpec = specPair.getRight();
        c_config = specPair.getLeft();
    }

    public EDExpandere()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, commonSpec, MOD_ID + "-config.toml");
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModMessages.register();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> EDExpandereClient::new);
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
