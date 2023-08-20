package fr.ht06.hChat.Listeners;

import fr.ht06.hChat.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerListener implements Listener {

    private Main main;
    public PlayerListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onTalk(PlayerChatEvent event){
        Player player = event.getPlayer();
        event.setCancelled(true);
        String msg = event.getMessage();
        String newmsg = msg.replace("&", "§");
        String prefix = PlaceholderAPI.setPlaceholders(player,"%player_name%: ").replace("&", "§");
        Bukkit.broadcastMessage(prefix + newmsg);

    }

}
