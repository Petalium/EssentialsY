package cool.oids.essentialsy.commands.utilities;

import com.google.common.collect.ImmutableList;
import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import cool.oids.essentialsy.events.EssentialsPlayersInventoryEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;

import static org.bukkit.Bukkit.getServer;

public class CommandPlayers extends PlayerExclusiveCommand {

	private static final ItemStack next = new ItemStack(Material.SPECTRAL_ARROW);
	private static final ItemStack previous = new ItemStack(Material.SPECTRAL_ARROW);
	private static final ItemStack nextBlock = new ItemStack(Material.BARRIER);
	private static final ItemStack textList = new ItemStack(Material.ENCHANTED_BOOK);
	public static ItemStack pageNum = new ItemStack(Material.PAPER);
	public static ImmutableList<? extends Player> playerList = null;

	public static final String[] lore = {
			ChatColor.GRAY + "Left click to teleport",
			ChatColor.GRAY + "Right click to view stats " + ChatColor.RED + "(W.I.P)"
	};

	public CommandPlayers(EssentialsPlayersInventoryEvent event, Plugin plugin) {
		getServer().getPluginManager().registerEvents(event, plugin);

		ItemMeta meta = next.getItemMeta();
		assert meta != null;
		meta.setDisplayName("" + ChatColor.GREEN + ChatColor.BOLD + "Next");
		next.setItemMeta(meta);

		meta = previous.getItemMeta();
		assert meta != null;
		meta.setDisplayName("" + ChatColor.RED + ChatColor.BOLD + "Previous");
		previous.setItemMeta(meta);

		meta = nextBlock.getItemMeta();
		assert meta != null;
		meta.setDisplayName("" + ChatColor.DARK_RED + ChatColor.BOLD + "No further pages");
		nextBlock.setItemMeta(meta);

		meta = textList.getItemMeta();
		assert meta != null;
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Get player list");
		textList.setItemMeta(meta);
	}

	public static void newPage(int page, Player sender) {
		playerList = Utils.getOnlinePlayers();

		Inventory guiList = Bukkit.createInventory(sender, 54, "Players online");
		ItemMeta meta;
		ArrayList<ItemStack> allItems = new ArrayList<>();

		for (Player onlinePlayer : playerList) {
			allItems.add(getPlayerSkull(onlinePlayer, lore));
		}

		int upperBound = page * 45;
		int lowerBound = upperBound - 45;
		for (int i = lowerBound; i < allItems.size(); i++) {
			try {
				guiList.setItem(i + 9, allItems.get(i));
			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}

		if ((playerList.size() / (page * 45) > 0)) {
			guiList.setItem(8, next);
		} else {
			guiList.setItem(8, nextBlock);
		}

		if (page > 1) {
			guiList.setItem(0, previous);
		} else {
			guiList.setItem(0, textList);
		}

		meta = pageNum.getItemMeta();
		assert meta != null;
		meta.setDisplayName(ChatColor.GOLD + "Page " + page);
		pageNum.setItemMeta(meta);
		guiList.setItem(4, pageNum);

		sender.openInventory(guiList);
	}

	public static void playerStats(Player sender, Player player) {
		Inventory plrStats = Bukkit.createInventory(player, 27, ChatColor.RED + "W.I.P");
		plrStats.setItem(0, getPlayerSkull(player, new String[]{ChatColor.GRAY + "UUID: " + ChatColor.GOLD + player.getUniqueId()}));

		sender.closeInventory();
		sender.openInventory(plrStats);
	}

	public static ItemStack getPlayerSkull(Player curPlayer, String[] lore) {
		ItemStack plrHead = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta meta = plrHead.getItemMeta();

		assert meta != null;
		meta.setDisplayName(ChatColor.AQUA + "Player " + playerNameColor + curPlayer.getDisplayName());
		meta.setLore(Arrays.asList(lore));
		plrHead.setItemMeta(meta);

		SkullMeta skullMeta = (SkullMeta) plrHead.getItemMeta();
		skullMeta.setOwningPlayer(curPlayer);
		plrHead.setItemMeta(skullMeta);

		return plrHead;
	}

	public void run(Player sender, Command command, String label, String[] args) {
		newPage(1, sender);
	}

}