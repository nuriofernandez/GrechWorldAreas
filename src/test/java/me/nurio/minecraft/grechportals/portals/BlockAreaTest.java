package me.nurio.minecraft.grechportals.portals;

import org.bukkit.Location;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BlockAreaTest {

    @Test
    public void insidePositive() {
        Location start = new Location(null, 5, 5, 5);
        Location end = new Location(null, 3, 3, 3);
        BlockArea blockArea = new BlockArea(start, end);

        Location inside = new Location(null, 4, 4, 4);
        assertTrue(blockArea.isInside(inside));
    }

    @Test
    public void outsidePositive() {
        Location start = new Location(null, 5, 5, 5);
        Location end = new Location(null, 3, 3, 3);
        BlockArea blockArea = new BlockArea(start, end);

        Location inside = new Location(null, 6, 6, 6);
        assertFalse(blockArea.isInside(inside));
    }

    @Test
    public void insideNegative() {
        Location start = new Location(null, -2, -2, -2);
        Location end = new Location(null, 1, 1, 1);
        BlockArea blockArea = new BlockArea(start, end);

        Location inside = new Location(null, 0, 0, 0);
        assertTrue(blockArea.isInside(inside));
    }

    @Test
    public void outsideNegative() {
        Location start = new Location(null, -2, -2, -2);
        Location end = new Location(null, 1, 1, 1);
        BlockArea blockArea = new BlockArea(start, end);

        Location inside = new Location(null, 2, 2, 2);
        assertFalse(blockArea.isInside(inside));
    }

}