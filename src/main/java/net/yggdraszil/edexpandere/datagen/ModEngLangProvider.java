package net.yggdraszil.edexpandere.datagen;

import net.yggdraszil.edexpandere.EDExpandere;
import net.yggdraszil.edexpandere.block.ModBlocks;
import net.yggdraszil.edexpandere.item.ModCreativeModTabs;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEngLangProvider extends LanguageProvider
{
    public ModEngLangProvider(PackOutput output)
    {
        super(output, EDExpandere.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        add(ModCreativeModTabs.edexpandere_tab_title, "Ex Deorum Expandere");
        addBlock(ModBlocks.golden_mechanical_hammer, "Golden Mechanical Hammer");
        add("gui.edexpandere.energy_label", "Energy");
        add("item.edexpandere.energy_display", ": %s / %s");

        addBlock(ModBlocks.diamond_mechanical_hammer, "Diamond Mechanical Hammer");
        addBlock(ModBlocks.netherite_mechanical_hammer, "Netherite Mechanical Hammer");
        addBlock(ModBlocks.creative_mechanical_hammer, "Creative Mechanical Hammer");

        addBlock(ModBlocks.golden_mechanical_sieve, "Golden Mechanical Sieve");
        add("edexpandere.container.golden_mechanical_sieve", "Golden Mechanical Sieve");
        add("item.edexpandere.golden_mechanical_sieve.mesh_label", "Mesh: %s");
        addBlock(ModBlocks.diamond_mechanical_sieve, "Diamond Mechanical Sieve");
        add("edexpandere.container.diamond_mechanical_sieve", "Diamond Mechanical Sieve");
        add("item.edexpandere.diamond_mechanical_sieve.mesh_label", "Mesh: %s");
        addBlock(ModBlocks.netherite_mechanical_sieve, "Netherite Mechanical Sieve");
        add("edexpandere.container.netherite_mechanical_sieve", "Netherite Mechanical Sieve");
        add("item.edexpandere.netherite_mechanical_sieve.mesh_label", "Mesh: %s");
        addBlock(ModBlocks.creative_mechanical_sieve, "Creative Mechanical Sieve");
        add("edexpandere.container.creative_mechanical_sieve", "Creative Mechanical Sieve");
        add("item.edexpandere.creative_mechanical_sieve.mesh_label", "Mesh: %s");

        add("jei.edexpandere.mechanical_hammers.desc.line", "The Mechanical Hammer is a machine that, when supplied with Forge Energy (FE), will hammer blocks without a player having to do it themselves. It can operate without a hammer, but adding any hammer will double the speed, and efficiency enchantments on the hammer will further increase speed. It also supports three different modes of redstone control. Since Ex Deorum does not provide a way to generate FE, you will need another mod to provide power.");
        add("jei.edexpandere.mechanical_sieves.desc.line", "The Mechanical Sieve is a machine that, when supplied with a mesh and Forge Energy (FE), will sift blocks without a player having to do it themselves. It also supports three different modes of redstone control. Since Ex Deorum does not provide a way to generate FE, you will need another mod to provide power.");

        add("advancements.edexpandere.root.title", "Ex Deorum Expandere");
        add("advancements.edexpandere.root.description", "Welcome to: Ex Deorum Expandere");

        add("advancements.edexpandere.golden_mechanical_sieve.title", "Golden Mechanical Sieve");
        add("advancements.edexpandere.golden_mechanical_sieve.description", "Craft a Golden Mechanical Sieve");

        add("advancements.edexpandere.diamond_mechanical_sieve.title", "Diamond Mechanical Sieve");
        add("advancements.edexpandere.diamond_mechanical_sieve.description", "Craft a Diamond Mechanical Sieve");

        add("advancements.edexpandere.netherite_mechanical_sieve.title", "Netherite Mechanical Sieve");
        add("advancements.edexpandere.netherite_mechanical_sieve.description", "Craft a Netherite Mechanical Sieve");

        add("advancements.edexpandere.creative_mechanical_sieve.title", "Creative Mechanical Sieve");
        add("advancements.edexpandere.creative_mechanical_sieve.description", "Craft a Creative Mechanical Sieve");

        add("advancements.edexpandere.golden_mechanical_hammer.title", "Golden Mechanical Hammer");
        add("advancements.edexpandere.golden_mechanical_hammer.description", "Craft a Golden Mechanical Hammer");

        add("advancements.edexpandere.diamond_mechanical_hammer.title", "Diamond Mechanical Hammer");
        add("advancements.edexpandere.diamond_mechanical_hammer.description", "Craft a Diamond Mechanical Hammer");

        add("advancements.edexpandere.netherite_mechanical_hammer.title", "Netherite Mechanical Hammer");
        add("advancements.edexpandere.netherite_mechanical_hammer.description", "Craft a Netherite Mechanical Hammer");

        add("advancements.edexpandere.creative_mechanical_hammer.title", "Creative Mechanical Hammer");
        add("advancements.edexpandere.creative_mechanical_hammer.description", "Craft a Creative Mechanical Hammer");
    }
}
