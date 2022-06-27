package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class CommandBreak extends PlayerExclusiveCommand {
    @Override
    public void run(Player player, Command command, String label, String[] args) {
        Block targetBlock = player.getTargetBlock(null, 300);

        if (targetBlock.getType().isAir()) {
            player.sendMessage(ChatColor.RED +"Look at a block");
            return;
        }

        targetBlock.setType(Material.AIR);
    }
}
