package cool.oids.essentialsy.commands.misc;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayerExact;

public class CommandFly implements CommandExecutor {
    @Override
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
                }
                else {
                    sender.sendMessage(ChatColor.RED + "Player does not exist");
                    return true;
                }
            }
            player.setAllowFlight(!player.getAllowFlight());
            sender.sendMessage(player.getAllowFlight() ? ChatColor.AQUA + "Fly " + ChatColor.GOLD + "Enabled" + ChatColor.AQUA + " for " + ChatColor.YELLOW + player.getDisplayName() :
                ChatColor.AQUA + "Fly " + ChatColor.GOLD + "Disabled" + ChatColor.AQUA + " for " + ChatColor.YELLOW + player.getDisplayName());
            return true;
        }
        return false;
    }
}
