package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEC extends EssentialsCommand {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player.closeInventory();
            player.openInventory(player.getEnderChest());
            return true;
        }

        return false;
    }
}
