package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandKittyCannon extends PlayerExclusiveCommand {
  public void run(Player player, Command command, String label, String[] args) {
    player = Utils.extractPlayerArgOrSenderWithWarnings(player, args);
    if (player != null) {
      World world = player.getWorld();
      Entity cat = world.spawnEntity(player.getEyeLocation(), EntityType.CAT);

      Utils.launch(cat, 1, 4);
      timer(world, cat);
    }
  }

  public void timer(World world, Entity entity) {
    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    final Runnable runnable =
        new Runnable() {
          int timer = 2; // time (SECONDS) till TPA expires

          public void run() {
            timer--;
            if (timer < 0) {

              // DOES NOT WORK :(
              final Location loc = entity.getLocation();
              world.createExplosion(loc, 0);
              entity.setGlowing(true);
              scheduler.shutdown();
            }
          }
        };
    scheduler.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);
  }
}
