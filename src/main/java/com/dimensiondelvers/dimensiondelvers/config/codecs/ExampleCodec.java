package com.dimensiondelvers.dimensiondelvers.config.codecs;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;


// Just an example can be defined anywhere
public class ExampleCodec {

    private final ResourceLocation id;
    private final int testInteger;
    private final String testString;

    public static final Codec<ExampleCodec> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceLocation.CODEC.fieldOf("id").forGetter(ExampleCodec::getId),
            Codec.INT.fieldOf("test_integer").forGetter(ExampleCodec::getTestInteger),
            Codec.STRING.fieldOf("test_string").forGetter(ExampleCodec::getTestString)
    ).apply(instance, ExampleCodec::new));
    public static final ExampleCodec EMPTY = new ExampleCodec(ResourceLocation.fromNamespaceAndPath(DimensionDelvers.MODID, "default"), -1, "");

    public ExampleCodec(ResourceLocation id, int integer, String string) {
        this.id = id;
        this.testInteger = integer;
        this.testString = string;
    }

    public ResourceLocation getId () {
        return this.id;
    }

    public String getTestString() {
        return this.testString;
    }

    public Integer getTestInteger() {
        return this.testInteger;
    }
}


