package cool.oids.essentialsy;
import cool.oids.essentialsy.commands.gamemodes.*;
import cool.oids.essentialsy.commands.misc.*;
import cool.oids.essentialsy.commands.punish.*;
import cool.oids.essentialsy.commands.tpa.*;
import cool.oids.essentialsy.items.ItemLauncher;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EssentialsY extends JavaPlugin {

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
        this.getCommand("sethunger").setExecutor(new CommandSethunger());
        this.getCommand("ec").setExecutor(new CommandEC());
        this.getCommand("workbench").setExecutor(new CommandWorkBench());
        this.getCommand("bigtree").setExecutor(new CommandBigTree());
        this.getCommand("launcher").setExecutor(new CommandLauncher());

        this.getCommand("tpa").setExecutor(new CommandTpa());
        this.getCommand("tpahere").setExecutor(new CommandTpahere());
        this.getCommand("tpaccept").setExecutor(new CommandTpaRespond());
        this.getCommand("tpdeny").setExecutor(new CommandTpaRespond());
        this.getCommand("tpacancel").setExecutor(new CommandTpacancel());

        this.getCommand("gma").setExecutor(new CommandGamemode());
        this.getCommand("gms").setExecutor(new CommandGamemode());
        this.getCommand("gmc").setExecutor(new CommandGamemode());
        this.getCommand("gmsp").setExecutor(new CommandGamemode());

        this.getCommand("ban").setExecutor(new CommandBan());
        this.getCommand("unban").setExecutor(new CommandUnban());
        this.getCommand("kick").setExecutor(new CommandKick());

        getServer().getPluginManager().registerEvents(new ItemLauncher(), this);

        ItemLauncher.createLauncher();
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling");
    }
}
