package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly extends EssentialsCommand {
  private static final String enabledString =
      ChatColor.AQUA
          + "Fly "
          + ChatColor.GOLD
          + "Enabled"
          + ChatColor.AQUA
          + " for "
          + playerNameColor;
  private static final String disabledString =
      ChatColor.AQUA
          + "Fly "
          + ChatColor.GOLD
          + "Disabled"
          + ChatColor.AQUA
          + " for "
          + playerNameColor;

  @Override
  public void run(CommandSender sender, Command command, String label, String[] args) {
    Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
    if (player != null) {
      player.setAllowFlight(!player.getAllowFlight());
      sender.sendMessage(
          player.getAllowFlight()
              ? enabledString + player.getDisplayName()
              : disabledString + player.getDisplayName());
    }
  }
}
