package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDown extends EssentialsCommand {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            Location loc = player.getLocation();
            int posX = loc.getBlockX();
            int posZ = loc.getBlockZ();
            float yaw = loc.getYaw();
            float pitch = loc.getPitch();

            World world = player.getWorld();
            int newY = Utils.getNearestHole(loc, world);
            if (newY > -65) {
                player.teleport(new Location(world, loc.getX(), newY, loc.getZ(), yaw, pitch));
                sender.sendMessage(ChatColor.AQUA + "Moved down into nearest hole" +
                        ChatColor.GOLD + " (" + posX + ", " + newY + ", " + posZ + ")");
            } else {
                sender.sendMessage(ChatColor.RED + "No hole found below");
            }

            return true;
        }
        return false;
    }
}