package com.dimensiondelvers.dimensiondelvers.config.codecs;

import com.dimensiondelvers.dimensiondelvers.item.runegem.RuneGemTier;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class RuneGemTierCodec {

    private final RuneGemTier name;
    private final int weight;

    public static final Codec<RuneGemTierCodec> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            RuneGemTier.CODEC.fieldOf("name").forGetter(RuneGemTierCodec::getName),
            Codec.INT.fieldOf("weight").forGetter(RuneGemTierCodec::getWeight)
    ).apply(instance, RuneGemTierCodec::new));

    public static final RuneGemTierCodec EMPTY = new RuneGemTierCodec(RuneGemTier.RAW, 0);

    public RuneGemTierCodec(RuneGemTier name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public RuneGemTier getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }
}
