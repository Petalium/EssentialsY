package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMsg extends EssentialsCommand {
    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgWithWarnings(sender, args);
            if (player != null) {
                if (args.length > 1) {
                    sender.sendMessage
                            (ChatColor.GRAY + "[" + ChatColor.AQUA + "You" + ChatColor.DARK_AQUA + " > " + ChatColor.AQUA + player.getDisplayName() +
                                    ChatColor.GRAY + "]: " + ChatColor.LIGHT_PURPLE + Utils.getMessage(args, 1));
                    player.sendMessage
                            (ChatColor.GRAY + "[" + ChatColor.AQUA + player.getDisplayName() + ChatColor.DARK_AQUA + " > " + ChatColor.AQUA + "You" +
                                    ChatColor.GRAY + "]: " + ChatColor.LIGHT_PURPLE + Utils.getMessage(args, 1));
                } else {
                    sender.sendMessage(ChatColor.RED + "No message inputted");
                }
            }
        }
    }
}
