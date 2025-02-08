package com.dimensiondelvers.dimensiondelvers.config;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.dimensiondelvers.dimensiondelvers.config.codecs.ExampleConfig;
import com.dimensiondelvers.dimensiondelvers.config.codecs.RuneGemTierConfig;
import com.dimensiondelvers.dimensiondelvers.config.utils.CodecDataManager;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddReloadListenerEvent;

import java.util.*;

@EventBusSubscriber(modid = DimensionDelvers.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ConfigManager {

    private static final CodecDataManager<ExampleConfig> exampleConfig = new CodecDataManager<>(ExampleConfig.CODEC, "config");
    private static final CodecDataManager<RuneGemTierConfig> runegemTierConfig = new CodecDataManager<>(RuneGemTierConfig.CODEC, "runegem_tier");

    @SubscribeEvent
    public static void onAddReloadListeners(AddReloadListenerEvent event) {
        event.addListener(exampleConfig);
        event.addListener(runegemTierConfig);
    }

    public static ExampleConfig getRandomConfig() {
        Map<ResourceLocation, ExampleConfig> data = exampleConfig.getData();
        List<ExampleConfig> configs = new ArrayList<>(data.values());

        int randomIdx = new Random().nextInt(configs.size());
        return configs.get(randomIdx);
    }

    // EW Stinky remove and replace with more optimized
    // version for usage in PROD. ie for testing purpose ONLY
    public static RuneGemTierConfig getRandomRuneTier() {
        double totalWeight = 0;
        Map<ResourceLocation, RuneGemTierConfig> tiers = runegemTierConfig.getData();
        ArrayList<RuneGemTierConfig> tierList = new ArrayList<>(tiers.values());
        TreeMap<Double, RuneGemTierConfig> weightedMap = new TreeMap<>();

        for (RuneGemTierConfig tier : tierList) {
            totalWeight += tier.weight;
            weightedMap.put(totalWeight, tier);
        }

        double randomValue = new Random().nextDouble() * totalWeight;
        return weightedMap.higherEntry(randomValue).getValue();
    }
}
