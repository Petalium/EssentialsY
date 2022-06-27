package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandMore extends PlayerExclusiveCommand {

    @Override
    public void run(Player player, Command command, String label, String[] args) {
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (!itemStack.hasItemMeta()) {
            player.sendMessage(ChatColor.RED + "Hold an item in your main hand");
            return;
        }
        switch (args.length) {
            case 0 -> itemStack.setAmount(itemStack.getMaxStackSize());
            case 1 -> {
                int count = itemStack.getAmount();
                int add;
                
                try {
                    add = Integer.parseUnsignedInt(args[0]);
                } catch(Exception ignored) {
                    player.sendMessage(ChatColor.RED + "Argument provided is not a positive integer");
                    return;
                }

                if ((count + add) < 128) {
                    itemStack.setAmount(count + add);
                } else {
                    player.sendMessage(ChatColor.RED + "The number provided is too large");
                }
            }
            default -> player.sendMessage(ChatColor.RED + "Invalid arguments");

        }
    }

}
