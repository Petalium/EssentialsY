package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayerExact;

public class CommandHeal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
        if (player != null) {
            player.setHealth(20.0);
            sender.sendMessage(ChatColor.AQUA + "Restored player " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.AQUA + " health");
            return true;
        }

        return false;
    }
}