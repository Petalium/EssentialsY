package cool.oids.essentialsy;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Utils {
    public static String getMessage(String[] args, int index) {
        StringBuilder result = new StringBuilder();
        for (int i = index; i < args.length; i++)
            result.append(args[i]).append(" ");
        return result.toString().trim();
    }

    public static int getNearestHole(Location loc, World world) {
        int y = -100;
        int posX = loc.getBlockX();
        int posY = loc.getBlockY();
        int posZ = loc.getBlockZ();
        int streak = 0;
        boolean catchNext = false;

        for (int i = posY; i > -64; i--) {
            if (world.getBlockAt(posX, i - 1, posZ).getType().equals(Material.AIR)) {
                streak++;
            } else if (catchNext) {
                y = i;
                break;
            }
            if (streak >= 2) {
                catchNext = true;
            }
        }
        return y;
    }

    public static int getNearestSurface(Location loc, World world) {
        int y = 330;
        int posX = loc.getBlockX();
        int posY = loc.getBlockY();
        int posZ = loc.getBlockZ();
        boolean onSurface = false;

        for (int i = posY; i <= 320; i++) {
            if (onSurface) {
                if (world.getBlockAt(posX, i, posZ).getType().equals(Material.AIR)
                        && world.getBlockAt(posX, i, posZ).getType().equals(Material.AIR)) {
                    y = i;
                    break;
                } else {
                    onSurface = false;
                }
            } else {
                if (!world.getBlockAt(posX, i, posZ).getType().equals(Material.AIR)) {
                    onSurface = true;
                }
            }
        }
        return y;
    }
}