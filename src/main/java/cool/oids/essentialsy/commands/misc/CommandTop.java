package cool.oids.essentialsy.commands.misc;
import cool.oids.essentialsy.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTop implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            int posX = player.getLocation().getBlockX();
            int posZ = player.getLocation().getBlockZ();
            float yaw = player.getLocation().getYaw();
            float pitch = player.getLocation().getPitch();
            World world = player.getWorld();
            int newY = Utils.getNearestSurface(player.getLocation(), world);

            if (newY < 321) {
                player.teleport(new Location(world, posX, newY, posZ, yaw, pitch));
                sender.sendMessage(ChatColor.AQUA + "Moved up into nearest surface" +
                        ChatColor.GOLD + " (" + posX + ", " + newY + ", " + posZ + ")");
            } else {
                sender.sendMessage(ChatColor.RED + "No surface found above");
            }
            return true;
        }
        return false;
    }
}