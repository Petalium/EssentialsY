package cool.oids.essentialsy;

import cool.oids.essentialsy.commands.fun.*;
import cool.oids.essentialsy.commands.punish.CommandBan;
import cool.oids.essentialsy.commands.punish.CommandKick;
import cool.oids.essentialsy.commands.punish.CommandUnban;
import cool.oids.essentialsy.commands.tpa.CommandTpa;
import cool.oids.essentialsy.commands.tpa.CommandTpaCancel;
import cool.oids.essentialsy.commands.tpa.CommandTpaRespond;
import cool.oids.essentialsy.commands.tpa.CommandTpahere;
import cool.oids.essentialsy.commands.utilities.*;
import cool.oids.essentialsy.events.EssentialsDismountEvent;
import cool.oids.essentialsy.events.EssentialsInventoryEvent;
import cool.oids.essentialsy.events.EssentialsPlayerEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EssentialsY extends JavaPlugin {

	@SuppressWarnings("ConstantConditions")
	@Override
	public void onEnable() {
		this.getCommand("fly").setExecutor(new CommandFly());
		this.getCommand("msg").setExecutor(new CommandMsg());
		this.getCommand("up").setExecutor(new CommandUp());
		this.getCommand("down").setExecutor(new CommandDown());
		this.getCommand("top").setExecutor(new CommandTop());
		this.getCommand("repair").setExecutor(new CommandRepair());
		this.getCommand("s").setExecutor(new CommandS());
		this.getCommand("feed").setExecutor(new CommandFeed());
		this.getCommand("heal").setExecutor(new CommandHeal());
		this.getCommand("sethealth").setExecutor(new CommandSethealth());
		this.getCommand("sethunger").setExecutor(new CommandSetHunger());
		this.getCommand("ec").setExecutor(new CommandEC());
		this.getCommand("workbench").setExecutor(new CommandWorkBench());
		this.getCommand("bigtree").setExecutor(new CommandBigTree());
		this.getCommand("launcher").setExecutor(new CommandLauncher());
		this.getCommand("kittycannon").setExecutor(new CommandKittyCannon());
		this.getCommand("ping").setExecutor(new CommandPing());
		this.getCommand("suicide").setExecutor(new CommandSuicide());
		this.getCommand("broadcast").setExecutor(new CommandBroadcast());
		this.getCommand("invsee").setExecutor(new CommandInvsee());
		this.getCommand("nuke").setExecutor(new CommandNuke());
		this.getCommand("airstrike").setExecutor(new CommandAirstrike());
		this.getCommand("disposal").setExecutor(new CommandDisposal());
		this.getCommand("tpr").setExecutor(new CommandTpr());
		this.getCommand("fullbright").setExecutor(new CommandFullBright());
		this.getCommand("skull").setExecutor(new CommandSkull());
		this.getCommand("batmount").setExecutor(new CommandBatMount());
		this.getCommand("players").setExecutor(new CommandPlayerList());

		this.getCommand("tpa").setExecutor(new CommandTpa());
		this.getCommand("tpahere").setExecutor(new CommandTpahere());
		this.getCommand("tpaccept").setExecutor(new CommandTpaRespond());
		this.getCommand("tpdeny").setExecutor(new CommandTpaRespond());
		this.getCommand("tpacancel").setExecutor(new CommandTpaCancel());

		this.getCommand("gamemode").setExecutor(new CommandGamemode());

		this.getCommand("ban").setExecutor(new CommandBan());
		this.getCommand("unban").setExecutor(new CommandUnban());
		this.getCommand("kick").setExecutor(new CommandKick());

		getServer().getPluginManager().registerEvents(new EssentialsPlayerEvent(), this);
		getServer().getPluginManager().registerEvents(new EssentialsInventoryEvent(), this);
		getServer().getPluginManager().registerEvents(new EssentialsDismountEvent(), this);
	}

	@Override
	public void onDisable() {
		Bukkit.getLogger().info("Disabling");
	}

}
