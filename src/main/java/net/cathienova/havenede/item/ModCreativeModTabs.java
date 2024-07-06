package net.cathienova.havenede.item;

import net.cathienova.havenede.HavenEDE;
import net.cathienova.havenede.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HavenEDE.MOD_ID);

    public static String havenede_tab_title = "itemgroup.haven.haven_tab";
    public static final RegistryObject<CreativeModeTab> Haven_TAB = CREATIVE_MODE_TABS.register("haven_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.golden_mechanical_hammer.get()))
                    .title(Component.translatable(havenede_tab_title))
                    .displayItems((pParameters, add) -> {
                        add.accept(new ItemStack(ModBlocks.golden_mechanical_hammer.get()));
                        add.accept(new ItemStack(ModBlocks.diamond_mechanical_hammer.get()));
                        add.accept(new ItemStack(ModBlocks.netherite_mechanical_hammer.get()));
                        add.accept(new ItemStack(ModBlocks.creative_mechanical_hammer.get()));
                        add.accept(new ItemStack(ModBlocks.golden_mechanical_sieve.get()));
                        add.accept(new ItemStack(ModBlocks.diamond_mechanical_sieve.get()));
                        add.accept(new ItemStack(ModBlocks.netherite_mechanical_sieve.get()));
                        add.accept(new ItemStack(ModBlocks.creative_mechanical_sieve.get()));
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
