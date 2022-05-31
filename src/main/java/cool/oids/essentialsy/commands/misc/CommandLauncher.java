package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.items.ItemLauncher;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static cool.oids.essentialsy.items.ItemLauncher.launcher;

public class CommandLauncher implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
            if (player != null) {
                player.getInventory().addItem(launcher);
                sender.sendMessage(ChatColor.AQUA + "Gave player " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.GOLD + " launcher");
            }
        }
        return true;
    }
}
