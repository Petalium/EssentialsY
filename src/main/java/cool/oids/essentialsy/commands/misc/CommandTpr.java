package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandTpr extends PlayerExclusiveCommand {

    public void run (Player sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            int rng;
            try {
                rng = Integer.parseInt(args[0]);
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "Argument was not an integer");
                return;
            }

            if (rng <= 500 && rng >= 10) {
                int rndX = Utils.randomNum(10, rng);
                int rndY = Utils.randomNum(10, rng);
                Location loc = sender.getLocation();
                World world = sender.getWorld();
                Location newLoc = new Location(sender.getWorld(), loc.getBlockX() + rndX , 0, loc.getBlockX() + rndY);
                newLoc.setY(world.getHighestBlockYAt(newLoc));

                sender.teleport(newLoc);
                sender.sendMessage(
                    ChatColor.AQUA
                        + "Randomly teleport to " + ChatColor.GOLD + " (" + newLoc.getBlockY() + ", " + newLoc.getBlockY() + ", " + newLoc.getBlockZ() + ") "
                        + ChatColor.AQUA + "in a " + ChatColor.GOLD + rng + "x" + rng + ChatColor.AQUA + " area");

            } else {
                sender.sendMessage(ChatColor.RED + "Range out of bounds " + ChatColor.GOLD + "(10-500)"); }
        } else {
            sender.sendMessage(ChatColor.RED + "Range not specified");
        }
    }
}
