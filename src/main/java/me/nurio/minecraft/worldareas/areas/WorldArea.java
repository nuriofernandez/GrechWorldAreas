package me.nurio.minecraft.worldareas.areas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Representation of a world area.
 */
@AllArgsConstructor
public class WorldArea {

    @Getter @NotNull private String name;
    @Getter @NotNull private UUID uuid;
    @Getter @NotNull private BlockArea area;

    /**
     * Checks if the provided locations is inside the world area blocks.
     *
     * @param location Location to check if is inside.
     * @return true in case provided location is part of the world area.
     */
    public boolean isInside(Location location) {
        return area.isInside(location);
    }

}