package me.nurio.minecraft.worldareas.listeners;

import me.nurio.minecraft.worldareas.GrechAreas;
import me.nurio.minecraft.worldareas.events.PlayerJoinAreaEvent;
import me.nurio.minecraft.worldareas.events.PlayerLeaveAreaEvent;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import me.nurio.minecraft.worldareas.areas.WorldAreaFactory;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Listens to the movements of all players in order to detect the join or leave of an area.
 */
public class PlayerMovementListener implements Listener {

    private final WorldAreaFactory worldAreaFactory = GrechAreas.getWorldAreaFactory();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        // Prevent searching for world areas on small movements.
        if (event.getFrom().getBlock() == event.getTo().getBlock()) return;

        // Check if any world area matches the player location.
        // TODO : Review possible optimizations to avoid using a stream.
        Location location = event.getTo();
        WorldArea areaTo = worldAreaFactory.fromLocation(event.getTo());
        WorldArea areaFrom = worldAreaFactory.fromLocation(event.getFrom());

        // Exit in case none world area matches the player location.
        if (areaTo == null && areaFrom == null) return;

        // TODO : Support multiple areas at the same place.
        // Exit in case the movement was inside the same world area.
        if (areaFrom != null && areaTo == areaFrom) return;

        // Send leave event in case there is no area in the next location to move.
        if (areaTo == null) {
            leave(event.getPlayer(), location, areaFrom);
            return;
        }

        // Send join event.
        join(event.getPlayer(), location, areaTo);
    }

    private void join(Player player, Location location, WorldArea area) {
        PlayerJoinAreaEvent areaJoinEvent = new PlayerJoinAreaEvent(player, location, area);
        Bukkit.getPluginManager().callEvent(areaJoinEvent);
    }

    private void leave(Player player, Location location, WorldArea area) {
        PlayerLeaveAreaEvent areaLeaveEvent = new PlayerLeaveAreaEvent(player, location, area);
        Bukkit.getPluginManager().callEvent(areaLeaveEvent);
    }

}