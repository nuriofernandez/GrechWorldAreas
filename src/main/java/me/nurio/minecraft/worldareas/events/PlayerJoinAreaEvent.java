package me.nurio.minecraft.worldareas.events;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlayerJoinAreaEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;

    private final Location location;

    private final WorldArea worldArea;

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

}