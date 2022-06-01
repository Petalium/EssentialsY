package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class CommandKittyCannon extends EssentialsCommand {
    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
            if (player != null) {
                World world = player.getWorld();
                Entity cat = world.spawnEntity(player.getEyeLocation(), EntityType.CAT);

                Utils.launch(cat, 1,4);
                timer(world, cat);
            }
        }
    }

    public void timer( World world, Entity entity) {
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            int timer = 2; //time (SECONDS) till TPA expires
            public void run() {
                timer--;
                if (timer < 0) {

                    //DOES NOT WORK :(
                    final Location loc = entity.getLocation();
                    world.createExplosion(loc, 0);
                    entity.setGlowing(true);
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }
}
