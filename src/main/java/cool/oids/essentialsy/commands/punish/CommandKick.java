package cool.oids.essentialsy.commands.punish;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandKick extends EssentialsCommand {
  @Override
  public void run(CommandSender sender, Command command, String label, String[] args) {
    Player player = Utils.extractPlayerArgWithWarnings(sender, args);
    if (player != null) {
      String playerName = player.getName();
      String reason;
      if (args.length > 1) reason = Utils.getMessage(args, 1);
      else reason = "none";

      StringBuilder broadcastMessage = new StringBuilder();
      broadcastMessage.append(
          playerNameColor
              + ((Player) sender).getDisplayName()
              + ChatColor.BLUE
              + " kicked "
              + ChatColor.GRAY
              + playerName);

      if (!reason.equals("none")) {
        broadcastMessage.append(
            ChatColor.BLUE
                + " for "
                + ChatColor.LIGHT_PURPLE
                + "\""
                + Utils.getMessage(args, 1)
                + "\"");
      }

      StringBuilder playerKickMessage = new StringBuilder();
      playerKickMessage.append(
          ChatColor.BLUE
              + "Kicked by "
              + playerNameColor
              + ((Player) sender).getDisplayName()
              + ChatColor.BLUE);

      if (!reason.equals("none")) {
        playerKickMessage.append(" for " + ChatColor.LIGHT_PURPLE + "\"" + reason + "\"");
      }

      player.kickPlayer(playerKickMessage.toString());
      Bukkit.broadcastMessage(broadcastMessage.toString());
    }
  }

  @Override
  public ArrayList<String> onTabComplete(
      @NotNull CommandSender sender,
      @NotNull Command command,
      @NotNull String label,
      @NotNull String[] args) {
    if (args.length == 1) {
      return Utils.getOnlinePlayerNames();
    }

    return null;
  }
}
