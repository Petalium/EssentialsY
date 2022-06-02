package cool.oids.essentialsy;

import cool.oids.essentialsy.commands.misc.CommandAirstrike;
import cool.oids.essentialsy.commands.misc.CommandBigTree;
import cool.oids.essentialsy.commands.misc.CommandBroadcast;
import cool.oids.essentialsy.commands.misc.CommandDisposal;
import cool.oids.essentialsy.commands.misc.CommandDown;
import cool.oids.essentialsy.commands.misc.CommandEC;
import cool.oids.essentialsy.commands.misc.CommandFeed;
import cool.oids.essentialsy.commands.misc.CommandFly;
import cool.oids.essentialsy.commands.misc.CommandGamemode;
import cool.oids.essentialsy.commands.misc.CommandHeal;
import cool.oids.essentialsy.commands.misc.CommandInvsee;
import cool.oids.essentialsy.commands.misc.CommandKittyCannon;
import cool.oids.essentialsy.commands.misc.CommandLauncher;
import cool.oids.essentialsy.commands.misc.CommandMsg;
import cool.oids.essentialsy.commands.misc.CommandNuke;
import cool.oids.essentialsy.commands.misc.CommandPing;
import cool.oids.essentialsy.commands.misc.CommandRepair;
import cool.oids.essentialsy.commands.misc.CommandS;
import cool.oids.essentialsy.commands.misc.CommandSetHunger;
import cool.oids.essentialsy.commands.misc.CommandSethealth;
import cool.oids.essentialsy.commands.misc.CommandSuicide;
import cool.oids.essentialsy.commands.misc.CommandTop;
import cool.oids.essentialsy.commands.misc.CommandTpr;
import cool.oids.essentialsy.commands.misc.CommandUp;
import cool.oids.essentialsy.commands.misc.CommandWorkBench;
import cool.oids.essentialsy.commands.punish.CommandBan;
import cool.oids.essentialsy.commands.punish.CommandKick;
import cool.oids.essentialsy.commands.punish.CommandUnban;
import cool.oids.essentialsy.commands.tpa.CommandTpa;
import cool.oids.essentialsy.commands.tpa.CommandTpaCancel;
import cool.oids.essentialsy.commands.tpa.CommandTpaRespond;
import cool.oids.essentialsy.commands.tpa.CommandTpahere;
import cool.oids.essentialsy.items.ItemLauncher;
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

    this.getCommand("tpa").setExecutor(new CommandTpa());
    this.getCommand("tpahere").setExecutor(new CommandTpahere());
    this.getCommand("tpaccept").setExecutor(new CommandTpaRespond());
    this.getCommand("tpdeny").setExecutor(new CommandTpaRespond());
    this.getCommand("tpacancel").setExecutor(new CommandTpaCancel());

    this.getCommand("gma").setExecutor(new CommandGamemode());
    this.getCommand("gms").setExecutor(new CommandGamemode());
    this.getCommand("gmc").setExecutor(new CommandGamemode());
    this.getCommand("gmsp").setExecutor(new CommandGamemode());

    this.getCommand("ban").setExecutor(new CommandBan());
    this.getCommand("unban").setExecutor(new CommandUnban());
    this.getCommand("kick").setExecutor(new CommandKick());

    getServer().getPluginManager().registerEvents(new ItemLauncher(), this);
    getServer().getPluginManager().registerEvents(new CommandInvsee(), this);
  }

  @Override
  public void onDisable() {
    Bukkit.getLogger().info("Disabling");
  }

}
