package cool.oids.essentialsy.commands.fun;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class CommandSkull extends PlayerExclusiveCommand {

	private final ItemStack skull;

	public CommandSkull() {
		skull = new ItemStack(Material.PLAYER_HEAD);
	}

	public void run(Player sender, Command command, String label, String[] args) {
		String name = sender.getDisplayName();

		if (args.length > 0) {
			String trimmed = args[0].trim();
			if (trimmed.length() > 2) {
				name = trimmed;
			} else {
				sender.sendMessage(ChatColor.RED + "Player does not exist");
				return;
			}
		}

		SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
		assert skullMeta != null;
		skullMeta.setOwner(name); //fine to use in this command
		skullMeta.setDisplayName(name + "'s " + "skull");
		skull.setItemMeta(skullMeta);

		sender.getInventory().addItem(skull);
		sender.sendMessage(ChatColor.AQUA + "Given player " + playerNameColor + name + "'s " + ChatColor.AQUA + "skull");
	}

}