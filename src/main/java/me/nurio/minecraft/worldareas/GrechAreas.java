package me.nurio.minecraft.worldareas;

import lombok.Getter;
import me.nurio.minecraft.worldareas.configuration.ConfigLoader;
import me.nurio.minecraft.worldareas.listeners.PlayerMovementListener;
import me.nurio.minecraft.worldareas.areas.WorldAreaFactory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class GrechAreas extends JavaPlugin {

    @Getter private static WorldAreaFactory worldAreaFactory;
    @Getter private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Register area factory.
        worldAreaFactory = new WorldAreaFactory();

        // Load config
        ConfigLoader.loadAll();

        // Register events
        Bukkit.getPluginManager().registerEvents(new PlayerMovementListener(), this);
    }

}