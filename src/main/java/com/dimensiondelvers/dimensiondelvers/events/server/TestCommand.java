package com.dimensiondelvers.dimensiondelvers.events.server;

import com.dimensiondelvers.dimensiondelvers.DimensionDelvers;
import com.dimensiondelvers.dimensiondelvers.config.ConfigManager;
import com.dimensiondelvers.dimensiondelvers.config.codecs.ExampleConfig;
import com.dimensiondelvers.dimensiondelvers.config.codecs.RuneGemTierConfig;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

@EventBusSubscriber(modid = DimensionDelvers.MODID, bus = EventBusSubscriber.Bus.GAME)
public class TestCommand {
    @SubscribeEvent
    public static void onRegisterCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(
                Commands.literal("showconfig").executes(TestCommand::execute)
        );

        event.getDispatcher().register(
                Commands.literal("rollrunetype").executes(TestCommand::execute_rune)
        );
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        ExampleConfig config = ConfigManager.getRandomConfig();
        context.getSource().sendSuccess(
                () -> Component.literal("Data from server: (integer) " + config.testInteger + " (string) " + config.testString),
                false
        );

        return Command.SINGLE_SUCCESS;
    }

    private static int execute_rune(CommandContext<CommandSourceStack> context) {
        RuneGemTierConfig tier = ConfigManager.getRandomRuneTier();
        context.getSource().sendSuccess(
                () -> Component.literal("Rolled tier " + tier.name),
                false
        );

        return Command.SINGLE_SUCCESS;
    }
}
