package cool.oids.essentialsy.commands.fun;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
					int timer = 1000; // time (SECONDS) till TPA expires

					public void run() {
						timer--;
						if (timer < 0) {
							Location loc = entity.getLocation();
							Damageable cat = (Damageable) entity;
							world.spawnParticle(Particle.EXPLOSION_HUGE, loc, 1);
							world.playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
							cat.setHealth(0);
							scheduler.shutdown();
						}
					}
				};
		scheduler.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.MILLISECONDS);
	}

}
