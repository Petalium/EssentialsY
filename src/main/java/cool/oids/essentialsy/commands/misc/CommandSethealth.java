package cool.oids.essentialsy.commands.misc;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayerExact;

public class CommandSethealth implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            double amnt = 0;
            if (args.length > 0) {
                String trimmed = args[0].trim();
                    try {
                        amnt = Double.parseDouble(trimmed);
                    } catch (Exception e) {
                        sender.sendMessage(ChatColor.RED + "Argument was not a double");
                        return false;
                    }

                    if (args.length > 1) {
                        if (args[1].trim().length() > 2) {
                            player = getPlayerExact(args[1].trim());

                            if (player == null) {
                                sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + trimmed + ChatColor.RED + " is not online");
                                return true;
                            }
                    } else {
                        sender.sendMessage(ChatColor.RED + "Player does not exist");
                        return true;
                    }
                }
            }

            if (amnt > 20 || amnt < 0) {
                sender.sendMessage(ChatColor.RED + "Health range: " + ChatColor.GOLD + "(0-20)");
                return true;
            }
            player.setHealth(amnt);
            sender.sendMessage(ChatColor.AQUA + "Set player " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.AQUA + " health to " + ChatColor.GOLD + amnt );
            return true;
        }
        return false;
    }
}
