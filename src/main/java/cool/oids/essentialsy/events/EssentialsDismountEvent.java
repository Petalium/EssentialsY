package cool.oids.essentialsy.events;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class EssentialsDismountEvent implements Listener {

	@EventHandler
	public void onDismount(EntityDismountEvent e) {
		Entity entity = e.getDismounted();
		if (entity.getType().equals(EntityType.BAT)) {
			Damageable bat = (Damageable) entity;
			bat.setHealth(0);
		}
	}

}
