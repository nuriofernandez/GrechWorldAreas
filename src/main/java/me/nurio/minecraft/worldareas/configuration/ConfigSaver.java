package me.nurio.minecraft.worldareas.configuration;

import me.nurio.bukkit.configuration.files.GrechConfig;
import me.nurio.minecraft.worldareas.GrechAreas;
import me.nurio.minecraft.worldareas.areas.BlockArea;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class ConfigSaver {

    public static void saveAll() {
        GrechAreas.getWorldAreaFactory()
            .getAreas().stream()
            .forEach(ConfigSaver::save);
    }

    public static File save(WorldArea worldArea) {
        Bukkit.getLogger().info("Saving world area: " + worldArea.getUuid());

        GrechConfig config = new GrechConfig(GrechAreas.getPlugin(), "areas" + File.separator + worldArea.getUuid());

        // Save name and uuid
        String name = worldArea.getName();
        config.set("name", name);

        String uuid = worldArea.getUuid().toString();
        config.set("uuid", uuid);

        // Block areas

        // Dump existing data
        config.set("areas", null);
        ConfigurationSection areasSection = config.getConfig().createSection("areas");

        for (BlockArea area : worldArea.getAreas()) {
            // Calculate areaId
            int areaId = areasSection.getKeys(false).size();

            Bukkit.getLogger().info("Saving BlockArea '" + uuid + "'@'" + areaId + "'...");

            // Save locations
            ConfigurationSection section = areasSection.createSection("" + areaId);
            config.setLocation("areas."+areaId+".start", area.getStart());
            config.setLocation("areas."+areaId+".end", area.getEnd());
        }

        // Actually write to disk
        Bukkit.getLogger().info("Writing WorldArea '" + uuid + "' to disk...");
        config.save();

        return config.getConfigFile();
    }

}
