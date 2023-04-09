package me.nurio.minecraft.worldareas.areas.expands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.List;

public interface WorldAreaBarrier {

    List<Location> getBlocks();

    default void showBarrierTo(Player player, int limit) {
        getBlocks().stream()
            .filter(location -> player.getLocation().distance(location) <= limit) // max area to render.
            .forEach(location -> player.spawnParticle(Particle.BLOCK_MARKER, location, 1, Bukkit.createBlockData(Material.BARRIER)));
    }

    default void showBarrierTo(Player player) {
        showBarrierTo(player, 48);
    }

}