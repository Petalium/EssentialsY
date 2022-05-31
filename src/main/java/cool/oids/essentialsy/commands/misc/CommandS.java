package cool.oids.essentialsy.commands.misc;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getPlayerExact;

public class CommandS implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length > 0) {
                String trimmed = args[0].trim();
                if (trimmed.length() > 2) {
                    player = getPlayerExact(trimmed);

                    if (player == null) {
                        sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + trimmed + ChatColor.RED + " is not online");
                        return true;
                    }

                    player.teleport(((Player) sender).getLocation());
                    sender.sendMessage(ChatColor.AQUA + "Teleported " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.AQUA + " to you");
                    player.sendMessage(ChatColor.YELLOW + sender.getName()+ ChatColor.AQUA + " teleported you to them");
                    return true;

                } else {
                    sender.sendMessage(ChatColor.RED + "Player does not exist");
                    return true;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "No user inputted");
                return false;
            }
        }
        return false;
    }
}
