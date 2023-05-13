package me.nurio.minecraft.worldareas.admin.subcommands;

import me.nurio.minecraft.worldareas.GrechAreas;
import me.nurio.minecraft.worldareas.admin.SubCommand;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class HelpSubCommand implements SubCommand {

    @Override
    public boolean execute(Player player, @NotNull String[] args) {
        player.sendMessage("List of commands:");
        player.sendMessage("- /grechareas wheream >> Shows a list of areas at your location");
        return true;
    }

}
