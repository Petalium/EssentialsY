package cool.oids.essentialsy.commands.tpa;

import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpaRespond implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            boolean hasRequests = ActiveTpas.getActiveRecipients().contains(sender);

            player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
            if (player != null && !hasRequests && args.length > 0) {
                sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + player.getDisplayName() + ChatColor.RED + " has not sent a tpa request recently");
                return true;
            }

            if (hasRequests && player != null) {
                Player tpaSender = (Player) ActiveTpas.activeSenders.get(ActiveTpas.getActiveRecipients().indexOf(sender)); //gets tpa sender based off recipient index
                ActiveTpas.removeSender(ActiveTpas.removeRecipient((Player) sender)); //removes recipient and sender from lists

                switch(label) {
                    case "tpaccept" -> {
                        tpaSender.teleport(((Player) sender).getLocation());
                        sender.sendMessage(ChatColor.GREEN + "Accepted " + ChatColor.YELLOW + tpaSender.getName() + ChatColor.GREEN + " tpa request");
                        tpaSender.sendMessage(ChatColor.GREEN + tpaSender.getName() + ChatColor.GREEN + " accepted your tpa request");
                    }
                    case "tpdeny" -> {
                        sender.sendMessage(ChatColor.RED + "Denied " + ChatColor.YELLOW + tpaSender.getName() + ChatColor.RED + " tpa request");
                        tpaSender.sendMessage(ChatColor.YELLOW + tpaSender.getName() + ChatColor.RED + " Denied your tpa request");
                    }
                    default -> {
                        return false;
                    }
                }

                return true;
            }

            if (args.length <= 0)
                sender.sendMessage(ChatColor.RED + "No recent requests found");
            return true;
        }

        return false;
    }
}
