package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;


public class CommandGamemode extends EssentialsCommand {

	public void run(CommandSender sender, Command command, String label, String[] args) {
		GameMode targetGamemode;
		Player receiver = null;
		if (args.length == 0) {
			// /gmc
			targetGamemode = retrieveGamemodeArg(label);
		} else if (args.length > 1) {
			// /gamemode creative PLAYER
			targetGamemode = retrieveGamemodeArg(args[0]);
			if (targetGamemode == null) {
				sender.sendMessage(ChatColor.RED + "Not enough arguments provided");
				return;
			}

			receiver = Utils.extractPlayerArgWithWarningsInner(sender, args, 1);
		} else {
			targetGamemode = retrieveGamemodeArg(args[0].toLowerCase(Locale.ENGLISH));
			if (targetGamemode == null) {
				// /gmc PLAYER
				targetGamemode = retrieveGamemodeArg(label);
				receiver = Utils.extractPlayerArgWithWarnings(sender, args);
			}
		}

		if (receiver == null) {
			if (sender instanceof Player player) {
				receiver = player;
			} else {
				ranFromConsoleError(sender);
				return;
			}
		}

		if (targetGamemode == null) {
			sender.sendMessage(ChatColor.RED + "Not enough arguments provided");
			return;
		}

		String msg = ChatColor.AQUA + "Set gamemode for " + playerNameColor + receiver.getDisplayName() + ChatColor.AQUA + " to " + ChatColor.GOLD;

		receiver.setGameMode(targetGamemode);
		String gamemode = targetGamemode.toString().toLowerCase();
		sender.sendMessage(msg + gamemode.substring(0, 1).toUpperCase() + gamemode.substring(1));
	}

	@Nullable
	private GameMode retrieveGamemodeArg(String arg) {
		if (arg.equalsIgnoreCase("gmc") || arg.equalsIgnoreCase("creative")) {
			return GameMode.CREATIVE;
		} else if (arg.equalsIgnoreCase("gms") || arg.equalsIgnoreCase("survival")) {
			return GameMode.SURVIVAL;
		} else if (arg.equalsIgnoreCase("gma") || arg.equalsIgnoreCase("adventure")) {
			return GameMode.ADVENTURE;
		} else if (arg.equalsIgnoreCase("gmsp") || arg.equalsIgnoreCase("spectator")) {
			return GameMode.SPECTATOR;
		} else {
			return null;
		}
	}

}
