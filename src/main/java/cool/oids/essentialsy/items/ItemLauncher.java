package cool.oids.essentialsy.items;

import cool.oids.essentialsy.Utils;
import java.util.Arrays;
import java.util.Objects;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemLauncher implements Listener {
    public static ItemStack launcher;

    public ItemLauncher() {
        launcher = new ItemStack(Material.CARROT_ON_A_STICK, 1);
        ItemMeta meta = launcher.getItemMeta();
        String[] lore = {
                ChatColor.GRAY + "Right click to launch forward",
                ChatColor.GRAY + "Left click to launch backward"
        };

        assert meta != null;
        meta.setDisplayName("" + ChatColor.GOLD + ChatColor.BOLD + "Launcher");
        meta.setLore(Arrays.asList(lore));
        meta.addEnchant(Enchantment.LUCK, 1,false);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE);
        launcher.setItemMeta(meta);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        String launchType = "normal";

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            launchType = "normal";
        }
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
            launchType = "inverse";
        }

        if (e.getItem() != null) {
            if (Objects.equals(e.getItem().getItemMeta(), launcher.getItemMeta())) {
                switch(launchType) {
                    case "normal" -> Utils.launch(player,1,10);
                    case "inverse" -> Utils.launch(player,-1,10);
                }
                player.getWorld().createExplosion(player.getLocation(),0);
            }
        }
    }
}