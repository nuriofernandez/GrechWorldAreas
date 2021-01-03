package me.nurio.minecraft.grechportals.configuration;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

public class ConfigFile implements PluginConfig, LocationConfigParser {

    @Getter @NotNull private Plugin plugin;
    @Getter @NotNull private File configFile;
    @Getter @NotNull private FileConfiguration config;

    public ConfigFile(String filename, @NotNull Plugin plugin) {
        this.plugin = plugin;

        String configFileName = filename.endsWith(".yml") ? filename : filename + ".yml";
        this.configFile = getConfigFile(configFileName);
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    private File getConfigFile(String filename) {
        File configFile = new File(plugin.getDataFolder(), filename);
        if (!configFile.exists()) {
            try {
                configFile.getParentFile().mkdirs();
                configFile.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating plugin config file!");
                System.err.println(e.getMessage());
                throw new RuntimeException(e); // Rethrow the exception to avoid continuing.
            }
        }
        return configFile;
    }

}