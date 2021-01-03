package me.nurio.minecraft.grechportals.configuration;

import me.nurio.minecraft.grechportals.GrechPortals;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigLoader {

    public void loadAll() {

    }

    /**
     * Obtains a list of portal configuration files.
     *
     * @return List of YAML portal configuration files.
     */
    public List<File> getPortalFiles() {
        File folder = new File(GrechPortals.getPlugin().getDataFolder() + File.separator + "portals");
        if (!folder.exists()) folder.mkdirs();
        return Arrays.stream(folder.listFiles())
            .filter(file -> file.getName().endsWith(".yml"))
            .collect(Collectors.toList());
    }

    public void parse(File file) {

    }

}