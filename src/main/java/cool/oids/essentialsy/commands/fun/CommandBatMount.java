package cool.oids.essentialsy.commands.fun;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import cool.oids.essentialsy.events.EssentialsBatDismountEvent;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getServer;

public class CommandBatMount extends PlayerExclusiveCommand {

	public CommandBatMount(EssentialsBatDismountEvent event, Plugin plug) {
		getServer().getPluginManager().registerEvents(event, plug);
	}

	public void run(Player sender, Command command, String label, String[] args) {
		World world = sender.getWorld();
		Entity bat = world.spawnEntity(sender.getLocation(), EntityType.BAT);
		bat.addPassenger(sender);
	}

}
