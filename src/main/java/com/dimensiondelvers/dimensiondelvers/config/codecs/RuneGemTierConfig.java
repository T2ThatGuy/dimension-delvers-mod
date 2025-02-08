package com.dimensiondelvers.dimensiondelvers.config.codecs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class RuneGemTierConfig {

    public String name;
    public int weight;

    public static final Codec<RuneGemTierConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("name").forGetter(RuneGemTierConfig::getName),
            Codec.INT.fieldOf("weight").forGetter(RuneGemTierConfig::getWeight)
    ).apply(instance, RuneGemTierConfig::new));

    // Default empty data instance (for error handling)
    public static final RuneGemTierConfig EMPTY = new RuneGemTierConfig("", 0);

    public RuneGemTierConfig(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    private String getName() {
        return name;
    }

    private Integer getWeight() {
        return weight;
    }
}
