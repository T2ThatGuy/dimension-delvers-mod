package com.dimensiondelvers.dimensiondelvers.config;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.dimensiondelvers.dimensiondelvers.config.configs.ExampleConfig;
import com.dimensiondelvers.dimensiondelvers.config.configs.RunegemTierConfig;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;


@EventBusSubscriber(modid = DimensionDelvers.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ConfigManager {

    public static final ExampleConfig EXAMPLE = new ExampleConfig();
    public static final RunegemTierConfig RUNEGEM_TIER = new RunegemTierConfig();

    @SubscribeEvent
    public static void onAddReloadListeners(AddServerReloadListenersEvent event) {
        event.addListener(ResourceLocation.fromNamespaceAndPath(DimensionDelvers.MODID, "example_config"), EXAMPLE);
        event.addListener(ResourceLocation.fromNamespaceAndPath(DimensionDelvers.MODID, "runegem_tiers"), RUNEGEM_TIER);
    }
}
