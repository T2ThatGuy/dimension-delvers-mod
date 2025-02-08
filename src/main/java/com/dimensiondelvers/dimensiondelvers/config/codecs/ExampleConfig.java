package com.dimensiondelvers.dimensiondelvers.config.codecs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class ExampleConfig {

    public int testInteger;
    public String testString;

    public static final Codec<ExampleConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("test_integer").forGetter(ExampleConfig::getTestInteger),
            Codec.STRING.fieldOf("test_string").forGetter(ExampleConfig::getTestString)
    ).apply(instance, ExampleConfig::new));

    // Default empty data instance (for error handling)
    public static final ExampleConfig EMPTY = new ExampleConfig(-1, "");

    public ExampleConfig(int integer,  String string) {
        this.testInteger = integer;
        this.testString = string;
    }

    private String getTestString() {
        return this.testString;
    }

    private Integer getTestInteger() {
        return this.testInteger;
    }
}
