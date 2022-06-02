package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandGamemode extends PlayerExclusiveCommand {
    public void run(Player sender, Command command, String label, String[] args) {
        Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);

        if (player != null) {
            String msg = ChatColor.AQUA + "Set gamemode for " + playerNameColor + player.getDisplayName() + ChatColor.AQUA + " to " + ChatColor.GOLD;

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
                default -> {}
            }
        }
    }
}
