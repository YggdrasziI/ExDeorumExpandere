package net.cathienova.havenede.datagen;

import net.cathienova.havenede.HavenEDE;
import net.cathienova.havenede.block.ModBlocks;
import net.cathienova.havenede.item.ModCreativeModTabs;
import net.cathienova.havenede.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEngLangProvider extends LanguageProvider
{
    public ModEngLangProvider(PackOutput output)
    {
        super(output, HavenEDE.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        add(ModCreativeModTabs.havenede_tab_title, "Haven: Ex Deorum Expansion");
        addBlock(ModBlocks.golden_mechanical_hammer, "Golden Mechanical Hammer");
        add("gui.havenede.energy_label", "Energy");
        add("item.havenede.energy_display", ": %s / %s");

        addBlock(ModBlocks.diamond_mechanical_hammer, "Diamond Mechanical Hammer");
        addBlock(ModBlocks.netherite_mechanical_hammer, "Netherite Mechanical Hammer");
        addBlock(ModBlocks.creative_mechanical_hammer, "Creative Mechanical Hammer");

        addBlock(ModBlocks.golden_mechanical_sieve, "Golden Mechanical Sieve");
        add("havenede.container.golden_mechanical_sieve", "Golden Mechanical Sieve");
        add("item.havenede.golden_mechanical_sieve.mesh_label", "Mesh: %s");
        addBlock(ModBlocks.diamond_mechanical_sieve, "Diamond Mechanical Sieve");
        add("havenede.container.diamond_mechanical_sieve", "Diamond Mechanical Sieve");
        add("item.havenede.diamond_mechanical_sieve.mesh_label", "Mesh: %s");
        addBlock(ModBlocks.netherite_mechanical_sieve, "Netherite Mechanical Sieve");
        add("havenede.container.netherite_mechanical_sieve", "Netherite Mechanical Sieve");
        add("item.havenede.netherite_mechanical_sieve.mesh_label", "Mesh: %s");
        addBlock(ModBlocks.creative_mechanical_sieve, "Creative Mechanical Sieve");
        add("havenede.container.creative_mechanical_sieve", "Creative Mechanical Sieve");
        add("item.havenede.creative_mechanical_sieve.mesh_label", "Mesh: %s");

        add("jei.havenede.mechanical_hammers.desc.line", "The Mechanical Hammer is a machine that, when supplied with Forge Energy (FE), will hammer blocks without a player having to do it themselves. It can operate without a hammer, but adding any hammer will double the speed, and efficiency enchantments on the hammer will further increase speed. It also supports three different modes of redstone control. Since Ex Deorum does not provide a way to generate FE, you will need another mod to provide power.");
        add("jei.havenede.mechanical_sieves.desc.line", "The Mechanical Sieve is a machine that, when supplied with a mesh and Forge Energy (FE), will sift blocks without a player having to do it themselves. It also supports three different modes of redstone control. Since Ex Deorum does not provide a way to generate FE, you will need another mod to provide power.");

        add("advancements.havenede.root.title", "Haven: Ex Deorum Expansion");
        add("advancements.havenede.root.description", "Welcome to Haven: Ex Deorum Expansion");

        add("advancements.havenede.golden_mechanical_sieve.title", "Golden Mechanical Sieve");
        add("advancements.havenede.golden_mechanical_sieve.description", "Craft a Golden Mechanical Sieve");

        add("advancements.havenede.diamond_mechanical_sieve.title", "Diamond Mechanical Sieve");
        add("advancements.havenede.diamond_mechanical_sieve.description", "Craft a Diamond Mechanical Sieve");

        add("advancements.havenede.netherite_mechanical_sieve.title", "Netherite Mechanical Sieve");
        add("advancements.havenede.netherite_mechanical_sieve.description", "Craft a Netherite Mechanical Sieve");

        add("advancements.havenede.creative_mechanical_sieve.title", "Creative Mechanical Sieve");
        add("advancements.havenede.creative_mechanical_sieve.description", "Craft a Creative Mechanical Sieve");

        add("advancements.havenede.golden_mechanical_hammer.title", "Golden Mechanical Hammer");
        add("advancements.havenede.golden_mechanical_hammer.description", "Craft a Golden Mechanical Hammer");

        add("advancements.havenede.diamond_mechanical_hammer.title", "Diamond Mechanical Hammer");
        add("advancements.havenede.diamond_mechanical_hammer.description", "Craft a Diamond Mechanical Hammer");

        add("advancements.havenede.netherite_mechanical_hammer.title", "Netherite Mechanical Hammer");
        add("advancements.havenede.netherite_mechanical_hammer.description", "Craft a Netherite Mechanical Hammer");

        add("advancements.havenede.creative_mechanical_hammer.title", "Creative Mechanical Hammer");
        add("advancements.havenede.creative_mechanical_hammer.description", "Craft a Creative Mechanical Hammer");
    }
}
