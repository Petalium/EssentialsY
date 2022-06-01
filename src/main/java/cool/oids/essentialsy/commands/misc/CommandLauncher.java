package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static cool.oids.essentialsy.items.ItemLauncher.launcher;

public class CommandLauncher extends EssentialsCommand {
    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
            if (player != null) {
                player.getInventory().addItem(launcher);
                sender.sendMessage(ChatColor.AQUA + "Gave player " + playerNameColor + player.getDisplayName() + ChatColor.GOLD + " launcher");
            }
        }
    }
}
