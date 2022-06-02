package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandDisposal extends PlayerExclusiveCommand {

    @Override
    public void run(Player sender, Command command, String label, String[] args) {
        Server server = sender.getServer();
        sender.openInventory(server.createInventory(sender, 36, ChatColor.RED + "Disposal"));
    }

}
