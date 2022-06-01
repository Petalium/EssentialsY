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

public class CommandAirstrike extends EssentialsCommand {
    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
            if (player != null) {
                World world = player.getWorld();
                Location loc = player.getLocation();
                sender.sendMessage(ChatColor.AQUA + "Sending airstrike to " + playerNameColor + player.getDisplayName());

                for (int i = 0; i < 50; i++) {
                    world.spawn(new Location(world, loc.getBlockX(), world.getHighestBlockYAt(loc) + 64, loc.getBlockZ()), TNTPrimed.class);
                }
            }
        }
    }
}
