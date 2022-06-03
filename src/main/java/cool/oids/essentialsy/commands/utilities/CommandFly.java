package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.ToggleableCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly extends ToggleableCommand {
    private static final String enabledString =
            ChatColor.AQUA
                    + "Fly "
                    + ChatColor.GOLD
                    + "Enabled"
                    + ChatColor.AQUA
                    + " for "
                    + playerNameColor;
    private static final String disabledString =
            ChatColor.AQUA
                    + "Fly "
                    + ChatColor.GOLD
                    + "Disabled"
                    + ChatColor.AQUA
                    + " for "
                    + playerNameColor;

    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        toggleFromArgs(sender, args);
    }

    @Override
    protected void executeToggle(CommandSender sender, Player receiver) {
        receiver.setAllowFlight(!receiver.getAllowFlight());
        sender.sendMessage(
                receiver.getAllowFlight()
                        ? enabledString + receiver.getDisplayName()
                        : disabledString + receiver.getDisplayName());
    }

}
