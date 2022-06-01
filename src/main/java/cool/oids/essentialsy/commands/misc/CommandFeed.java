package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed extends EssentialsCommand {
    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
        if (player != null) {
            player.setFoodLevel(20);
            sender.sendMessage(ChatColor.AQUA + "Restored player " + playerNameColor + player.getDisplayName() + ChatColor.AQUA + " hunger");
        }
    }
}
