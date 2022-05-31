package cool.oids.essentialsy.commands.tpa;

import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getPlayerExact;

public class CommandTpdeny implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            boolean hasRequests = ActiveTpas.getActiveRecipients().contains(sender);

            player = Utils.extractPlayerArgWithWarnings(sender, args);
            if (player != null && !hasRequests) {
                sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + player.getDisplayName() + ChatColor.RED + " has not sent a tpa request recently");
                return true;
            }

            if (hasRequests) {
                Player tpaSender = (Player) ActiveTpas.activeSenders.get(ActiveTpas.getActiveRecipients().indexOf(sender));
                ActiveTpas.removeSender(ActiveTpas.removeRecipient((Player) sender));
                tpaSender.teleport(((Player) sender).getLocation());

                sender.sendMessage(ChatColor.AQUA + "Denied " + ChatColor.YELLOW + tpaSender.getName() + ChatColor.AQUA + " tpa request");
                tpaSender.sendMessage(ChatColor.YELLOW + tpaSender.getName() + ChatColor.AQUA + " Denied your tpa request");
                return true;
            }

            sender.sendMessage(ChatColor.RED + "No recent requests found");
            return true;
        }
        return false;
    }
}
