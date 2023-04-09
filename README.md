# GrechWorldAreas
Spigot Minecraft server plugin that allows other plugins to work with world areas. Detecting player joins/leaves block breaks, etc.

# Area definition

```yml
name: "Redo"
uuid: "63b4809c-b73e-4a26-a106-4e722fe9c454"
area:
  end:
    w: "world"
    x: 1
    y: 100
    z: 1
    yaw: 0
    pitch: 0
  start:
    w: "world"
    x: 3
    y: 100
    z: 3
    yaw: 0
    pitch: 0
```

# Checking areas for location

```java
@EventHandler
public void onBlockClick(PlayerInteractEvent event) {
    if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return;

    Player player = event.getPlayer();
    Location clickedBlock = event.getClickedBlock().getLocation();

    List<WorldArea> areas = worldAreaFactory.fromLocation(clickedBlock);
    String areasNames = areas.stream().map(WorldArea::getName).collect(Collectors.joining(","));

    player.sendMessage(ChatColor.translateAlternateColorCodes(
        '&', "&cYou have clicked at a block inside: &a"+areasNames
    ));
}
```

# Listening to an area movement event

```java
@EventHandler
public void onJoin(PlayerJoinAreaEvent event) {
    Player player = event.getPlayer();
    WorldArea area = event.getWorldArea();

    String message = ChatColor.translateAlternateColorCodes(
        '&', "&aYou joined to &e" + area.getName()
    );
    player.sendTitle("World Areas", message, 1, 20, 1);
}

@EventHandler
public void onLeave(PlayerLeaveAreaEvent event) {
    Player player = event.getPlayer();
    WorldArea area = event.getWorldArea();

    String message = ChatColor.translateAlternateColorCodes(
        '&', "&cYou left to &e" + area.getName()
    );
    player.sendTitle("World Areas", message, 1, 20, 1);
}
```

## Demonstration of results:

<img src="https://github.com/xXNurioXx/GrechWorldAreas/blob/master/documentation/images/area-movement-event.gif" alt="Player joining and leaving from a world area" width="100%"/>
