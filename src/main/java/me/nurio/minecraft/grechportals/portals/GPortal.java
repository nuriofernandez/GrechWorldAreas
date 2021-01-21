package me.nurio.minecraft.grechportals.portals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Representation of a portal that activates custom actions.
 */
@AllArgsConstructor
public class GPortal {

    @Getter @NotNull private String name;
    @Getter @NotNull private BlockArea area;
    @Getter @NotNull private GActions actions;

    /**
     * Checks if the provided locations is inside the portal blocks.
     *
     * @param location Location to check if is inside.
     * @return true in case provided location is part of the portal.
     */
    public boolean isInside(Location location) {
        return area.isInside(location);
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