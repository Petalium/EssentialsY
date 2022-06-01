package cool.oids.essentialsy.commands.misc;

import cool.oids.essentialsy.commands.PlayerExclusiveCommand;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.Damageable;

public class CommandRepair extends PlayerExclusiveCommand implements TabCompleter {
    public CommandRepair() {
        this.subCommands = new ArrayList<>();
        this.subCommands.add("hand");
        this.subCommands.add("all");
    }

    @Override
    public void run(Player player, Command command, String label, String[] args) {
        PlayerInventory inventory = player.getInventory();

        if (args.length == 0 || args[0].equalsIgnoreCase("hand")) {
            ItemStack currentItem = inventory.getItemInMainHand();
            if (currentItem.getType().isBlock() || !itemDamagable(currentItem)) {
                player.sendMessage(ChatColor.RED + "Item cannot be repaired");
                return;
            }

            repairItem(currentItem);
            return;
        }

        if (args[0].equalsIgnoreCase("all")) {
            ItemStack[] items = inventory.getContents();
            for (final ItemStack item : items) {
                if (item == null || item.getType().isBlock() || !itemDamagable(item)) {
                    continue;
                }

                repairItem(item);
            }
        }
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
