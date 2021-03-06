package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetHunger extends EssentialsCommand {

	@Override
	public void run(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player player) {
			int amnt = 0;
			if (args.length > 0) {
				String trimmed = args[0].trim();
				try {
					amnt = Integer.parseInt(trimmed);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED + "Argument was not an integer");
					return;
				}

				if (args.length > 1) {
					if (args[1].trim().length() > 2) {
						player = Bukkit.getPlayerExact(args[1].trim());

						if (player == null) {
							sender.sendMessage(ChatColor.RED + "Player " + playerNameColor + trimmed + ChatColor.RED + " is not online");
							return;
						}
					} else {
						sender.sendMessage(ChatColor.RED + "Player does not exist");
						return;
					}
				}
			}

			if (amnt > 20 || amnt < 0) {
				sender.sendMessage(ChatColor.RED + "Hunger range: " + ChatColor.GOLD + "(0-20)");
				return;
			}

			player.setFoodLevel(amnt);
			sender.sendMessage(ChatColor.AQUA + "Set player " + playerNameColor + player.getDisplayName() + ChatColor.AQUA + " hunger to " + ChatColor.GOLD + amnt);
		}
	}

}
