package cool.oids.essentialsy.commands.tpa;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ActiveTpas {
    public static ArrayList<Player> activeRecipients =
            new ArrayList<>(); // holds recipients for active requests
    public static ArrayList<CommandSender> activeSenders =
            new ArrayList<>(); // holds senders for active requests

    public static void addRecipient(Player player) {
        activeRecipients.add(player);
    }

    public static int removeRecipient(Player player) {
        int i = activeRecipients.indexOf(player);
        activeRecipients.remove(player);
        return i;
    }

    public static void addSender(CommandSender sender) {
        activeSenders.add(sender);
    }

    public static void removeSender(int i) {
        activeSenders.remove(i);
    }

    public static ArrayList<Player> getActiveRecipients() {
        return activeRecipients;
    }

    public static ArrayList<CommandSender> getActiveSenders() {
        return activeSenders;
    }
}
