package me.nurio.minecraft.grechportals;

import lombok.Getter;
import me.nurio.minecraft.grechportals.listeners.PlayerMovementListener;
import me.nurio.minecraft.grechportals.listeners.PlayerPortalJoinListener;
import me.nurio.minecraft.grechportals.portals.GPortal;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class GrechPortals extends JavaPlugin {

    @Getter private static List<GPortal> portals = new ArrayList<>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new PlayerMovementListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPortalJoinListener(), this);
    }

    @Override
    public void onDisable() {

    }

}