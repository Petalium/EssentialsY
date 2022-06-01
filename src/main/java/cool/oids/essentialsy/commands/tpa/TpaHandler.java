package cool.oids.essentialsy.commands.tpa;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpaHandler {
  private boolean activeRequest;
  private final Player player;
  private final CommandSender sender;

  public TpaHandler(Player plr, CommandSender snd) {
    player = plr;
    sender = snd;

    ActiveTpas.addRecipient(player);
    ActiveTpas.addSender(sender);
  }

  public void count() {

    final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    final Runnable runnable =
        new Runnable() {
          int timer = 60; // time (SECONDS) till TPA expires

          public void run() {
            timer--;

            if (timer < 0 || !(ActiveTpas.getActiveRecipients().contains(player))) {
              activeRequest = false;
              if (ActiveTpas.getActiveRecipients().contains(player)) {
                sender.sendMessage(
                    ChatColor.GRAY
                        + "Teleport request to "
                        + ChatColor.YELLOW
                        + player.getDisplayName()
                        + ChatColor.GRAY
                        + " has expired");
                player.sendMessage(
                    ChatColor.YELLOW
                        + sender.getName()
                        + ChatColor.GRAY
                        + " teleport request has expired");
                ActiveTpas.removeSender(ActiveTpas.removeRecipient(player));
              }
              scheduler.shutdown();
            }
          }
        };
    scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
  }
}
