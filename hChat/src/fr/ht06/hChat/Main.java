package fr.ht06.hChat;


import fr.ht06.hChat.Commands.colorCodeCommand;
import fr.ht06.hChat.Commands.hChatCommand;
import fr.ht06.hChat.Listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("hChat").setExecutor(new hChatCommand(this));
        getCommand("colorcode").setExecutor(new colorCodeCommand(this));
        getCommand("hChatreload").setExecutor(this);
        getServer().getPluginManager().registerEvents(new PlayerListener(this),this); // this cible l'objet


    }


    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("hChatreload")){
            if (!sender.hasPermission("permissions.ReloadConfig-Permission")){
                sender.sendMessage(getConfig().getString("message.no-permission").replace("&", "§"));
                return true;
            }

            if (sender.hasPermission("permissions.ReloadConfig-Permission")){
                reloadConfig();
                sender.sendMessage("§9[§bhChat§9] §cConfig Reload");
            }
        }


        return true;
    }
}
