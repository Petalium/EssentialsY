package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandPlatform extends PlayerExclusiveCommand {

    @Override
    public void run(Player player, Command command, String label, String[] args) {
        int length;
        int width;
        if (args.length > 0) {
            try {
                if (args.length > 1) {
                    width = Integer.parseUnsignedInt(args[1].trim());
                } else {
                    width = Integer.parseUnsignedInt(args[0].trim());
                }
                length = Integer.parseUnsignedInt(args[0].trim());
            } catch (Exception e) {
                player.sendMessage(ChatColor.RED + "Argument is not a positive integer");
                return;
            }
        } else {
            player.sendMessage(ChatColor.RED + "Size was not specified");
            return;
        }

        Location loc = player.getLocation();
        World world = player.getWorld();

        player.teleport(loc.add(0,1,0));
        for (int i = 0; i < length; i++) {
            for (int k = 0; k < width; k++) {
                world.getBlockAt(loc.getBlockX()+k, loc.getBlockY()-1, loc.getBlockZ()+i).setType(Material.STONE);
            }
        }
        player.sendMessage(ChatColor.AQUA + "Created a " + ChatColor.GOLD
            + length + "x" + width + ChatColor.AQUA + " platform");
    }

}
