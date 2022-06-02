package cool.oids.essentialsy.commands.fun;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandSuicide extends PlayerExclusiveCommand {

    public void run(Player player, Command command, String label, String[] args) {
        if (args.length > 0) {
            player.sendMessage(ChatColor.RED + "No arguments required");
        } else {
            String msg = playerNameColor + player.getDisplayName() + ChatColor.AQUA;
            player.setHealth(0.0);

            switch (Utils.randomNum(1, 4)) {
                case 1 -> msg += " committed suicide";
                case 2 -> msg += " no longer wanted to be in this world";
                case 3 -> msg += " ended it all";
                case 4 -> msg += " ended their suffering";
            }

            Bukkit.broadcastMessage(msg);
        }
    }
}
