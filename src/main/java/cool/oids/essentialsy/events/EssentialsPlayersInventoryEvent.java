package cool.oids.essentialsy.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

import static cool.oids.essentialsy.commands.EssentialsCommand.playerNameColor;
import static cool.oids.essentialsy.commands.utilities.CommandPlayers.*;

public class EssentialsPlayersInventoryEvent implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getCurrentItem() != null) {
			Player sender = (Player) e.getWhoClicked();
			String pageNumName = Objects.requireNonNull(pageNum.getItemMeta()).getDisplayName();
			int curPage = Integer.parseInt(pageNumName.substring(6).trim());

			switch (e.getRawSlot()) {
				case 0 -> {
					if (Objects.requireNonNull(e.getView().getItem(0)).getType().equals(Material.ENCHANTED_BOOK)) {
						StringBuilder list = new StringBuilder();
						for (Player player : playerList) {
							list.append(ChatColor.YELLOW).append(player.getDisplayName()).append(", ");
						}
						sender.sendMessage(ChatColor.AQUA + "Online players: " + ChatColor.GOLD + "(" + playerList.size() + ")\n" + list.substring(0, list.length() - 2));
						sender.closeInventory();
					} else {
						sender.playSound(sender, Sound.UI_BUTTON_CLICK, 1, 1);
						newPage(curPage - 1, sender);
					}
				}
				case 4 -> {
				} //Add a page search feature
				case 8 -> {
					if (Objects.requireNonNull(e.getView().getItem(8)).getType().equals(Material.BARRIER)) {
						sender.playSound(sender, Sound.ENTITY_VILLAGER_NO, 1, 1);
					} else {
						sender.playSound(sender, Sound.UI_BUTTON_CLICK, 1, 1);
						newPage(curPage + 1, sender);
					}
				}
				default -> {
					Player player = playerList.get(e.getRawSlot() - 9);
					if (e.getClick() == ClickType.LEFT) {
						sender.sendMessage(ChatColor.AQUA + "Teleporting to " + playerNameColor + player.getDisplayName());
						sender.teleport(player);
						sender.closeInventory();
					} else if (e.getClick() == ClickType.RIGHT) {
						playerStats(sender, player);
					}
				}
			}
			e.setCancelled(true);
		}
	}

}
