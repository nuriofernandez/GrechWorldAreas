package me.nurio.minecraft.grechportals.listeners;

import me.nurio.minecraft.grechportals.GrechPortals;
import me.nurio.minecraft.grechportals.events.PlayerJoinPortalEvent;
import me.nurio.minecraft.grechportals.portals.GPortal;
import me.nurio.minecraft.grechportals.portals.PortalFactory;
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

    private PortalFactory portalFactory = GrechPortals.getPortalFactory();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        // Prevent searching for portals on small movements.
        if (event.getFrom().getBlock() == event.getTo().getBlock()) return;

        // Check if any portal matches the player location.
        // TODO : Review possible optimizations to avoid using a stream.
        Location location = event.getTo();
        GPortal portalTo = portalFactory.fromLocation(event.getTo());
        GPortal portalFrom = portalFactory.fromLocation(event.getFrom());

        // Exit in case none portal matches the player location.
        if (portalTo == null) return;

        // Exit in case the movement was inside the same portal.
        if (portalFrom != null && portalTo == portalFrom) return;

        // Launch PlayerJoinPortalEvent cause the player has joined to one.
        // TODO : Review possible concurrency improvements.
        Player player = event.getPlayer();
        PlayerJoinPortalEvent portalJoinEvent = new PlayerJoinPortalEvent(player, location, portalTo);
        Bukkit.getPluginManager().callEvent(portalJoinEvent);

        // Perform portal actions to the player.
        portalTo.performActionsTo(player);
    }

}