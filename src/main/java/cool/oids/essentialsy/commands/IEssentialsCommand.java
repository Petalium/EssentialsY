package cool.oids.essentialsy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public interface IEssentialsCommand extends CommandExecutor {
  @Override
  default boolean onCommand(
      @NotNull CommandSender sender,
      @NotNull Command command,
      @NotNull String label,
      String[] args) {
    run(sender, command, label, args);
    return true;
  }

  void run(CommandSender sender, Command command, String label, String[] args);
}
