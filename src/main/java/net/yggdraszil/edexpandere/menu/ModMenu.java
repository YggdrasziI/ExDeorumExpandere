package net.yggdraszil.edexpandere.menu;

import net.yggdraszil.edexpandere.EDExpandere;
import net.yggdraszil.edexpandere.menu.mechanicalhammers.CreativeMechanicalHammerMenu;
import net.yggdraszil.edexpandere.menu.mechanicalhammers.DiamondMechanicalHammerMenu;
import net.yggdraszil.edexpandere.menu.mechanicalhammers.GoldenMechanicalHammerMenu;
import net.yggdraszil.edexpandere.menu.mechanicalhammers.NetheriteMechanicalHammerMenu;
import net.yggdraszil.edexpandere.menu.mechanicalsieves.CreativeMechanicalSieveMenu;
import net.yggdraszil.edexpandere.menu.mechanicalsieves.DiamondMechanicalSieveMenu;
import net.yggdraszil.edexpandere.menu.mechanicalsieves.GoldenMechanicalSieveMenu;
import net.yggdraszil.edexpandere.menu.mechanicalsieves.NetheriteMechanicalSieveMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenu {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, EDExpandere.MOD_ID);

    public static final RegistryObject<MenuType<GoldenMechanicalHammerMenu>> GOLDEN_MECHANICAL_HAMMER =
            MENUS.register("golden_mechanical_hammer", () -> IForgeMenuType.create(GoldenMechanicalHammerMenu::new));

    public static final RegistryObject<MenuType<DiamondMechanicalHammerMenu>> DIAMOND_MECHANICAL_HAMMER =
            MENUS.register("diamond_mechanical_hammer", () -> IForgeMenuType.create(DiamondMechanicalHammerMenu::new));

    public static final RegistryObject<MenuType<NetheriteMechanicalHammerMenu>> NETHERITE_MECHANICAL_HAMMER =
            MENUS.register("netherite_mechanical_hammer", () -> IForgeMenuType.create(NetheriteMechanicalHammerMenu::new));

    public static final RegistryObject<MenuType<CreativeMechanicalHammerMenu>> CREATIVE_MECHANICAL_HAMMER =
            MENUS.register("creative_mechanical_hammer", () -> IForgeMenuType.create(CreativeMechanicalHammerMenu::new));

    public static final RegistryObject<MenuType<GoldenMechanicalSieveMenu>> GOLDEN_MECHANICAL_SIEVE =
            MENUS.register("golden_mechanical_sieve", () -> IForgeMenuType.create(GoldenMechanicalSieveMenu::new));

    public static final RegistryObject<MenuType<DiamondMechanicalSieveMenu>> DIAMOND_MECHANICAL_SIEVE =
            MENUS.register("diamond_mechanical_sieve", () -> IForgeMenuType.create(DiamondMechanicalSieveMenu::new));

    public static final RegistryObject<MenuType<NetheriteMechanicalSieveMenu>> NETHERITE_MECHANICAL_SIEVE =
            MENUS.register("netherite_mechanical_sieve", () -> IForgeMenuType.create(NetheriteMechanicalSieveMenu::new));

    public static final RegistryObject<MenuType<CreativeMechanicalSieveMenu>> CREATIVE_MECHANICAL_SIEVE =
            MENUS.register("creative_mechanical_sieve", () -> IForgeMenuType.create(CreativeMechanicalSieveMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
