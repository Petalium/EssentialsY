package cool.oids.essentialsy.commands.punish;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandUnban extends EssentialsCommand {
  @Override
  public void run(CommandSender sender, Command command, String label, String[] args) {
    String playerName = Utils.extractPlayerNameArg(sender, args);
    if (playerName != null) {
      BanList banList = Bukkit.getBanList(BanList.Type.NAME);

      if (banList.isBanned(playerName)) {
        banList.pardon(playerName);
        sender.sendMessage(ChatColor.AQUA + "Unbanned " + playerNameColor + playerName);
      } else {
        sender.sendMessage(ChatColor.RED + "Player " + playerNameColor + playerName + ChatColor.RED + " is not banned");
      }
    }
  }
}
