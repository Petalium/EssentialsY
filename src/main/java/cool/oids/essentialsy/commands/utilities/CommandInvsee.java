package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.PlayerExclusiveCommand;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class CommandInvsee extends PlayerExclusiveCommand implements Listener {
    private final ItemStack equip;
    private final ItemStack contents;
    private final ItemStack clear;
    private final ItemStack plrHead;
    private final String[] lore = new String[1];

    public CommandInvsee() {
        equip = new ItemStack(Material.ARMOR_STAND);
        ItemMeta meta = equip.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "Equipped");
        lore[0] = ChatColor.GRAY + "Displays players equipment and offhand slots"; //does not actually alter slots
        meta.setLore(Arrays.asList(lore));
        equip.setItemMeta(meta);

        contents = new ItemStack(Material.CHEST);
        meta = contents.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "Contents");
        lore[0] = ChatColor.GRAY + "Alters players inventory";
        meta.setLore(Arrays.asList(lore));
        contents.setItemMeta(meta);

        clear = new ItemStack(Material.TNT);
        meta = clear.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.RED + "Clear inventory");
        lore[0] = ChatColor.GRAY + "Clears players inventory";
        meta.setLore(Arrays.asList(lore));
        clear.setItemMeta(meta);

        plrHead = new ItemStack(Material.PLAYER_HEAD);
    }

    public void run(Player sender, Command command, String label, String[] args) {
        Player player = Utils.extractPlayerArgWithWarnings(sender, args);
        if (player != null) {

            ItemMeta meta = plrHead.getItemMeta();
            assert meta != null;
            meta.setDisplayName(ChatColor.AQUA + "Player " + playerNameColor + player.getDisplayName());
            lore[0] = ChatColor.GRAY + "UUID: " + ChatColor.GOLD + player.getUniqueId();
            meta.setLore(Arrays.asList(lore));
            plrHead.setItemMeta(meta);

            SkullMeta skullMeta = (SkullMeta) plrHead.getItemMeta();
            skullMeta.setOwningPlayer(player);
            plrHead.setItemMeta(skullMeta);

            Inventory select = Bukkit.createInventory(player, 9, "Inventory selection");
            select.setItem(0, plrHead);
            select.setItem(3, equip);
            select.setItem(5, contents);
            select.setItem(8, clear);

            sender.closeInventory();
            sender.openInventory(select);
        }
    }
}
