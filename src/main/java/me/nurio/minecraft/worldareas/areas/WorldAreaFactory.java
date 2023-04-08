package me.nurio.minecraft.worldareas.areas;

import lombok.Getter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WorldAreaFactory manages active world areas, listing, search, etc.
 */
public class WorldAreaFactory {

    @Getter private List<WorldArea> areas = new ArrayList<>();

    /**
     * Registers a new world area to the list of world areas.
     *
     * @param area World area to register.
     */
    public void addWorldArea(@NotNull WorldArea area) {
        areas.add(area);
    }

    /**
     * Obtains a world area instance from location.
     *
     * @param location Location to check if there are any world area.
     * @return List of WorldArea instances in case of any. Empty list otherwise.
     */
    @NotNull
    public List<WorldArea> fromLocation(@NotNull Location location) {
        return areas.stream()
            .filter(area -> area.isInside(location))
            .collect(Collectors.toList());
    }

    /**
     * Checks if there is any world area at provided location.
     * - Take care with calling this method before #fromLocation() that will be a performance waste.
     *
     * @param location Location to check if there are any world area.
     * @return true in case there is any world area, false otherwise.
     */
    public boolean isAnyWorldAreaAt(@NotNull Location location) {
        return areas.stream()
            .anyMatch(area -> area.isInside(location));
    }

}