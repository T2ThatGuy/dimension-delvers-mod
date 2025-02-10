package com.dimensiondelvers.dimensiondelvers.events.client;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.dimensiondelvers.dimensiondelvers.config.ConfigManager;
import com.dimensiondelvers.dimensiondelvers.config.codecs.ExampleCodec;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(modid = DimensionDelvers.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.GAME)
public class TestRenderConfig {

    private static ExampleCodec config;

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        if (Minecraft.getInstance().screen == null) {
            renderExampleConfig(event.getGuiGraphics());
        }
    }

    private static void renderExampleConfig(GuiGraphics graphics) {
        Minecraft mc = Minecraft.getInstance();
//        if (config == null) {
//            config = ConfigManager.EXAMPLE.getRandomConfig();
//        }

        if (config == null) {
            return;
        }
        Component message = Component.literal("Data from server: (integer) " + config.getTestInteger() + " (string) " + config.getTestString());

        int screenWidth = mc.getWindow().getGuiScaledWidth();

        int x = (screenWidth - mc.font.width(message)) / 2;
        int y = 5;

        graphics.drawString(mc.font, message, x, y, 0xFFFFFF, true);
    }
}
