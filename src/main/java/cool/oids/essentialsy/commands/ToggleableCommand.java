package cool.oids.essentialsy.commands;

import cool.oids.essentialsy.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

public abstract class ToggleableCommand extends EssentialsCommand {

	protected void toggleFromArgs(final CommandSender sender, @NotNull final String[] args) {
		Player player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
		if (player == null) {
			return;
		}

		executeToggle(sender, player);
	}

	protected abstract void executeToggle(CommandSender sender, Player receiver);

}
