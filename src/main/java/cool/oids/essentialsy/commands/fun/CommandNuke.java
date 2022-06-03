package cool.oids.essentialsy.commands.fun;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class CommandNuke extends EssentialsCommand {

	public void run(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player player) {
			player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
			if (player != null) {
				World world = player.getWorld();
				Location loc = player.getLocation();
				sender.sendMessage(ChatColor.AQUA + "Nuking " + playerNameColor + player.getDisplayName());

				for (int row = -10; row <= 10; row += 3) {
					for (int col = -10; col <= 10; col += 3) {
						world.spawn(new Location(world, loc.getBlockX() + row, world.getHighestBlockYAt(loc) + 64, loc.getBlockZ() + col), TNTPrimed.class);
					}
				}
			}
		}
	}

}
