package cool.oids.essentialsy.commands.tpa;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getPlayerExact;

public class CommandTpa implements CommandExecutor {
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

                    if (ActiveTpas.getActiveSenders().contains(sender) && ActiveTpas.getActiveRecipients().contains(player)) {
                        sender.sendMessage(ChatColor.RED + "You have already sent a tpa request to " + ChatColor.GOLD + trimmed);
                        return true;
                    }

                    TpaHandler handler = new TpaHandler(player, sender);
                    handler.count();
                    sender.sendMessage(ChatColor.AQUA + "Tpa request sent to " + ChatColor.YELLOW + player.getDisplayName());
                    player.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.AQUA + " has sent you a tpa request." +
                        ChatColor.AQUA + " type " + ChatColor.GOLD + "/tpaccept" + ChatColor.AQUA + " to accept");
                }
                else {
                    sender.sendMessage(ChatColor.RED + "Player does not exist");
                }
                return true;
            }
            else {
                sender.sendMessage(ChatColor.RED + "No player inputted");
                return false;
            }
        }
        return false;
    }
}
