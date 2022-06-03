package cool.oids.essentialsy.commands.fun;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandBatMount extends PlayerExclusiveCommand {

	public void run(Player sender, Command command, String label, String[] args) {
		World world = sender.getWorld();
		Entity bat = world.spawnEntity(sender.getLocation(), EntityType.BAT);
		bat.addPassenger(sender);
	}

}
