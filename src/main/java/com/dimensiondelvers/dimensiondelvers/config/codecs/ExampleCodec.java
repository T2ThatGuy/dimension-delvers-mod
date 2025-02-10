package com.dimensiondelvers.dimensiondelvers.config.codecs;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;


// Just an example can be defined anywhere
public class ExampleCodec {

    private final int testInteger;
    private final String testString;

    public static final Codec<ExampleCodec> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("test_integer").forGetter(ExampleCodec::getTestInteger),
            Codec.STRING.fieldOf("test_string").forGetter(ExampleCodec::getTestString)
    ).apply(instance, ExampleCodec::new));
    public static final ExampleCodec EMPTY = new ExampleCodec(-1, "");

    public ExampleCodec(int integer, String string) {
        this.testInteger = integer;
        this.testString = string;
    }


    public String getTestString() {
        return this.testString;
    }

    public Integer getTestInteger() {
        return this.testInteger;
    }
}
