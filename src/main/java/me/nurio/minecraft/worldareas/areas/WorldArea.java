package me.nurio.minecraft.worldareas.areas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.nurio.minecraft.worldareas.areas.expands.WorldAreaBarrier;
import me.nurio.minecraft.worldareas.utils.AreaUtils;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.UUID;

/**
 * Representation of a world area.
 */
@AllArgsConstructor
public class WorldArea implements WorldAreaBarrier {

    @Getter @NotNull private String name;
    @Getter @NotNull private UUID uuid;
    @Getter @NotNull private BlockArea area;

    @Getter(lazy = true) private final List<Location> blocks = AreaUtils.getBlocksBetween(area.getStart(), area.getEnd());

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