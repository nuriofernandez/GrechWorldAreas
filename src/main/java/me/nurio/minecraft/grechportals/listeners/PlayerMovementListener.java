package me.nurio.minecraft.grechportals.listeners;

import me.nurio.minecraft.grechportals.GrechPortals;
import me.nurio.minecraft.grechportals.events.PlayerJoinPortalEvent;
import me.nurio.minecraft.grechportals.portals.GPortal;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Listens to the movements of all players in order to detect portal joins.
 */
public class PlayerMovementListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        // Prevent searching for portals on small movements.
        if (event.getFrom().getBlock() == event.getTo().getBlock()) return;

        // Check if any portal matches the player location.
        // TODO : This list search should be placed on a dedicated manager class.
        // TODO : Review possible optimizations to avoid using a stream.
        Location location = event.getTo();
        GPortal portal = GrechPortals.getPortals().stream()
            .filter(gPortal -> gPortal.isInside(location))
            .findAny()
            .orElse(null);

        // Exit in case none portal matches the player location.
        if (portal == null) return;

        // Launch PlayerJoinPortalEvent cause the player has joined to one.
        // TODO : Review possible concurrency improvements.
        Player player = event.getPlayer();
        PlayerJoinPortalEvent portalJoinEvent = new PlayerJoinPortalEvent(player, location, portal);
        Bukkit.getPluginManager().callEvent(portalJoinEvent);
    }

}