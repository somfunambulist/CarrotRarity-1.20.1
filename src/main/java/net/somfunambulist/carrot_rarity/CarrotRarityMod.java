package net.somfunambulist.carrot_rarity;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.somfunambulist.carrot_rarity.item.ModItems;
import net.somfunambulist.carrot_rarity.util.ModTags;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CarrotRarityMod.MOD_ID)
public class CarrotRarityMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "carrot_rarity";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public CarrotRarityMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.TWISTY_CARROT.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.LEGGY_CARROT.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.CARROT_BABY.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.HOLOGRAPHIC_CARROT_BABY.get(), 0.65f);
        });

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.TWISTY_CARROT);
            event.accept(ModItems.LEGGY_CARROT);
            event.accept(ModItems.CARROT_BABY);
            //event.accept(ModItems.HOLOGRAPHIC_CARROT_BABY);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
