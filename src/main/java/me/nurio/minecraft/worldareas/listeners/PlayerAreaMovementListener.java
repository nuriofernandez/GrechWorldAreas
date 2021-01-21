package me.nurio.minecraft.worldareas.listeners;

import me.nurio.minecraft.worldareas.events.PlayerJoinAreaEvent;
import me.nurio.minecraft.worldareas.events.PlayerLeaveAreaEvent;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlayerAreaMovementListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoin(PlayerJoinAreaEvent event) {
        Player player = event.getPlayer();
        WorldArea area = event.getWorldArea();

        String message = ChatColor.translateAlternateColorCodes(
            '&', "&aYou joined to &e" + event.getWorldArea().getName()
        );
        player.sendTitle("World Areas", message, 1, 20, 1);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onLeave(PlayerLeaveAreaEvent event) {
        Player player = event.getPlayer();
        WorldArea area = event.getWorldArea();

        String message = ChatColor.translateAlternateColorCodes(
            '&', "&cYou left to &e" + event.getWorldArea().getName()
        );
        player.sendTitle("World Areas", message, 1, 20, 1);
    }

}