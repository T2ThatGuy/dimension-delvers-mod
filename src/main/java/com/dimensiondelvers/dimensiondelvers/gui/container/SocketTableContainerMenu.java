package com.dimensiondelvers.dimensiondelvers.gui.container;

import com.dimensiondelvers.dimensiondelvers.init.ModMenuTypes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SocketTableContainerMenu extends AbstractContainerMenu {
    // https://docs.neoforged.net/docs/1.21.1/gui/menus/

    public SocketTableContainerMenu(int containerId, Inventory playerInventory) {
        super(ModMenuTypes.SOCKET_TABLE_CONTAINER_MENU.get(), containerId);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int i) {
        return player.getInventory().getItem(i); // ??? idk
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return true;
    }
}
