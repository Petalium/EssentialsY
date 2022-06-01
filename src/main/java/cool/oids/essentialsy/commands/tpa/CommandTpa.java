package cool.oids.essentialsy.commands.tpa;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandTpa extends PlayerExclusiveCommand {
  @Override
  public void run(Player player, Command command, String label, String[] args) {
    Player receiver = Utils.extractPlayerArgWithWarnings(player, args);
    if (receiver != null) {
      if (ActiveTpas.getActiveSenders().contains(player)
          && ActiveTpas.getActiveRecipients().contains(player)) {
        player.sendMessage(
            ChatColor.RED
                + "You have already sent a tpa request to "
                + playerNameColor
                + player.getDisplayName());
        return;
      }

      TpaHandler handler = new TpaHandler(receiver, player);
      handler.count();
      player.sendMessage(
          ChatColor.AQUA + "Tpa request sent to " + playerNameColor + receiver.getDisplayName());
      receiver.sendMessage(
          playerNameColor
              + player.getName()
              + ChatColor.AQUA
              + " has sent you a tpa request."
              + ChatColor.AQUA
              + " type "
              + ChatColor.GOLD
              + "/tpaccept"
              + ChatColor.AQUA
              + " to accept");
    }
  }
}
