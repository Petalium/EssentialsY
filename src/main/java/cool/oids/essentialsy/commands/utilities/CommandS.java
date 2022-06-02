package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandS extends PlayerExclusiveCommand {
  @Override
  public void run(CommandSender sender, Command command, String label, String[] args) {
    Player toTeleport = Utils.extractPlayerArgWithWarnings(sender, args);
    if (toTeleport != null) {
      toTeleport.teleport(((Player) sender).getLocation());
      sender.sendMessage(
          ChatColor.AQUA
              + "Teleported "
              + playerNameColor
              + toTeleport.getDisplayName()
              + ChatColor.AQUA
              + " to you");
      toTeleport.sendMessage(
          playerNameColor + sender.getName() + ChatColor.AQUA + " teleported you to them");
    }
  }
}
