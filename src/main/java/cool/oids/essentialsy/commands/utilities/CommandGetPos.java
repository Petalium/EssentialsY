package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGetPos extends EssentialsCommand {

	@Override
	public void run(CommandSender sender, Command command, String label, String[] args) {
		Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
		if (player == null) {
			return;
		}

		Location loc = player.getLocation();
		String pos = loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ();

		sender.sendMessage(playerNameColor + player.getName() + "'s " + ChatColor.AQUA + "position: " + ChatColor.GOLD + pos);
	}

}
