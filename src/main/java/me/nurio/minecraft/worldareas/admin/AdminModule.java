package me.nurio.minecraft.worldareas.admin;

import me.nurio.minecraft.worldareas.GrechAreas;
import org.bukkit.Bukkit;

public class AdminModule {

    public static void load() {
        Bukkit.getPluginCommand("grechareas").setExecutor(new GrechAreasCommand());
    }

}
