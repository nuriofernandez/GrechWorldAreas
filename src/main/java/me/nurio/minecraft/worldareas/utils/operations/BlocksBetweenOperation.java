package me.nurio.minecraft.worldareas.utils.operations;

import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class BlocksBetweenOperation {

    private final Location start;
    private final Location end;

    public List<Location> getBlocksBetween() {
        World world = start.getWorld();

        List<Location> locations = new ArrayList<>();
        for (int y : getAxisRange(Location::getBlockY)) {
            for (int x : getAxisRange(Location::getBlockX)) {
                for (int z : getAxisRange(Location::getBlockZ)) {
                    locations.add(new Location(world, x + .5, y + .5, z + .5)); // center it
                }
            }
        }
        return locations;
    }

    private List<Integer> getAxisRange(Function<Location, Integer> axis) {
        int a = axis.apply(start);
        int b = axis.apply(end);
        return IntStream.range(Math.min(a, b), Math.max(a, b) + 1)
            .boxed().collect(Collectors.toList());
    }

}