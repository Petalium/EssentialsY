package cool.oids.essentialsy.commands.tpa;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getPlayerExact;

public class CommandTpaccept implements CommandExecutor {
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
            if (ActiveTpas.getActiveRecipients().contains(sender)) {
                Player tpaSender = (Player) ActiveTpas.activeSenders.get(ActiveTpas.getActiveRecipients().indexOf(sender));
                ActiveTpas.removeSender(ActiveTpas.removeRecipient((Player) sender));
                tpaSender.teleport(((Player) sender).getLocation());
                sender.sendMessage(ChatColor.AQUA + "Accepted " + ChatColor.YELLOW + tpaSender.getName() + ChatColor.AQUA + " tpa request");
                tpaSender.sendMessage(ChatColor.YELLOW + tpaSender.getName() + ChatColor.AQUA + " accepted your tpa request");
            }
            else if (args.length > 0)
                sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + player.getDisplayName() + ChatColor.RED + " has not sent a tpa request recently");
            else
                sender.sendMessage(ChatColor.RED + "No recent requests found");
            return true;
        }
        return false;
    }
}
