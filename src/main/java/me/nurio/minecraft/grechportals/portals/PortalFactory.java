package me.nurio.minecraft.grechportals.portals;

import lombok.Getter;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * PortalFactory manages active portals, listing, search, etc.
 */
public class PortalFactory {

    @Getter private List<GPortal> portals = new ArrayList<>();

    /**
     * Registers a new portal to the list of portals.
     *
     * @param portal Portal to register.
     */
    public void addPortal(@NotNull GPortal portal) {
        portals.add(portal);
    }

    /**
     * Obtains a portal instance from location.
     *
     * @param location Location to check if there are any portal.
     * @return Portal instance in case of any, null otherwise.
     */
    @Nullable
    public GPortal fromLocation(@NotNull Location location) {
        return portals.stream()
            .filter(gPortal -> gPortal.isInside(location))
            .findAny()
            .orElse(null);
    }

    /**
     * Checks if there is any portal at provided location.
     * - Take care with calling this method before #fromLocation() that will be a performance waste.
     *
     * @param location Location to check if there are any portal.
     * @return true in case there is any portal, false otherwise.
     */
    public boolean isAnyPortalAt(@NotNull Location location) {
        return portals.stream()
            .anyMatch(gPortal -> gPortal.isInside(location));
    }

}