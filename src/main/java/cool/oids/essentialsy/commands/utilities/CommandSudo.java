package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

import static cool.oids.essentialsy.Utils.extractPlayerArgWithWarnings;

public class CommandSudo extends EssentialsCommand {
    public void run(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 2) {
            Player player = extractPlayerArgWithWarnings(sender, args);
            if (player == null) {
                return;
            }

            boolean isCommand;
            if (args[1].equalsIgnoreCase("message")) {
                isCommand = false;
            } else if (args[1].equalsIgnoreCase("command")) {
                isCommand = true;
            } else {
                sender.sendMessage(ChatColor.RED + "Invalid arguments");
                return;
            }

            String message = String.join(" ", Arrays.copyOfRange(args, 2, args.length));

            if (isCommand) {
                player.performCommand(message);
            } else {
                player.chat(message);
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Invalid arguments");
        }
    }
}
