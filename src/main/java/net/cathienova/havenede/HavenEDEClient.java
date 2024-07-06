package net.cathienova.havenede;

import net.cathienova.havenede.block.ModBlockEntities;
import net.cathienova.havenede.block.ModBlocks;
import net.cathienova.havenede.menu.ModMenu;
import net.cathienova.havenede.menu.mechanicalhammers.*;
import net.cathienova.havenede.menu.mechanicalsieves.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import thedarkcolour.exdeorum.client.ClientHandler;
import thedarkcolour.exdeorum.client.ter.SieveRenderer;
import thedarkcolour.exdeorum.registry.EBlockEntities;

@Mod.EventBusSubscriber(modid = HavenEDE.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HavenEDEClient
{
    public HavenEDEClient() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(HavenEDEClient::registerRenderers);
    }

    @OnlyIn(Dist.CLIENT)
    private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        MenuScreens.register(ModMenu.GOLDEN_MECHANICAL_HAMMER.get(), GoldenMechanicalHammerScreen::new);
        MenuScreens.register(ModMenu.DIAMOND_MECHANICAL_HAMMER.get(), DiamondMechanicalHammerScreen::new);
        MenuScreens.register(ModMenu.NETHERITE_MECHANICAL_HAMMER.get(), NetheriteMechanicalHammerScreen::new);
        MenuScreens.register(ModMenu.CREATIVE_MECHANICAL_HAMMER.get(), CreativeMechanicalHammerScreen::new);

        MenuScreens.register(ModMenu.GOLDEN_MECHANICAL_SIEVE.get(), GoldenMechanicalSieveScreen::new);
        MenuScreens.register(ModMenu.DIAMOND_MECHANICAL_SIEVE.get(), DiamondMechanicalSieveScreen::new);
        MenuScreens.register(ModMenu.NETHERITE_MECHANICAL_SIEVE.get(), NetheriteMechanicalSieveScreen::new);
        MenuScreens.register(ModMenu.CREATIVE_MECHANICAL_SIEVE.get(), CreativeMechanicalSieveScreen::new);

        event.registerBlockEntityRenderer((BlockEntityType) ModBlockEntities.GOLDEN_MECHANICAL_SIEVE.get(), (ctx) -> {
            return new SieveRenderer(0.75F, 15.0F);
        });

        event.registerBlockEntityRenderer((BlockEntityType) ModBlockEntities.DIAMOND_MECHANICAL_SIEVE.get(), (ctx) -> {
            return new SieveRenderer(0.75F, 15.0F);
        });

        event.registerBlockEntityRenderer((BlockEntityType) ModBlockEntities.NETHERITE_MECHANICAL_SIEVE.get(), (ctx) -> {
            return new SieveRenderer(0.75F, 15.0F);
        });

        event.registerBlockEntityRenderer((BlockEntityType) ModBlockEntities.CREATIVE_MECHANICAL_SIEVE.get(), (ctx) -> {
            return new SieveRenderer(0.75F, 15.0F);
        });

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.golden_mechanical_sieve.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.diamond_mechanical_sieve.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.netherite_mechanical_sieve.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.creative_mechanical_sieve.get(), RenderType.translucent());
    }
}
