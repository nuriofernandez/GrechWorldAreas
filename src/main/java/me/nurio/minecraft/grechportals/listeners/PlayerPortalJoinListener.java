package me.nurio.minecraft.grechportals.listeners;

import me.nurio.minecraft.grechportals.events.PlayerJoinPortalEvent;
import me.nurio.minecraft.grechportals.portals.GPortal;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 * Handles the portal action executions when a player joins a portal.
 */
public class PlayerPortalJoinListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onJoinPortal(PlayerJoinPortalEvent event) {
        Player player = event.getPlayer();
        GPortal portal = event.getPortal();

        Bukkit.broadcastMessage("You joined to " + event.getPortal().getName());
    }

}