package cool.oids.essentialsy.commands.misc;
import com.sun.source.tree.Tree;
import cool.oids.essentialsy.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class CommandBigtree implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
                World world = player.getWorld();
                TreeType tree = switch (Utils.randomNum(1, 6)) {
                    case 1 -> TreeType.TALL_REDWOOD;
                    case 2 -> TreeType.JUNGLE;
                    case 3 -> TreeType.DARK_OAK;
                    case 4 -> TreeType.MEGA_REDWOOD;
                    case 5 -> TreeType.TALL_BIRCH;
                    default -> TreeType.BIG_TREE;
                };
                Block block = player.getTargetBlock(null,300);
                if (block.getType().isSolid()) {
                    world.generateTree(block.getLocation().add(0,1,0), tree);
                } else {
                    sender.sendMessage(ChatColor.RED + "Tree could not be summoned");
                }
            return true;
        }
        return false;
    }
}
