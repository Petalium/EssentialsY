package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandUp extends PlayerExclusiveCommand {

	@Override
	public void run(Player player, Command command, String label, String[] args) {
		Location loc = player.getLocation();
		int posX = loc.getBlockX();
		int posY = loc.getBlockY();
		int posZ = loc.getBlockZ();
		float yaw = loc.getYaw();
		float pitch = loc.getPitch();
		World world = player.getWorld();

		int numBlocks = 1;
		if (args.length > 0) {
			if (args[0].equalsIgnoreCase("max")) {
				numBlocks = (320 - posY);
			} else {
				try {
					numBlocks = Integer.parseUnsignedInt(args[0].trim());
				} catch (Exception e) {
					player.sendMessage(ChatColor.RED + "Argument is not a positive integer");
					return;
				}
			}
		}

		if (posY + numBlocks <= 320) {
			player.teleport(new Location(world, loc.getX(), (posY + numBlocks), loc.getZ(), yaw, pitch));
			world.getBlockAt(posX, posY + (numBlocks - 1), posZ).setType(Material.STONE);

			player.sendMessage(
					ChatColor.AQUA
							+ "Moved up "
							+ numBlocks
							+ " blocks"
							+ ChatColor.GOLD
							+ " ("
							+ posX
							+ ", "
							+ (posY + numBlocks)
							+ ", "
							+ posZ
							+ ")");
		} else {
			player.sendMessage(
					ChatColor.RED
							+ "Position out of bounds "
							+ ChatColor.GOLD
							+ "("
							+ (posZ + numBlocks)
							+ ")");
		}
	}

}
