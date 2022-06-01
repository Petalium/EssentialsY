package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBigTree extends EssentialsCommand {
    private static final int maxRetries = 5;
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            player = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
            World world = player.getWorld();
            Block targetBlock = player.getTargetBlock(null,300);

            if (targetBlock.getType().isSolid()) {
                // Tree generation can fail depending on the TreeType, so we retry 5 times
                for (int i = 0; i < maxRetries; i++) {
                    if (!generateTree(world, targetBlock, getTree())) {
                        continue;
                    }

                    return true;
                }
            }

            sender.sendMessage(ChatColor.RED + "Tree could not be summoned");
            return true;
        }

        return false;
    }

    boolean generateTree(World world, Block targetBlock, TreeType treeType) {
        return world.generateTree(targetBlock.getLocation().add(0,1,0), treeType);
    }

    TreeType getTree() {
        return switch (Utils.randomNum(1, 6)) {
            case 1 -> TreeType.TALL_REDWOOD;
            case 2 -> TreeType.JUNGLE;
            case 3 -> TreeType.DARK_OAK;
            case 4 -> TreeType.MEGA_REDWOOD;
            case 5 -> TreeType.TALL_BIRCH;
            default -> TreeType.BIG_TREE;
        };
    }
}
