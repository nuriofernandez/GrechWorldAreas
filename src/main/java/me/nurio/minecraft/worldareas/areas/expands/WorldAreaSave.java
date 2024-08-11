package me.nurio.minecraft.worldareas.areas.expands;

import me.nurio.minecraft.worldareas.GrechAreas;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import me.nurio.minecraft.worldareas.configuration.ConfigSaver;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface WorldAreaSave {

    UUID getUuid();

    default void save() {
        WorldArea worldArea = GrechAreas.getWorldAreaFactory().fromUuid(getUuid());
        if (worldArea == null) {
            return;
        }

        ConfigSaver.save(worldArea);
    }

}