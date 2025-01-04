package net.somfunambulist.carrot_rarity.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.somfunambulist.carrot_rarity.CarrotRarityMod;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> IS_CARROT = tag("is_carrot");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CarrotRarityMod.MOD_ID, name));
        }
    }
}