package cool.oids.essentialsy.commands.utilities;

import cool.oids.essentialsy.Utils;
import cool.oids.essentialsy.commands.ToggleableCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandFullBright extends ToggleableCommand {

    private static final String enabledString =
            ChatColor.AQUA
                    + "Fullbright "
                    + ChatColor.GOLD
                    + "Enabled"
                    + ChatColor.AQUA
                    + " for "
                    + playerNameColor;
    private static final String disabledString =
            ChatColor.AQUA
                    + "Fullbright "
                    + ChatColor.GOLD
                    + "Disabled"
                    + ChatColor.AQUA
                    + " for "
                    + playerNameColor;

    @Override
    public void run(CommandSender sender, Command command, String label, String[] args) {
        toggleFromArgs(sender, args);
    }

    @Override
    protected void executeToggle(CommandSender sender, Player receiver) {
        if (receiver.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
            receiver.removePotionEffect(PotionEffectType.NIGHT_VISION);
            sender.sendMessage(disabledString + receiver.getDisplayName());
            return;
        }

        receiver.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 255, false, false, false));
        sender.sendMessage(enabledString + receiver.getDisplayName());
    }

}
