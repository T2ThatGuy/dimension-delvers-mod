package com.dimensiondelvers.dimensiondelvers.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;

/**
 * Loads configs from a given directory within a datapack and parses each
 * via the provided {@link Codec}, into a format of {@link ResourceLocation} -> {@link Codec}.
 * <p>
 * Which can be obtained with {@link CodecDataManager#getData() getData} or directly
 * referenced via the {@link ResourceLocation} with {@link CodecDataManager#getDataByResource(ResourceLocation) getDataByresource}
 * <p>
 * Intended that this class is extended upon to provide additional methods
 * on top of this class for per config functionality.
 */
public class CodecDataManager<TCodec> extends SimpleJsonResourceReloadListener<TCodec> {

    private final static Gson GSON = new Gson();
    private Map<ResourceLocation, TCodec> data = new HashMap<>();

    public CodecDataManager(Codec<TCodec> codec, String directory) {
        super(codec, FileToIdConverter.json(directory));
    }

    public Map<ResourceLocation, TCodec> getData() {
        return data;
    }

    @Nullable
    public TCodec getDataByResource(ResourceLocation location) {
        return data.get(location);
    }

    @Override
    protected void apply(
            @NotNull Map<ResourceLocation, TCodec> object,
            @NotNull ResourceManager resourceManager,
            @NotNull ProfilerFiller profiler
    ) {
        data = new HashMap<>();
        data.putAll(object);
    }
}
