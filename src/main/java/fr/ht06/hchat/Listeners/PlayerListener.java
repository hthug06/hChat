package fr.ht06.hchat.Listeners;

import fr.ht06.hchat.HChat;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerListener implements Listener {

    private HChat main;
    public PlayerListener(HChat main) {
        this.main = main;
    }

    @EventHandler
    public void onTalk(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

        if (main.getConfig().getString("Player-Info") == null) return;

        String msg = event.getMessage();
        String playerinfo = main.getConfig().getString("Player-Info");


        //si le plugin est activé
        if (main.getConfig().getBoolean("Enable-plugin")){
            event.setCancelled(true);

            //si le joueur a la perm de parler avec le chatcolor
            if (player.hasPermission(main.getConfig().getString("permission.ColorChat-Permission"))){
                //si y a pas de Placeholder
                if (!(main.getConfig().getString("Player-Info").contains("%"))){
                    Bukkit.broadcastMessage(playerinfo.replace("[PLAYER]", player.getName()) + msg.replace("&", "§"));
                }
                //si il y a des placeholder
                if (main.getConfig().getString("Player-Info").contains("%")){
                    String playerinfoPlaceholderAPI = PlaceholderAPI.setPlaceholders(player, playerinfo);
                    Bukkit.broadcastMessage(playerinfoPlaceholderAPI.replace("[PLAYER]", player.getName()) + msg.replace("&", "§"));
                }
            }
            //si le joueur n'a pas les perm
            else {
                if (!(main.getConfig().getString("Player-Info").contains("%"))){
                    Bukkit.broadcastMessage(playerinfo.replace("[PLAYER]", player.getName()) + msg.replace("&", "§"));
                }
                //si il y a des placeholder
                if (main.getConfig().getString("Player-Info").contains("%")){
                    String playerinfoPlaceholderAPI = PlaceholderAPI.setPlaceholders(player, playerinfo);
                    Bukkit.broadcastMessage(playerinfoPlaceholderAPI.replace("[PLAYER]", player.getName()) + msg.replace("&", "§"));
                }
            }
        }
        //si le plugin n'est pas activé
        else {
            event.setCancelled(false);
        }

    }


    public void onMute(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
    }

}
