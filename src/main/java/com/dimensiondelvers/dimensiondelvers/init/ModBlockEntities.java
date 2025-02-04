package com.dimensiondelvers.dimensiondelvers.init;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.dimensiondelvers.dimensiondelvers.blockentity.SocketTableBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, DimensionDelvers.MODID);

    public static final Supplier<BlockEntityType<SocketTableBlockEntity>> SOCKET_TABLE_BLOCK_ENTITY = BLOCK_ENTITIES.register(
            "socket_table",
            () -> BlockEntityType.Builder.of(
                            SocketTableBlockEntity::new,
                            ModBlocks.SOCKET_TABLE.get()
                    )
                    // Build using null; vanilla does some datafixer shenanigans with the parameter that we don't need.
                    .build(null)
    );
}
