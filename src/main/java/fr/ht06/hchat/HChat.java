package fr.ht06.hchat;

import fr.ht06.hchat.Commands.colorCodeCommand;
import fr.ht06.hchat.Commands.muteCommand;
import fr.ht06.hchat.Listeners.PlayerListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class HChat extends JavaPlugin {

    public Map<String, Integer> mutedPlayer = new HashMap<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("hChat").setExecutor(this);
        getCommand("colorcode").setExecutor(new colorCodeCommand(this));
        getCommand("hChatreload").setExecutor(this);
        getCommand("mute").setExecutor(new muteCommand(this));
        getServer().getPluginManager().registerEvents(new PlayerListener(this),this); // this cible l'objet


    }


    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("hChatreload")){
            if (!sender.hasPermission("permissions.ReloadConfig-Permission")){
                sender.sendMessage(getConfig().getString("message.no-permission").replace("&", "§").replace("[PLAYER]", sender.getName()));
                return true;
            }

            if (sender.hasPermission("permissions.ReloadConfig-Permission")){
                reloadConfig();
                sender.sendMessage("§9[§bhChat§9] §cConfig Reload");
            }
        }


        return true;
    }

    public class hChatCommand implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

            if (cmd.getName().equalsIgnoreCase("hchat")){
                sender.sendMessage("§bhChat v1.5 create by §9§lht06");
            }

            return true;
        }
    }
}
