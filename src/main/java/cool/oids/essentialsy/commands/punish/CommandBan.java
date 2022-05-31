package cool.oids.essentialsy.commands.punish;
import cool.oids.essentialsy.Utils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            String playerName = Utils.extractPlayerNameArg(sender, args);
            if (playerName != null) {
                BanList banList = Bukkit.getBanList(BanList.Type.NAME);

                if (banList.isBanned(playerName)) {
                    sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + playerName + ChatColor.RED + " is already banned");
                    return true;
                }

                String reason;
                if (args.length > 1)
                    reason = Utils.getMessage(args, 1);
                else
                    reason = "none";

                player = Bukkit.getPlayerExact(playerName);
                banList.addBan(playerName, reason, null, ((Player) sender).getDisplayName());

                StringBuilder broadcastMessage = new StringBuilder();
                broadcastMessage.append(ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.RED + " banned " + ChatColor.GRAY + playerName);

                if (!reason.equals("none")) {
                    broadcastMessage.append(ChatColor.RED + " for " +
                            ChatColor.LIGHT_PURPLE + "\"" + reason + "\"");
                }

                if (player != null) {
                    StringBuilder playerKickMessage = new StringBuilder();
                    playerKickMessage.append(ChatColor.RED + "Banned by " + ChatColor.YELLOW + ((Player) sender).getDisplayName());

                    if (!reason.equals("none")) {
                        playerKickMessage.append(ChatColor.RED + " for " + ChatColor.LIGHT_PURPLE + "\"" + reason + "\"");
                    }

                    player.kickPlayer(playerKickMessage.toString());
                }

                Bukkit.broadcastMessage(broadcastMessage.toString());

                return true;
            }
        }

        return false;
    }
}
