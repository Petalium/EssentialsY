package cool.oids.essentialsy;
import cool.oids.essentialsy.commands.gamemodes.*;
import cool.oids.essentialsy.commands.misc.*;
import cool.oids.essentialsy.commands.punish.*;
import cool.oids.essentialsy.commands.tpa.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class EssentialsY extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("fly")).setExecutor(new CommandFly());
        Objects.requireNonNull(this.getCommand("msg")).setExecutor(new CommandMsg());
        Objects.requireNonNull(this.getCommand("up")).setExecutor(new CommandUp());
        Objects.requireNonNull(this.getCommand("down")).setExecutor(new CommandDown());
        Objects.requireNonNull(this.getCommand("top")).setExecutor(new CommandTop());

        Objects.requireNonNull(this.getCommand("tpa")).setExecutor(new CommandTpa());
        Objects.requireNonNull(this.getCommand("tpahere")).setExecutor(new CommandTpahere());
        Objects.requireNonNull(this.getCommand("tpaccept")).setExecutor(new CommandTpaccept());
        Objects.requireNonNull(this.getCommand("tpdeny")).setExecutor(new CommandTpdeny());
        Objects.requireNonNull(this.getCommand("tpacancel")).setExecutor(new CommandTpacancel());

        Objects.requireNonNull(this.getCommand("gma")).setExecutor(new CommandGma());
        Objects.requireNonNull(this.getCommand("gmc")).setExecutor(new CommandGmc());
        Objects.requireNonNull(this.getCommand("gms")).setExecutor(new CommandGms());
        Objects.requireNonNull(this.getCommand("gmsp")).setExecutor(new CommandGmsp());

        Objects.requireNonNull(this.getCommand("ban")).setExecutor(new CommandBan());
        Objects.requireNonNull(this.getCommand("unban")).setExecutor(new CommandUnban());
        Objects.requireNonNull(this.getCommand("kick")).setExecutor(new CommandKick());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling");
    }
}
