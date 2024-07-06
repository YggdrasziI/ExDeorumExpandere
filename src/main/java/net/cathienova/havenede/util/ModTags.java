package net.cathienova.havenede.util;

import net.cathienova.havenede.HavenEDE;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> needs_stone_tool = minecraftTag("needs_stone_tool");
        public static final TagKey<Block> needs_iron_tool = minecraftTag("needs_iron_tool");
        public static final TagKey<Block> needs_diamond_tool = minecraftTag("needs_diamond_tool");
        public static final TagKey<Block> needs_netherite_tool = minecraftTag("needs_netherite_tool");
        public static final TagKey<Block> mechanical_hammers = tag("mechanical_hammers");
        public static final TagKey<Block> mechanical_sieves = tag("mechanical_sieves");

        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(HavenEDE.MOD_ID, name));
        }
        private static TagKey<Block> minecraftTag(String name) {
            return BlockTags.create(new ResourceLocation("minecraft", name));
        }
        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items
    {
        public static final TagKey<Item> mechanical_hammers = tag("mechanical_hammers");
        public static final TagKey<Item> mechanical_sieves = tag("mechanical_sieves");

        private static TagKey<Item> tag(String name)
        {
            return ItemTags.create(new ResourceLocation(HavenEDE.MOD_ID, name));
        }
        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
