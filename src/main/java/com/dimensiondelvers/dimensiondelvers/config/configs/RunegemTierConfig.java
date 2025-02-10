package com.dimensiondelvers.dimensiondelvers.config.configs;

import com.dimensiondelvers.dimensiondelvers.config.CodecDataManager;
import com.dimensiondelvers.dimensiondelvers.config.codecs.RuneGemTierCodec;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class RunegemTierConfig extends CodecDataManager<RuneGemTierCodec> {

    public RunegemTierConfig() {
        super(RuneGemTierCodec.CODEC, "runegem_tier");
    }

    // EW Stinky remove and replace with more optimized
    // version for usage in PROD. ie for testing purpose ONLY
    public RuneGemTierCodec getRandomRuneTier() {
        double totalWeight = 0;
        Map<ResourceLocation, RuneGemTierCodec> tiers = this.getData();
        ArrayList<RuneGemTierCodec> tierList = new ArrayList<>(tiers.values());
        TreeMap<Double, RuneGemTierCodec> weightedMap = new TreeMap<>();

        for (RuneGemTierCodec tier : tierList) {
            totalWeight += tier.getWeight();
            weightedMap.put(totalWeight, tier);
        }

        double randomValue = new Random().nextDouble() * totalWeight;
        return weightedMap.higherEntry(randomValue).getValue();
    }

    public Map<ResourceLocation, RuneGemTierCodec> getSpecificRuneTier() {
        return this.getData();
    }
}
