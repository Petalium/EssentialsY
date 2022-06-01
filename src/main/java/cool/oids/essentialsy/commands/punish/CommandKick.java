package cool.oids.essentialsy.commands.punish;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKick extends EssentialsCommand {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgWithWarnings(sender, args);
            if (player != null) {
                String playerName = player.getName();
                String reason;
                if (args.length > 1)
                    reason = Utils.getMessage(args, 1);
                else
                    reason = "none";

                StringBuilder broadcastMessage = new StringBuilder();
                broadcastMessage.append(playerNameColor + ((Player) sender).getDisplayName() + ChatColor.BLUE + " kicked " +
                        ChatColor.GRAY + playerName);

                if (!reason.equals("none")) {
                    broadcastMessage.append(ChatColor.BLUE + " for " + ChatColor.LIGHT_PURPLE + "\"" + Utils.getMessage(args,1) + "\"");
                }

                StringBuilder playerKickMessage = new StringBuilder();
                playerKickMessage.append(ChatColor.BLUE + "Kicked by " + playerNameColor + ((Player) sender).getDisplayName() + ChatColor.BLUE);

                if (!reason.equals("none")) {
                    playerKickMessage.append(" for " + ChatColor.LIGHT_PURPLE + "\"" + reason + "\"");
                }

                player.kickPlayer(playerKickMessage.toString());
                Bukkit.broadcastMessage(broadcastMessage.toString());

                return true;
            }
        }

        return false;
    }
}
