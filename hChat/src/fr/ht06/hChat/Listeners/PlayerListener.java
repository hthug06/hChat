package fr.ht06.hChat.Listeners;

import fr.ht06.hChat.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

    private Main main;
    public PlayerListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onTalk(PlayerChatEvent event){
        Player player = event.getPlayer();
        String name = event.getPlayer().getName();

        String msg = event.getMessage();
        String playerinfo = PlaceholderAPI.setPlaceholders(player,main.getConfig().getString("Player_Info")).replace("&", "§");

        if (main.getConfig().getBoolean("Enable-plugin") == true){
            event.setCancelled(true);
            if (player.hasPermission(main.getConfig().getString("permission.ColorChat-Permission"))){
                Bukkit.broadcastMessage(PlaceholderAPI.setPlaceholders(player,main.getConfig().getString("Player_Info") + msg ).replace("&", "§"));
            }
            else {
                Bukkit.broadcastMessage(playerinfo + msg);
            }
        }else {
            event.setCancelled(false);
        }

    }

}

