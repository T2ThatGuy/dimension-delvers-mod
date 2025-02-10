package com.dimensiondelvers.dimensiondelvers.config;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.dimensiondelvers.dimensiondelvers.config.configs.ExampleConfig;
import com.dimensiondelvers.dimensiondelvers.config.configs.RunegemTierConfig;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;


@EventBusSubscriber(modid = DimensionDelvers.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ConfigManager {

    public static final ExampleConfig EXAMPLE = new ExampleConfig();
    public static final RunegemTierConfig RUNEGEM_TIER = new RunegemTierConfig();

    @SubscribeEvent
    public static void onAddReloadListeners(AddReloadListenerEvent event) {
        event.addListener(EXAMPLE);
        event.addListener(RUNEGEM_TIER);
    }
}
