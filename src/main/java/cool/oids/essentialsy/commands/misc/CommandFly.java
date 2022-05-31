package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayerExact;

public class CommandFly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
        if (player != null) {
            player.setAllowFlight(!player.getAllowFlight());
            sender.sendMessage(player.getAllowFlight() ? ChatColor.AQUA + "Fly " + ChatColor.GOLD + "Enabled" + ChatColor.AQUA + " for " + ChatColor.YELLOW + player.getDisplayName() :
                    ChatColor.AQUA + "Fly " + ChatColor.GOLD + "Disabled" + ChatColor.AQUA + " for " + ChatColor.YELLOW + player.getDisplayName());
            return true;
        }

        return false;
    }
}
