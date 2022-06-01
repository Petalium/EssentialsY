package cool.oids.essentialsy.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public abstract class EssentialsCommand implements IEssentialsCommand {
  public static ChatColor playerNameColor = ChatColor.YELLOW;
  public ArrayList<String> subCommands = null;

  @Override
  public ArrayList<String> onTabComplete(
      @NotNull CommandSender sender,
      @NotNull Command command,
      @NotNull String label,
      @NotNull String[] args) {
    return subCommands;
  }
}
