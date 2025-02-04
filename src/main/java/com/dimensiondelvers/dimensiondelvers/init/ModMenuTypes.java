package com.dimensiondelvers.dimensiondelvers.init;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.dimensiondelvers.dimensiondelvers.gui.container.SocketTableContainerMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, DimensionDelvers.MODID);

    public static final Supplier<MenuType<SocketTableContainerMenu>> SOCKET_TABLE_CONTAINER_MENU = MENUS.register("socket_table_container_menu", () -> new MenuType<>(SocketTableContainerMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
