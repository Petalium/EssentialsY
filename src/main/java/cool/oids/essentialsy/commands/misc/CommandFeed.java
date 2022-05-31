package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
        if (player != null) {
            player.setFoodLevel(20);
            sender.sendMessage(ChatColor.AQUA + "Restored player " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.AQUA + " hunger");
            return true;
        }

        return false;
    }
}
