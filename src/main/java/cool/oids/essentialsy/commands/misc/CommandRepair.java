package cool.oids.essentialsy.commands.misc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;

import java.util.ArrayList;

public class CommandRepair implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            PlayerInventory inventory = player.getInventory();

            if (args.length == 0 || args[0].equalsIgnoreCase("hand")) {
                ItemStack currentItem = inventory.getItemInMainHand();
                if (currentItem.getType().isBlock() || !itemDamagable(currentItem)) {
                    sender.sendMessage(ChatColor.RED + "Item cannot be repaired");
                    return true;
                }

                repairItem(currentItem);
                return true;
            }
            if (args[0].equalsIgnoreCase("all")) {
                ItemStack[] items = inventory.getContents();
                for (final ItemStack item : items) {
                    if (item == null || item.getType().isBlock() || !itemDamagable(item)) {
                        continue;
                    }

                    repairItem(item);
                }

                return true;
            }
        }

        return false;
    }
    @Override
    public ArrayList<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> options = new ArrayList<>();
        if (args.length == 1) {
            options.add("hand");
            options.add("all");
        }

        return options;
    }
    void repairItem(ItemStack item) {
        if (item.getItemMeta() instanceof Damageable damageable) {
            damageable.setDamage(0);
            item.setItemMeta(damageable);
        }
    }

    int itemDamage(ItemStack item) {
        if (item.getItemMeta() instanceof Damageable itemMeta) {
            return itemMeta.getDamage();
        }
        return 0;
    }

    boolean itemDamagable(ItemStack item) {
        return itemDamage(item) > 0;
    }
}
