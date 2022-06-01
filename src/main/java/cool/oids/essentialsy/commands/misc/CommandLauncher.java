package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import cool.oids.essentialsy.items.ItemLauncher;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLauncher extends EssentialsCommand {

    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
            if (player != null) {
                player.getInventory().addItem(ItemLauncher.launcher);
                sender.sendMessage(ChatColor.AQUA + "Gave player " + playerNameColor + player.getDisplayName() + ChatColor.GOLD + " launcher");
            }
        }
    }
}
