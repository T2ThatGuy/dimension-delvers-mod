package com.dimensiondelvers.dimensiondelvers.config.codecs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class RuneGemTierCodec {

    private final String name;
    private final int weight;

    public static final Codec<RuneGemTierCodec> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("name").forGetter(RuneGemTierCodec::getName),
            Codec.INT.fieldOf("weight").forGetter(RuneGemTierCodec::getWeight)
    ).apply(instance, RuneGemTierCodec::new));

    public static final RuneGemTierCodec EMPTY = new RuneGemTierCodec("", 0);

    public RuneGemTierCodec(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }



    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }
}
