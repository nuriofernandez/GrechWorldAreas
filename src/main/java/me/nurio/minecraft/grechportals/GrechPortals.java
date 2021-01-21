package me.nurio.minecraft.grechportals;

import lombok.Getter;
import me.nurio.minecraft.grechportals.configuration.ConfigLoader;
import me.nurio.minecraft.grechportals.listeners.PlayerMovementListener;
import me.nurio.minecraft.grechportals.listeners.PlayerPortalJoinListener;
import me.nurio.minecraft.grechportals.portals.PortalFactory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class GrechPortals extends JavaPlugin {

    @Getter private static PortalFactory portalFactory = new PortalFactory();
    @Getter private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Load config
        ConfigLoader.loadAll();

        // Register events
        Bukkit.getPluginManager().registerEvents(new PlayerMovementListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPortalJoinListener(), this);
    }

    @Override
    public void onDisable() {
        portalFactory = new PortalFactory();
    }

}