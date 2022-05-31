package cool.oids.essentialsy.commands.misc;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayerExact;

public class CommandHeal implements CommandExecutor {
    @Override
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
                } else {
                    sender.sendMessage(ChatColor.RED + "Player does not exist");
                    return true;
                }
            }
            player.setHealth(20.0);
            sender.sendMessage(ChatColor.AQUA + "Restored player " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.AQUA + " health");
            return true;
        }
        return false;
    }
}
