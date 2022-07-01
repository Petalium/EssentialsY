package cool.oids.essentialsy.events;

import cool.oids.essentialsy.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

import static cool.oids.essentialsy.commands.fun.CommandLauncher.launcher;
import static cool.oids.essentialsy.commands.utilities.CommandPowertool.powerToolName;


public class EssentialsPlayerEvent implements Listener {

	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		String launchType = "normal";

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			launchType = "normal";
		}
		if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
			launchType = "inverse";
		}

		if (e.getItem() != null) {
			if (Objects.equals(e.getItem().getItemMeta(), launcher.getItemMeta())) {
				switch (launchType) {
					case "normal" -> Utils.launch(player, 1, 10);
					case "inverse" -> Utils.launch(player, -1, 10);
				}
				player.getWorld().createExplosion(player.getLocation(), 0);
			}
		}
	}

	@EventHandler
	public void onPowertool(PlayerInteractEvent e) {
		Player player = e.getPlayer();

		if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		if (e.getItem() == null) {
			return;
		}

		ItemMeta itemMeta = e.getItem().getItemMeta();
		if (itemMeta != null && itemMeta.getDisplayName().equals(powerToolName) && itemMeta.hasLore()) {
			player.performCommand(itemMeta.getLore().get(0));
		}

	}

}
