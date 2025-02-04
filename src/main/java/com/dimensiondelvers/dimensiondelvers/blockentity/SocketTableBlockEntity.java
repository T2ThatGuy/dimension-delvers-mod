package com.dimensiondelvers.dimensiondelvers.blockentity;

import com.dimensiondelvers.dimensiondelvers.gui.container.SocketTableContainerMenu;
import com.dimensiondelvers.dimensiondelvers.init.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SocketTableBlockEntity extends BaseContainerBlockEntity {
    public static final int SIZE = 9;
    private NonNullList<ItemStack> items = NonNullList.withSize(SIZE, ItemStack.EMPTY);

    public SocketTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SOCKET_TABLE_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return SIZE;
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("menu.title.dimensiondelvers.socket_table");
    }

    @Override
    protected @NotNull SocketTableContainerMenu createMenu(int containerId, @NotNull Inventory playerInventory) {
        return new SocketTableContainerMenu(containerId, playerInventory);
    }
}
