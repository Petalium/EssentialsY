package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.ToggleableCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed extends ToggleableCommand {
    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        toggleFromArgs(sender, args);
    }

    @Override
    protected void executeToggle(CommandSender sender, Player receiver) {
        receiver.setFoodLevel(20);
        sender.sendMessage(
                ChatColor.AQUA
                        + "Restored player "
                        + playerNameColor
                        + receiver.getDisplayName()
                        + ChatColor.AQUA
                        + " hunger");
    }

}
