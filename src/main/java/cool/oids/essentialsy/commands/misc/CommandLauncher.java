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
        Player receiver;
        if (args.length > 0) {
            receiver = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
        } else if (sender instanceof Player player) {
            receiver = player;
        } else {
            ranFromConsoleError(sender);
            return;
        }

        if (receiver != null) {
            receiver.getInventory().addItem(ItemLauncher.launcher);
            sender.sendMessage(ChatColor.AQUA + "Gave player " + playerNameColor + receiver.getDisplayName() + ChatColor.GOLD + " launcher");
        }
    }

}
