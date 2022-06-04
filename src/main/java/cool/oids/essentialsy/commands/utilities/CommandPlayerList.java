package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPlayerList extends EssentialsCommand {
    public void run(CommandSender sender, Command command, String label, String[] args) {
        StringBuilder list = new StringBuilder();
        for (Player player : Utils.getOnlinePlayers()) {
            list.append(ChatColor.YELLOW).append(player.getDisplayName()).append(", ");
        }
        sender.sendMessage(ChatColor.AQUA + "Online players: " + ChatColor.GOLD + "(" + Bukkit.getOnlinePlayers().size() + ")\n" + list.substring(0,list.length() - 2));
    }
}