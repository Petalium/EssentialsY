package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayerExact;

public class CommandMsg implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgWithWarnings(sender, args);
            if (player != null) {
                if (args.length > 1) {
                    sender.sendMessage
                            (ChatColor.GRAY + "[" + ChatColor.AQUA + "You" + ChatColor.DARK_AQUA + " > " + ChatColor.AQUA + player.getDisplayName() +
                                    ChatColor.GRAY + "]: " + ChatColor.LIGHT_PURPLE + Utils.getMessage(args,1));
                    player.sendMessage
                            (ChatColor.GRAY + "[" + ChatColor.AQUA + player.getDisplayName() + ChatColor.DARK_AQUA + " > " + ChatColor.AQUA + "You" +
                                    ChatColor.GRAY + "]: " + ChatColor.LIGHT_PURPLE + Utils.getMessage(args,1));
                    return true;
                } else {
                    sender.sendMessage(ChatColor.RED + "No message inputted");
                    return false;
                }
            }
        }

        return false;
    }
}
