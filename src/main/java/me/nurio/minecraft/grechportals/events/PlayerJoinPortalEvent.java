package me.nurio.minecraft.grechportals.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.nurio.minecraft.grechportals.portals.GPortal;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PlayerJoinPortalEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;

    private final Location location;

    private final GPortal portal;

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

}