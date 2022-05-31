package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandS implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgWithWarnings(sender, args);
            if (player != null) {
                player.teleport(((Player) sender).getLocation());
                sender.sendMessage(ChatColor.AQUA + "Teleported " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.AQUA + " to you");
                player.sendMessage(ChatColor.YELLOW + sender.getName()+ ChatColor.AQUA + " teleported you to them");
                return true;
            }
        }

        return false;
    }
}
