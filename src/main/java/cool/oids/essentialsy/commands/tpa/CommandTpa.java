package cool.oids.essentialsy.commands.tpa;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpa extends EssentialsCommand {
    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgWithWarnings(sender, args);
            if (player != null) {
                if (ActiveTpas.getActiveSenders().contains(sender) && ActiveTpas.getActiveRecipients().contains(player)) {
                    sender.sendMessage(ChatColor.RED + "You have already sent a tpa request to " + playerNameColor + player.getDisplayName());
                    return;
                }

                TpaHandler handler = new TpaHandler(player, sender);
                handler.count();
                sender.sendMessage(ChatColor.AQUA + "Tpa request sent to " + playerNameColor + player.getDisplayName());
                player.sendMessage(playerNameColor + sender.getName() + ChatColor.AQUA + " has sent you a tpa request." +
                    ChatColor.AQUA + " type " + ChatColor.GOLD + "/tpaccept" + ChatColor.AQUA + " to accept");
            }
        }
    }
}
