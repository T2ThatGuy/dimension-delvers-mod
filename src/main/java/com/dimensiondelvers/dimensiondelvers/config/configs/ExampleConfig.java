package com.dimensiondelvers.dimensiondelvers.config.configs;

import com.dimensiondelvers.dimensiondelvers.config.CodecDataManager;
import com.dimensiondelvers.dimensiondelvers.config.codecs.ExampleCodec;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class ExampleConfig extends CodecDataManager<ExampleCodec> {
    private static final Logger LOGGER = LogUtils.getLogger();

    public ExampleConfig() {
        super(ExampleCodec.CODEC, "config");
    }

    public ExampleCodec getRandomConfig() {
        Map<ResourceLocation, ExampleCodec> data = this.getData();
        ArrayList<ExampleCodec> configs = new ArrayList<>(data.values());

        int randomIdx = new Random().nextInt(configs.size());
        return configs.get(randomIdx);
    }
}
