package cool.oids.essentialsy.commands.punish;
import cool.oids.essentialsy.Utils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getPlayerExact;

public class CommandBan implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length > 0) {
                String trimmed = args[0].trim();
                if (trimmed.length() > 2) {
                    player = getPlayerExact(trimmed);
                    BanList banList = Bukkit.getBanList(BanList.Type.NAME);

                        if (banList.isBanned(trimmed)) {
                            sender.sendMessage(ChatColor.RED + "Player " + ChatColor.GOLD + trimmed + ChatColor.RED + " is already banned");
                            return true;
                        } else {
                            if (player == null) {
                                if (args.length > 1) {
                                    banList.addBan(trimmed, Utils.getMessage(args, 1), null, ((Player) sender).getDisplayName());
                                    Bukkit.broadcastMessage
                                            (ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.RED + " banned " + ChatColor.GRAY + trimmed + ChatColor.RED + " for " +
                                                    ChatColor.LIGHT_PURPLE + "\"" + Utils.getMessage(args, 1) + "\"");
                                }
                                else {
                                    banList.addBan(trimmed, "none", null, ((Player) sender).getDisplayName());
                                    Bukkit.broadcastMessage
                                            (ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.RED + " banned " + ChatColor.GRAY + trimmed);
                                }
                            }
                            else {

                            if (args.length > 1) {
                                banList.addBan(trimmed, Utils.getMessage(args, 1), null, ((Player) sender).getDisplayName());
                                player.kickPlayer
                                (ChatColor.RED + "Banned by " + ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.RED + " for " + ChatColor.LIGHT_PURPLE + "\"" + Utils.getMessage(args,1) + "\"");
                                Bukkit.broadcastMessage
                                        (ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.RED + " banned " + ChatColor.GRAY + args[0] + ChatColor.RED + " for " +
                                                ChatColor.LIGHT_PURPLE + "\"" + Utils.getMessage(args, 1) + "\"");
                            } else {
                                banList.addBan(trimmed, "none", null, ((Player) sender).getDisplayName());
                                player.kickPlayer
                                        (ChatColor.RED + "Banned by " + ChatColor.YELLOW + ((Player) sender).getDisplayName());
                                Bukkit.broadcastMessage
                                        (ChatColor.YELLOW + ((Player) sender).getDisplayName() + ChatColor.RED + " banned " + ChatColor.GRAY + trimmed);
                            }
                        }
                    }
                }
                else {
                    sender.sendMessage(ChatColor.RED + "Player does not exist");
                }
                return true;
            }
            else {
                sender.sendMessage(ChatColor.RED + "No user inputted");
                return false;
            }
        }
        return false;
    }
}
