package cool.oids.essentialsy;

import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayerExact;

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

    public static Player extractPlayerArgWithWarnings(CommandSender sender, String[] args) {
        if (args.length > 0) {
            String trimmed = args[0].trim();
            if (trimmed.length() > 2) {
                Player player = getPlayerExact(trimmed);

                if (player != null) {
                    return player;
                }

                sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + trimmed + ChatColor.RED + " is not online");
            } else {
                sender.sendMessage(ChatColor.RED + "Player does not exist");
            }
        }

        sender.sendMessage(ChatColor.RED + "No user inputted");
        return null;
    }

    public static String extractPlayerNameArg(CommandSender sender, String[] args) {
        if (args.length > 0) {
            String trimmed = args[0].trim();
            if (trimmed.length() > 2) {
                return trimmed;
            } else {
                sender.sendMessage(ChatColor.RED + "Player does not exist");
            }
        }

        sender.sendMessage(ChatColor.RED + "No user inputted");
        return null;
    }

    public static Player extractPlayerArgOrSenderWithWarnings(CommandSender sender, String[] args) {
        if (sender instanceof Player senderPlayer) {
            if (args.length > 0) {
                String trimmed = args[0].trim();
                if (trimmed.length() > 2) {
                    Player player = getPlayerExact(trimmed);
                    if (player == null) {
                        sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + trimmed + ChatColor.RED + " is not online");
                    }

                    return player;
                }

                sender.sendMessage(ChatColor.RED + "Player does not exist");
            }

            return senderPlayer;
        }

        return null;
    }

    public static int randomNum(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}