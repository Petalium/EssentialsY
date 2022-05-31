package cool.oids.essentialsy.commands.gamemodes;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayerExact;

public class CommandGma implements CommandExecutor {
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
                }
                else {
                    sender.sendMessage(ChatColor.RED + "Player does not exist");
                    return true;
                }
            }
            player.setGameMode(GameMode.ADVENTURE);
            sender.sendMessage(ChatColor.AQUA + "set gamemode for " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.AQUA + " to " + ChatColor.GOLD + "Adventure");
            return true;
        }
        return false;
    }
}
