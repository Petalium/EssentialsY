package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.xml.sax.helpers.LocatorImpl;

public class CommandNuke extends EssentialsCommand {
    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
            if (player != null) {
                World world = player.getWorld();
                Location loc = player.getLocation();
                sender.sendMessage(ChatColor.AQUA + "Nuking " + playerNameColor + player.getDisplayName());

                for (int r = -10; r <= 10; r += 3) {
                    for (int c = -10; c <= 10; c += 3) {
                        world.spawn(new Location(world, loc.getBlockX() + r, world.getHighestBlockYAt(loc) + 64, loc.getBlockZ() + c), TNTPrimed.class);
                    }
                }
            }
        }
    }
}
