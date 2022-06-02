package cool.oids.essentialsy.commands.fun;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.EssentialsCommand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CommandLauncher extends EssentialsCommand {
    public static ItemStack launcher = new ItemStack(Material.CARROT_ON_A_STICK, 1);

    public CommandLauncher() {
        ItemMeta meta = launcher.getItemMeta();
        String[] lore = {
                ChatColor.GRAY + "Right click to launch forward",
                ChatColor.GRAY + "Left click to launch backward"
        };

        assert meta != null;
        meta.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Launcher");
        meta.setLore(Arrays.asList(lore));
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        launcher.setItemMeta(meta);
    }

    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        Player receiver;
        if (args.length > 0) {
            receiver = Utils.extractPlayerArgOrSenderWithWarnings(sender, args);
        } else if (sender instanceof Player player) {
            receiver = player;
        } else {
            ranFromConsoleError(sender);
            return;
        }

        if (receiver != null) {
            receiver.getInventory().addItem(launcher);
            sender.sendMessage(ChatColor.AQUA + "Gave player " + playerNameColor + receiver.getDisplayName() + ChatColor.GOLD + " launcher");
        }
    }
}


