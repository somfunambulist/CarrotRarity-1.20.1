package net.somfunambulist.carrot_rarity.item;

import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.somfunambulist.carrot_rarity.CarrotRarityMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.somfunambulist.carrot_rarity.item.custom.HolographicItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CarrotRarityMod.MOD_ID);

    public static final RegistryObject<Item> TWISTY_CARROT = ITEMS.register("twisty_carrot",
            () -> new Item(new Item.Properties().food(ModFoods.TWISTY_CARROT)));
    public static final RegistryObject<Item> LEGGY_CARROT = ITEMS.register("leggy_carrot",
            () -> new Item(new Item.Properties().food(ModFoods.TWISTY_CARROT).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> CARROT_BABY = ITEMS.register("carrot_baby",
            () -> new Item(new Item.Properties().food(ModFoods.TWISTY_CARROT).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> HOLOGRAPHIC_CARROT_BABY = ITEMS.register("holographic_carrot_baby",
            () -> new HolographicItem(new Item.Properties().food(ModFoods.TWISTY_CARROT).rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}