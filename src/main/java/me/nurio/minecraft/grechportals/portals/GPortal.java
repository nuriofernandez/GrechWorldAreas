package me.nurio.minecraft.grechportals.portals;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Representation of a portal that activates custom actions.
 */
public class GPortal {

    private List<Location> portalBlocks;
    private List<Chunk> portalChunks;

    @Getter private GActions actions;
    @Getter private Location portalCenter;

    /**
     * Creates a new portal instance.
     *
     * @param portalBlocks List of blocks that activates this portal actions.
     * @param actions      Actions to execute when someone joins this portal.
     */
    public GPortal(@NotNull List<Location> portalBlocks, @NonNull GActions actions) {
        this.portalCenter = portalBlocks.get(0); // TODO : Calculate center of the portal.

        // This will optimize the future checks on portal location.
        this.portalBlocks = portalBlocks;
        this.portalChunks = portalBlocks.stream()
            .map(Location::getChunk)
            .distinct()
            .collect(Collectors.toList());

        // Store portal join actions.
        this.actions = actions;
    }

    /**
     * Checks if the provided locations is inside the portal blocks.
     *
     * @param location Location to check if is inside.
     * @return true in case provided location is part of the portal.
     */
    public boolean isInside(Location location) {
        if (!portalChunks.contains(location.getChunk())) return false;
        return portalBlocks.contains(location);
    }

    /**
     * Performs portal activation actions to provided player.
     *
     * @param player Player to active actions.
     */
    public void performActionsTo(Player player) {
        actions.performActionsTo(player);
    }

}