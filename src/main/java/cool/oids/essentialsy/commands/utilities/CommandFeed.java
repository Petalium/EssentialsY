package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandFeed extends PlayerExclusiveCommand {
  @Override
  public void run(Player sender, Command command, String label, String[] args) {
    Player playerToFeed = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
    if (playerToFeed != null) {
      playerToFeed.setFoodLevel(20);
      sender.sendMessage(
          ChatColor.AQUA
              + "Restored player "
              + playerNameColor
              + playerToFeed.getDisplayName()
              + ChatColor.AQUA
              + " hunger");
    }
  }
}
