package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandPlayerList extends PlayerExclusiveCommand {

	private static final ItemStack plrHead = new ItemStack(Material.PLAYER_HEAD);
	private static final ItemStack next = new ItemStack(Material.SPECTRAL_ARROW);
	private static final ItemStack previous = new ItemStack(Material.SPECTRAL_ARROW);
	private static final ItemStack nextBlock = new ItemStack(Material.BARRIER);
	private static final ItemStack previousBlock = new ItemStack(Material.BARRIER);

	public CommandPlayerList() {
		ItemMeta meta = next.getItemMeta();
		assert meta != null;
		meta.setDisplayName("" + ChatColor.GREEN + ChatColor.BOLD + "Next");
		next.setItemMeta(meta);

		meta = previous.getItemMeta();
		assert meta != null;
		meta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Previous");
		previous.setItemMeta(meta);

		meta = previousBlock.getItemMeta();
		assert meta != null;
		meta.setDisplayName("" + ChatColor.DARK_RED + "No previous pages");
		previousBlock.setItemMeta(meta);

		meta = nextBlock.getItemMeta();
		assert meta != null;
		meta.setDisplayName("" + ChatColor.DARK_RED + "No further pages");
		nextBlock.setItemMeta(meta);
	}

	public static void newPage(int page, Player sender) {
		ArrayList<Player> onlinePlayers = Utils.getOnlinePlayers();
		Inventory list = Bukkit.createInventory(sender, 54, "Players online");
		ItemMeta meta;
		SkullMeta skullMeta;
		String[] lore = {
				ChatColor.GRAY + "UUID: " + ChatColor.GOLD,
				ChatColor.GRAY + "Left click to teleport",
				ChatColor.GRAY + "Right click to view stats " + ChatColor.RED + "(N/A)"
		};

		for (int i = 0; i < onlinePlayers.size(); i++) {
			Player curPlayer = onlinePlayers.get(i);
			meta = plrHead.getItemMeta();
			assert meta != null;
			meta.setDisplayName(ChatColor.AQUA + "Player " + playerNameColor + curPlayer.getDisplayName());
			lore[0] += curPlayer.getUniqueId();
			meta.setLore(Arrays.asList(lore));
			plrHead.setItemMeta(meta);

			skullMeta = (SkullMeta) plrHead.getItemMeta();
			skullMeta.setOwningPlayer(curPlayer);
			plrHead.setItemMeta(skullMeta);

			list.setItem(i, plrHead);
		}

		sender.closeInventory();
		sender.openInventory(list);
	}

	public void run(Player sender, Command command, String label, String[] args) {
		newPage(1, sender);
	}

}
