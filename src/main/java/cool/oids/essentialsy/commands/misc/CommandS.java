package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandS extends EssentialsCommand {
    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgWithWarnings(sender, args);
            if (player != null) {
                player.teleport(((Player) sender).getLocation());
                sender.sendMessage(ChatColor.AQUA + "Teleported " + playerNameColor + player.getDisplayName() + ChatColor.AQUA + " to you");
                player.sendMessage(playerNameColor + sender.getName()+ ChatColor.AQUA + " teleported you to them");
            }
        }
    }
}
