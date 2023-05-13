package me.nurio.minecraft.worldareas.admin.subcommands;

import me.nurio.minecraft.worldareas.GrechAreas;
import me.nurio.minecraft.worldareas.admin.SubCommand;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class WhereAmSubCommand implements SubCommand {

    @Override
    public boolean execute(Player player, @NotNull String[] args) {
        Location location = player.getLocation();
        List<WorldArea> worldAreas = GrechAreas.getWorldAreaFactory().fromLocation(location);

        if(worldAreas.isEmpty()) {
            player.sendMessage("You aren't in any area!");
            return true;
        }

        String listOfNames = worldAreas.stream()
                .map(it -> it.getUuid() + "/" + it.getName())
                .collect(Collectors.joining(","));

        player.sendMessage("Currently you are in the following areas:");
        player.sendMessage(listOfNames);
        return true;
    }

}
