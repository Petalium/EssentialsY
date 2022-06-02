package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandTop extends PlayerExclusiveCommand {
    @Override
    public void run(Player player, Command command, String label, String[] args) {
        Location loc = player.getLocation();
        int posX = loc.getBlockX();
        int posZ = loc.getBlockZ();
        float yaw = loc.getYaw();
        float pitch = loc.getPitch();

        World world = player.getWorld();
        int newY = Utils.getNearestSurface(loc, world);
        if (newY < 321) {
            player.teleport(new Location(world, loc.getX(), newY, loc.getZ(), yaw, pitch));
            player.sendMessage(
                    ChatColor.AQUA
                            + "Moved up into nearest surface"
                            + ChatColor.GOLD
                            + " ("
                            + posX
                            + ", "
                            + newY
                            + ", "
                            + posZ
                            + ")");
        } else {
            player.sendMessage(ChatColor.RED + "No surface found above");
        }
    }
}
