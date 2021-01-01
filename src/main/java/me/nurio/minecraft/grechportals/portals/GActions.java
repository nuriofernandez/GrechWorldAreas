package me.nurio.minecraft.grechportals.portals;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Represents actions to execute when someone joins a Grech Portal.
 *
 * @see GPortal to understand how portals works.
 */
public class GActions {

    private Location teleportTo;

    /**
     * Performs portal activation actions to provided player.
     *
     * @param player Player to active actions.
     */
    public void performActionsTo(Player player) {
        if (teleportTo != null) player.teleport(teleportTo);
    }

}