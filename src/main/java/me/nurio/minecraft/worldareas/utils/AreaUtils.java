package me.nurio.minecraft.worldareas.utils;

import me.nurio.minecraft.worldareas.utils.operations.BlocksBetweenOperation;
import org.bukkit.Location;

import java.util.List;

public interface AreaUtils {

    static List<Location> getBlocksBetween(Location start, Location end) {
        BlocksBetweenOperation betweenOperation = new BlocksBetweenOperation(start, end);
        return betweenOperation.getBlocksBetween();
    }

}