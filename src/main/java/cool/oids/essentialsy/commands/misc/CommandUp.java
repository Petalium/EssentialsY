package cool.oids.essentialsy.commands.misc;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
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
                        sender.sendMessage(ChatColor.RED + "Argument is not a positive integer");
                        return false;
                    }
                }
            }

            if (posY + numBlocks <= 320) {
                player.teleport(new Location(world, loc.getX(), (posY + numBlocks), loc.getZ(), yaw, pitch));
                world.getBlockAt(posX, posY + (numBlocks - 1), posZ).setType(Material.STONE);

                sender.sendMessage(ChatColor.AQUA + "Moved up " + numBlocks + " blocks" +
                        ChatColor.GOLD + " (" + posX + ", " + (posY + numBlocks) + ", " + posZ + ")");
            } else {
                sender.sendMessage(ChatColor.RED + "Position out of bounds " + ChatColor.GOLD + "(" + (posZ + numBlocks) + ")");
            }

            return true;
        }
        return false;
    }
}