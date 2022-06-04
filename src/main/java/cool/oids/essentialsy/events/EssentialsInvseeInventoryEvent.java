package cool.oids.essentialsy.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import static cool.oids.essentialsy.commands.EssentialsCommand.playerNameColor;

public class EssentialsInvseeInventoryEvent implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getCurrentItem() != null) {
			e.setCancelled(true);
			Player sender = (Player) e.getWhoClicked();
			Inventory plrInv = e.getView().getTopInventory();

			if (plrInv.getHolder() instanceof HumanEntity binding) {
				Player player = (Player) binding;

				switch (e.getRawSlot()) {
					case 3 -> {
						Inventory inv = Bukkit.createInventory(player, 9, "Equipped");
						inv.setContents(player.getInventory().getArmorContents());
						inv.setItem(4, player.getInventory().getItemInOffHand());
						sender.closeInventory();
						sender.openInventory(inv);
					}
					case 5 -> {
						sender.closeInventory();
						sender.openInventory(player.getInventory());
					}
					case 8 -> {
						player.getInventory().clear();
						sender.sendMessage(
								ChatColor.AQUA + "Cleared " + playerNameColor + player.getDisplayName()
										+ ChatColor.AQUA + " inventory");
						sender.closeInventory();
					}
					default -> {
					}
				}
			}
		}
	}
}
