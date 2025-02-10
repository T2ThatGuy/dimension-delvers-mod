package com.dimensiondelvers.dimensiondelvers.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import javax.annotation.Nullable;
import java.util.*;

// Initially based upon @Patrigans' repo
// https://github.com/Infamous-Misadventures/FactionCraft
public class CodecDataManager<TCodec> extends SimpleJsonResourceReloadListener {

    private final static Gson GSON = new Gson();
    private final Codec<TCodec> codec;

    private String directory;
    private Map<ResourceLocation, TCodec> data = new HashMap<>();

    public CodecDataManager(Codec<TCodec> codec, String directory) {
        super(GSON, directory);
        this.codec = codec;
        this.directory = directory;
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> object, ResourceManager resourceManager, ProfilerFiller profiler) {

        data = new HashMap<>();

        for (Map.Entry<ResourceLocation, JsonElement> entry : object.entrySet()) {
            ResourceLocation key = entry.getKey();
            JsonElement element = entry.getValue();

            DataResult<TCodec> parsedConfig = codec.parse(JsonOps.INSTANCE, element);
            if (parsedConfig.isSuccess()) {
                data.put(key, parsedConfig.getOrThrow());
                continue;
            }

            LogUtils.getLogger().error("Error in config (" + directory + ") " + parsedConfig.error().toString());
        }
    }

    public Map<ResourceLocation, TCodec> getData() {
        return data;
    }

    @Nullable
    public TCodec getDataByResource(ResourceLocation location) {
        return data.get(location);
    }
}
