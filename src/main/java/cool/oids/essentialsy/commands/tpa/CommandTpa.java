package cool.oids.essentialsy.commands.tpa;

import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getPlayerExact;

public class CommandTpa implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgWithWarnings(sender, args);
            if (player != null) {
                if (ActiveTpas.getActiveSenders().contains(sender) && ActiveTpas.getActiveRecipients().contains(player)) {
                    sender.sendMessage(ChatColor.RED + "You have already sent a tpa request to " + ChatColor.GOLD + player.getDisplayName());
                    return true;
                }

                TpaHandler handler = new TpaHandler(player, sender);
                handler.count();
                sender.sendMessage(ChatColor.AQUA + "Tpa request sent to " + ChatColor.YELLOW + player.getDisplayName());
                player.sendMessage(ChatColor.YELLOW + sender.getName() + ChatColor.AQUA + " has sent you a tpa request." +
                        ChatColor.AQUA + " type " + ChatColor.GOLD + "/tpaccept" + ChatColor.AQUA + " to accept");
                return true;
            }
        }

        return false;
    }
}
