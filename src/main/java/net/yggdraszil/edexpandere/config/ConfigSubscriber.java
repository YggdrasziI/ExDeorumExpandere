package net.yggdraszil.edexpandere.config;

import net.yggdraszil.edexpandere.EDExpandere;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = EDExpandere.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigSubscriber {
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event) {
        ExpandereConfig.bake(event.getConfig());
    }
}
