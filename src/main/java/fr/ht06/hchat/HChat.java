package fr.ht06.hchat;

import fr.ht06.hchat.Commands.colorCodeCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class HChat extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getCommand("hChat").setExecutor(this);
        getCommand("colorcode").setExecutor(new colorCodeCommand(this));
        getCommand("hChatreload").setExecutor(this);
        //getServer().getPluginManager().registerEvents(new PlayerListener(this),this); // this cible l'objet


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
