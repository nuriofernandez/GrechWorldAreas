package me.nurio.minecraft.worldareas.admin;

import me.nurio.minecraft.worldareas.admin.subcommands.HelpSubCommand;
import me.nurio.minecraft.worldareas.admin.subcommands.WhereAmSubCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class GrechAreasCommand implements CommandExecutor {

    private static Map<String, SubCommand> commands = new HashMap<>(){
        {
            put("help", new HelpSubCommand());
            put("wheream", new WhereAmSubCommand());
        }
    };

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command");
            return false;
        }

        if (!player.hasPermission("grechareas.admin") || !player.isOp()) {
            player.sendMessage("You don't have permissions to use this command");
            return false;
        }

        if (args.length <= 1) {
            commands.get("help").execute(player, args);
            return false;
        }

        String subCommand = args[0].toLowerCase();

        if (!commands.containsKey(subCommand)) {
            commands.get("help").execute(player, args);
            return false;
        }

        commands.get(subCommand).execute(player, args);
        return false;
    }

}
