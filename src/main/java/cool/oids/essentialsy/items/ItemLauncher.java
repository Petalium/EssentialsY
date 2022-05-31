package cool.oids.essentialsy.items;

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
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Objects;


public class ItemLauncher implements Listener {
    public static ItemStack launcher;

    public ItemLauncher() {
        launcher = new ItemStack(Material.CARROT_ON_A_STICK, 1);
        ItemMeta meta = launcher.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Right click to launch forward");
        lore.add(ChatColor.GRAY + "Left click to launch backward");

        assert meta != null;
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Launcher");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1,false);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        launcher.setItemMeta(meta);
    }

    @EventHandler
    public static void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        String launchType = "normal";

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            launchType = "normal";
        }
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
            launchType = "inverse";
        }

        if (e.getItem() != null) {
            if (Objects.equals(e.getItem().getItemMeta(), ItemLauncher.launcher.getItemMeta())) {
                switch(launchType) {
                    case "normal" -> launch(player,1);
                    case "inverse" -> launch(player,-1);
                }
            }
        }
    }

    public static void launch(Player player, int mult) {
        Vector v = player.getLocation().getDirection();
        v.setX(v.getX() * 10);
        v.setY(v.getY() * 10);
        v.setZ(v.getZ() * 10);
        player.setVelocity(v.multiply(mult));
        player.getWorld().createExplosion(player.getLocation(), 0);
    }
}