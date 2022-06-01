package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPing extends EssentialsCommand {
  static String usageString = "/ping [player]";

  @Override
  public void run(CommandSender sender, Command command, String label, String[] args) {
    Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
    if (player != null) {
      String prefix;
      if (args.length == 0) {
        prefix = "Ping: ";
      } else {
        prefix = playerNameColor + player.getDisplayName() + "'s " + "ping: ";
      }

      sender.sendMessage(prefix + player.getPing());
      return;
    }

    sender.sendMessage(usageString);
  }
}
