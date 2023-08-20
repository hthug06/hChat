package fr.ht06.hChat.Commands;

import fr.ht06.hChat.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hChatCommand implements CommandExecutor {
    private Main main;
    public hChatCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (cmd.getName().equalsIgnoreCase("hchat")){
            sender.sendMessage("§6hChat v1.3 create by §cht06 !");
        }

        return true;
    }
}
