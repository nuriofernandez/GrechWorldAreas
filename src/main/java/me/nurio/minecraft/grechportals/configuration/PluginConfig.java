package me.nurio.minecraft.grechportals.configuration;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public interface PluginConfig {

    @NotNull Plugin getPlugin();

    @NotNull FileConfiguration getConfig();

    @NotNull File getConfigFile();

    /**
     * Alias to getConfig().set()
     *
     * @param path
     * @param o
     */
    default void set(String path, Object o) {
        getConfig().set(path, o);
    }

    /**
     * Copy defaults from resources if not exists.
     */
    default void saveDefaultConfig() {
        if (!getConfigFile().exists()) getPlugin().saveResource(getConfigFile().getName(), false);
    }

    /**
     * Save configuration to file.
     */
    default void save() {
        try {
            getConfig().save(getConfigFile());
        } catch (IOException ex) {
            System.err.println("Could not save config to " + getConfigFile().getName());
            System.err.println(ex.getMessage());
        }
    }

}