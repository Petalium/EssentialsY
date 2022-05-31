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

public class CommandKick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length > 0) {
                String trimmed = args[0].trim();
                if (trimmed.length() > 2) {
                    player = getPlayerExact(trimmed);

                    if (player == null) {
                        sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + args[0] + ChatColor.RED + " is not online");
                        return true;
                    }

                    if (args.length > 1) {
                        player.kickPlayer
                            (ChatColor.BLUE + "Kicked by " + ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.BLUE +
                                " for " + ChatColor.LIGHT_PURPLE + "\"" + Utils.getMessage(args,1) + "\"");
                        Bukkit.broadcastMessage
                                (ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.BLUE + " kicked " +
                                    ChatColor.GRAY + trimmed + ChatColor.BLUE + " for " + ChatColor.LIGHT_PURPLE + "\"" + Utils.getMessage(args,1) + "\"");
                    } else {
                        player.kickPlayer
                            (ChatColor.BLUE + "Kicked by " + ChatColor.YELLOW + ((Player) sender).getDisplayName());
                        Bukkit.broadcastMessage
                                (ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.BLUE + " kicked " + ChatColor.GRAY + trimmed);
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Player does not exist");
                }
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "No user inputted");
                return false;
            }
        }
        return false;
    }
}
