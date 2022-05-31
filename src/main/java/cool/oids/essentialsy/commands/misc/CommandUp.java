package cool.oids.essentialsy.commands.misc;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Objects;

public class CommandUp implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            int posX = player.getLocation().getBlockX();
            int posY = player.getLocation().getBlockY();
            int posZ = player.getLocation().getBlockZ();
            float yaw = player.getLocation().getYaw();
            float pitch = player.getLocation().getPitch();
            World world = player.getWorld();
            int numBlocks;

            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("max")) {
                    numBlocks = (320 - posY);
                } else {
                    try {
                        numBlocks = Integer.parseInt(args[0].trim());
                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.RED + "Argument is not an integer");
                        return false;
                    }
                }
            } else {
                numBlocks = 1;
            }
            if (numBlocks < 0) {
                sender.sendMessage(ChatColor.RED + "Argument must be a positive integer" + ChatColor.GOLD + " (" + numBlocks + ")");
                return true;
            }

            if (posY + numBlocks <= 320) {
                player.teleport(new Location(world, posX, (posY + numBlocks), posZ, yaw, pitch));
                world.getBlockAt(posX, posY - 1, posZ).setType(Material.STONE);

                sender.sendMessage(ChatColor.AQUA + "Moved up " + numBlocks + " blocks" +
                        ChatColor.GOLD + " (" + posX + ", " + (posY + numBlocks) + ", " + posZ + ")");
            } else {
                sender.sendMessage(ChatColor.RED + "Position out of bounds " + ChatColor.GOLD + "(" + (posY + numBlocks) + ")");
            }
            return true;
        }
        return false;
    }
}