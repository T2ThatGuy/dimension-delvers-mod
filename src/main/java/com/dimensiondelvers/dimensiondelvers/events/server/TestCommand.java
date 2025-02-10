package com.dimensiondelvers.dimensiondelvers.events.server;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.dimensiondelvers.dimensiondelvers.config.ConfigManager;
import com.dimensiondelvers.dimensiondelvers.config.codecs.ExampleCodec;
import com.dimensiondelvers.dimensiondelvers.config.codecs.RuneGemTierCodec;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import java.util.Map;
import java.util.Set;

@EventBusSubscriber(modid = DimensionDelvers.MODID, bus = EventBusSubscriber.Bus.GAME)
public class TestCommand {
    @SubscribeEvent
    public static void onRegisterCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("showconfig").executes(TestCommand::execute)
        );

        event.getDispatcher().register(
                Commands.literal("randomrunetype").executes(TestCommand::execute_rune)
        );

        event.getDispatcher().register(
                Commands.literal("testingrunes").executes(TestCommand::execute_test)
        );
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        ExampleCodec config = ConfigManager.EXAMPLE.getRandomConfig();
        context.getSource().sendSuccess(
                () -> Component.literal("Data from server: (integer) " + config.getTestInteger() + " (string) " + config.getTestString()),
                false
        );

        return Command.SINGLE_SUCCESS;
    }

    private static int execute_rune(CommandContext<CommandSourceStack> context) {
        RuneGemTierCodec tier = ConfigManager.RUNEGEM_TIER.getRandomRuneTier();
        context.getSource().sendSuccess(
                () -> Component.literal("Rolled tier " + tier.getName()),
                false
        );

        return Command.SINGLE_SUCCESS;
    }

    private static int execute_test(CommandContext<CommandSourceStack> context) {
        Map<ResourceLocation, RuneGemTierCodec> tier = ConfigManager.RUNEGEM_TIER.getSpecificRuneTier();
        Set<ResourceLocation> keys = tier.keySet();

        for (ResourceLocation key : keys) {
            context.getSource().sendSuccess(
                    () -> Component.literal(key.getNamespace() + " | " + key.getPath()),
                    false
            );
        }

        context.getSource().sendSuccess(
                () -> Component.literal("Success"),
                false
        );

        return Command.SINGLE_SUCCESS;
    }
}
