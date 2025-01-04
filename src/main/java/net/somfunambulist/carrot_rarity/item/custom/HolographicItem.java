package net.somfunambulist.carrot_rarity.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HolographicItem extends Item {
    public HolographicItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}