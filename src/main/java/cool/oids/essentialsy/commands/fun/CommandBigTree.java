package cool.oids.essentialsy.commands.fun;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandBigTree extends PlayerExclusiveCommand {

	private static final int maxRetries = 5;

	@Override
	public void run(Player player, Command command, String label, String[] args) {
		World world = player.getWorld();
		Block targetBlock = player.getTargetBlock(null, 300);

		if (targetBlock.getType().isSolid()) {
			// Tree generation can fail depending on the TreeType, so we retry 5 times
			for (int i = 0; i < maxRetries; i++) {
				if (!generateTree(world, targetBlock, getTree())) {
					continue;
				}

				return;
			}
		}

		player.sendMessage(ChatColor.RED + "Tree could not be summoned");
	}

	boolean generateTree(World world, Block targetBlock, TreeType treeType) {
		return world.generateTree(targetBlock.getLocation().add(0, 1, 0), treeType);
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
