package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBroadcast extends EssentialsCommand {

	public void run(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			if (args.length > 0) {
				Bukkit.broadcastMessage(
						ChatColor.GRAY
								+ "["
								+ ChatColor.AQUA
								+ "Broadcast"
								+ ChatColor.GRAY
								+ "] "
								+ ChatColor.LIGHT_PURPLE
								+ Utils.getMessage(args, 0));
			} else {
				sender.sendMessage(ChatColor.RED + "No message inputted");
			}
		}
	}

}
