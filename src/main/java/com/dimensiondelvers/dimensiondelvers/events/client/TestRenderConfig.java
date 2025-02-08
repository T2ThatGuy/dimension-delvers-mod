package com.dimensiondelvers.dimensiondelvers.events.client;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.dimensiondelvers.dimensiondelvers.config.ConfigListener;
import com.dimensiondelvers.dimensiondelvers.config.codecs.ExampleConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(modid = DimensionDelvers.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME)
public class TestRenderConfig {

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        if (Minecraft.getInstance().screen == null) {
            renderExampleConfig(event.getGuiGraphics());
        }
    }

    private static void renderExampleConfig(GuiGraphics graphics) {
        Minecraft mc = Minecraft.getInstance();

        ExampleConfig config = ConfigListener.getConfig();
        Component message = Component.literal("Data from server: (integer) " + config.testInteger + " (string) " + config.testString);

        int screenWidth = mc.getWindow().getGuiScaledWidth();

        int x = (screenWidth - mc.font.width(message)) / 2;
        int y = 5;

        graphics.drawString(mc.font, message, x, y, 0xFFFFFF, true);
    }
}
