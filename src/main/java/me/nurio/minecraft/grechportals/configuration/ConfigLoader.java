package me.nurio.minecraft.grechportals.configuration;

import me.nurio.bukkit.configuration.files.GrechConfig;
import me.nurio.minecraft.grechportals.GrechPortals;
import me.nurio.minecraft.grechportals.portals.BlockArea;
import me.nurio.minecraft.grechportals.portals.GActions;
import me.nurio.minecraft.grechportals.portals.GPortal;
import org.bukkit.Location;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigLoader {

    public static void loadAll() {
        getPortalFiles().stream()
            .map(ConfigLoader::parse)
            .forEach(GrechPortals.getPortalFactory()::addPortal);
    }

    /**
     * Obtains a list of portal configuration files.
     *
     * @return List of YAML portal configuration files.
     */
    public static List<File> getPortalFiles() {
        File folder = new File(GrechPortals.getPlugin().getDataFolder() + File.separator + "portals");
        if (!folder.exists()) folder.mkdirs();
        return Arrays.stream(folder.listFiles())
            .filter(file -> file.getName().endsWith(".yml"))
            .collect(Collectors.toList());
    }

    public static GPortal parse(File file) {
        System.out.println("Loading " + file.getPath());

        GrechConfig config = new GrechConfig(GrechPortals.getPlugin(), "portals" + File.separator + file.getName());
        String name = config.getConfig().getString("name");
        Location start = config.getLocation("area.start");
        Location end = config.getLocation("area.end");

        return new GPortal(name, new BlockArea(start, end), new GActions());
    }

}