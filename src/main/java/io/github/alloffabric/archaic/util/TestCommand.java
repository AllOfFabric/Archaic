package io.github.alloffabric.archaic.util;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.arguments.DimensionArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.world.dimension.DimensionType;

public class TestCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                CommandManager.literal("test")
                        .executes(context -> {
                            // /test
                            return 1;
                        })
                        .then(CommandManager.literal("subcommand1")
                                .executes(context -> {
                                    // /test subcommand1
                                    return 1;
                                })
                        )
                        .then(CommandManager.argument("subcommand2", DimensionArgumentType.dimension())
                                .executes(context -> {
                                    DimensionType dimensionParam = DimensionArgumentType.getDimensionArgument(context, "subcommand2");
                                    // /test subcommand2
                                    return 1;
                                })
                                .then(CommandManager.literal("sub")
                                        .executes(context -> {
                                            // /test subcommand2 sub
                                            return 1;
                                        })
                                )
                        )
        );
    }
}
