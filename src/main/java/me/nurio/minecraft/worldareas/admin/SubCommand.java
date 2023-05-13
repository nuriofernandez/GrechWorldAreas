package me.nurio.minecraft.worldareas.admin;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface SubCommand {
    boolean execute(Player player, @NotNull String[] args);
}
