package fr.ht06.hChat;


import fr.ht06.hChat.Listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerListener(this),this); // this cible l'objet courant
    }


    @Override
    public void onDisable() {

    }
}
