package cool.oids.essentialsy.commands.punish;
import cool.oids.essentialsy.Utils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayerExact;

public class CommandUnban implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            String playerName = Utils.extractPlayerNameArg(sender, args);
            if (playerName != null) {
                BanList banList = Bukkit.getBanList(BanList.Type.NAME);

                if (banList.isBanned(playerName)) {
                    banList.pardon(playerName);
                    sender.sendMessage(ChatColor.AQUA + "Unbanned " + ChatColor.YELLOW + playerName);
                } else {
                    sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + playerName + ChatColor.RED + " is not banned");
                }
                return true;
            }
            return false;
    }
}
