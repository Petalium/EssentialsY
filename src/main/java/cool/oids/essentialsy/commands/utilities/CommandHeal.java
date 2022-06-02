package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal extends EssentialsCommand {
  @Override
  public void run(CommandSender sender, Command command, String label, String[] args) {
    Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
    if (player != null) {
      player.setHealth(20.0);
      sender.sendMessage(
          ChatColor.AQUA
              + "Restored player "
              + ChatColor.YELLOW
              + player.getDisplayName()
              + ChatColor.AQUA
              + " health");
    }
  }
}
