package cool.oids.essentialsy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class PlayerExclusiveCommand extends EssentialsCommand {
  @Override
  public boolean onCommand(
      @NotNull CommandSender sender,
      @NotNull Command command,
      @NotNull String label,
      String[] args) {
    if (sender instanceof Player player) {
      run(player, command, label, args);
    }

    ranFromConsoleError(sender);
    return true;
  }


}
