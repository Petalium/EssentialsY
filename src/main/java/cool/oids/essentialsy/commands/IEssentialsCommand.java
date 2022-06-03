package cool.oids.essentialsy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface IEssentialsCommand extends CommandExecutor, TabCompleter {

	@Override
	default boolean onCommand(
			@NotNull CommandSender sender,
			@NotNull Command command,
			@NotNull String label,
			String[] args) {
		run(sender, command, label, args);
		return true;
	}

	default void run(CommandSender sender, Command command, String label, String[] args) {
	}

	default void run(Player player, Command command, String label, String[] args) {
		run((CommandSender) player, command, label, args);
	}

}
