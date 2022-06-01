package cool.oids.essentialsy.commands.gamemodes;

import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.TreeType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGamemode implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);

        if (player != null) {
            String msg = ChatColor.AQUA + "set gamemode for " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.AQUA + " to " + ChatColor.GOLD;

            switch (label) {
                case "gma" -> {
                    player.setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage(msg + "Adventure");
                }
                case "gmc" -> {
                    player.setGameMode(GameMode.CREATIVE);
                    sender.sendMessage(msg + "Creative");
                }
                case "gms" -> {
                    player.setGameMode(GameMode.SURVIVAL);
                    sender.sendMessage(msg + "Survival");
                }
                case "gmsp" -> {
                    player.setGameMode(GameMode.SPECTATOR);
                    sender.sendMessage(msg + "Spectator");
                }
                default -> {
                    return false;
                }
            }
        }

        return true;
    }
}