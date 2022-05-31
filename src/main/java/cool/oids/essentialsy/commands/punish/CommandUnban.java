package cool.oids.essentialsy.commands.punish;
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

            if (sender instanceof Player player) {
                if (args.length > 0) {
                    String trimmed = args[0];
                    if (trimmed.length() > 2) {
                        BanList banList = Bukkit.getBanList(BanList.Type.NAME);

                        if (banList.isBanned(trimmed)) {
                            banList.pardon(trimmed);
                            sender.sendMessage(ChatColor.AQUA + "Unbanned " + ChatColor.YELLOW + trimmed);
                        }
                        else {
                            sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + trimmed + ChatColor.RED + " is not banned");
                        }
                    }
                    else {
                        sender.sendMessage(ChatColor.RED + "Player does not exist");
                    }
                    return true;
                }
                else {
                    sender.sendMessage(ChatColor.RED + "No user inputted");
                    return false;
                }
            }
        sender.sendMessage(ChatColor.RED + "An error was encountered");
        return false;
    }
}
