package cool.oids.essentialsy.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class EssentialsCommand implements IEssentialsCommand {

	public static ChatColor playerNameColor = ChatColor.YELLOW;
	public ArrayList<String> subCommands = null;

	public static void ranFromConsoleError(CommandSender sender) {
		sender.sendMessage("" + ChatColor.RED + "This command cannot be run in console");
	}

	@Override
	public ArrayList<String> onTabComplete(
			@NotNull CommandSender sender,
			@NotNull Command command,
			@NotNull String label,
			@NotNull String[] args) {
		return subCommands;
	}

}
