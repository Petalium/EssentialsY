package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandEC extends PlayerExclusiveCommand {

	@Override
	public void run(Player player, Command command, String label, String[] args) {
		player.closeInventory();
		player.openInventory(player.getEnderChest());
	}

}
