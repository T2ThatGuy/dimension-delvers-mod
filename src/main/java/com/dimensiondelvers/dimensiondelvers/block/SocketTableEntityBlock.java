package com.dimensiondelvers.dimensiondelvers.block;

import com.dimensiondelvers.dimensiondelvers.blockentity.SocketTableBlockEntity;
import com.dimensiondelvers.dimensiondelvers.gui.container.SocketTableContainerMenu;
import com.dimensiondelvers.dimensiondelvers.gui.container.SocketTableContainerScreen;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SocketTableEntityBlock extends BaseEntityBlock {
    public static final MapCodec<SocketTableEntityBlock> CODEC = simpleCodec(SocketTableEntityBlock::new);

    public @NotNull MapCodec<SocketTableEntityBlock> codec() {
        return CODEC;
    }

    public SocketTableEntityBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new SocketTableBlockEntity(pos, state);
    }

    protected @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockentity = level.getBlockEntity(pos);
            if (blockentity instanceof SocketTableBlockEntity) {
                player.openMenu((SocketTableBlockEntity) blockentity);
            }

            return InteractionResult.CONSUME;
        }
    }
}