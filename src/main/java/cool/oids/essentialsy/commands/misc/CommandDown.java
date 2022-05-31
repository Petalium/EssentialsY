package cool.oids.essentialsy.commands.misc;
import cool.oids.essentialsy.Utils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Objects;

public class CommandDown implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            World world = player.getWorld();
            int posX = player.getLocation().getBlockX();
            int posZ = player.getLocation().getBlockZ();
            float yaw = player.getLocation().getYaw();
            float pitch = player.getLocation().getPitch();
            int newY = Utils.getNearestHole(player.getLocation(), world);

            if (newY > -65) {
                player.teleport(new Location(world, posX, newY, posZ, yaw, pitch));
                sender.sendMessage(ChatColor.AQUA + "Moved down into nearest hole" +
                        ChatColor.GOLD + " (" + posX + ", " + newY + ", " + posZ + ")");
            }
            else {
                sender.sendMessage(ChatColor.RED + "No hole found below");
            }
            return true;
        }
        return false;
    }
}