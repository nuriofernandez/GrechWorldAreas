package me.nurio.minecraft.grechportals.portals;

import lombok.AllArgsConstructor;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.function.Function;

public class BlockArea {

    private final World world;

    private final Location start;
    private final Location end;

    public BlockArea(Location start, Location end) {
        if (start.getWorld().getUID() != end.getWorld().getUID()) {
            throw new RuntimeException("Could not create an area between two different worlds.");
        }

        this.world = start.getWorld();
        this.start = start;
        this.end = end;
    }

    public boolean isInside(Location location) {
        if (location.getWorld().getUID() != world.getUID()) return false;

        var dimensions = dimensions(
            Location::getBlockX,
            Location::getBlockY,
            Location::getBlockZ
        );
        return isInsideArea(location, dimensions);
    }

    @SafeVarargs
    private Function<Location, Integer>[] dimensions(Function<Location, Integer>... axis) {
        return axis;
    }

    @SafeVarargs
    private boolean isInsideArea(Location location, Function<Location, Integer>... dimensions) {
        for (Function<Location, Integer> dimension : dimensions) {
            if (!isInAxis(location, dimension)) return false;
        }
        return true;
    }

    private boolean isInAxis(Location location, Function<Location, Integer> blockAxis) {
        boolean a = blockAxis.apply(location) >= blockAxis.apply(start) && blockAxis.apply(location) <= blockAxis.apply(end);
        boolean b = blockAxis.apply(location) <= blockAxis.apply(start) && blockAxis.apply(location) >= blockAxis.apply(end);
        return a || b;
    }

}