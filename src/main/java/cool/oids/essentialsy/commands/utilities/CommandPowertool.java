package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CommandPowertool extends PlayerExclusiveCommand {

    public static final String powerToolName = ChatColor.GRAY + "[" + ChatColor.YELLOW + "Powertool" + ChatColor.GRAY + "]";

    @Override
    public void run(Player player, Command command, String label, String[] args) {
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Invalid arguments");
            return;
        }
        if (itemStack.getType().isAir()) {
            player.sendMessage(ChatColor.RED + "Hold an item");
            return;
        }


        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GRAY + "[" + ChatColor.YELLOW + "Powertool" + ChatColor.GRAY + "]");

        String message = Utils.getMessage(args,0);
        itemMeta.setLore(List.of(message));

        itemStack.setItemMeta(itemMeta);
    }

}
