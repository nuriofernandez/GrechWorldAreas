package me.nurio.minecraft.grechportals.configuration;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public interface LocationConfigParser extends PluginConfig {

    /**
     * Save Location to YAML.
     * Include: World, x, y, z, yaw and pitch
     *
     * @param path     YAML location root path.
     * @param location Location to save to YAML.
     */
    default void setLocation(String path, Location location) {
        getConfig().set(path + ".w", location.getWorld().getName());
        getConfig().set(path + ".x", location.getX());
        getConfig().set(path + ".y", location.getY());
        getConfig().set(path + ".z", location.getZ());
        getConfig().set(path + ".yaw", location.getYaw());
        getConfig().set(path + ".pitch", location.getPitch());
    }

    /**
     * Obtain location from config.
     * Include: World, x, y, z, yaw and pitch
     *
     * @param path YAML location root path.
     * @return Location at provided YAML path.
     */
    default Location getLocation(String path) {
        String worldName = getConfig().getString(path + ".w");
        World world = Bukkit.getWorld(worldName);

        double x = getConfig().getDouble(path + ".x");
        double y = getConfig().getDouble(path + ".y");
        double z = getConfig().getDouble(path + ".z");

        float yaw = Float.parseFloat("" + getConfig().getDouble(path + ".yaw"));
        float pitch = Float.parseFloat("" + getConfig().getDouble(path + ".pitch"));

        return new Location(world, x, y, z, yaw, pitch);
    }

}