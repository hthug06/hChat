package fr.ht06.hChat.Commands;

import fr.ht06.hChat.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class colorCodeCommand implements CommandExecutor {

    private Main main;
    public colorCodeCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender Sender, Command command, String s, String[] strings) {

        if (Sender instanceof Player && Sender.hasPermission(main.getConfig().getString("permission.ColorCode-Permission"))){
            if (command.getName().equalsIgnoreCase("colorcode")){
                Sender.sendMessage("§c===============================");
                Sender.sendMessage("&0 = §0Black§r             &1 = §1Dark Blue");
                Sender.sendMessage("&2 = §2Dark Green§r     &3 = §3Dark Aqua");
                Sender.sendMessage("&4 = §4Dark Red§r        &5 = §5Purple");
                Sender.sendMessage("&6 = §6Orange§r          &7 = §7Gray");
                Sender.sendMessage("&8 = §8Dark gray§r      &9 = §9Blue");
                Sender.sendMessage("&a = §aGreen§r           &b = §bAqua");
                Sender.sendMessage("&c = §cRed§r              &d = §dPink");
                Sender.sendMessage("&e = §eYellow§r           &f = §fWhite");
                Sender.sendMessage("§c===============================");
                Sender.sendMessage("&k = §kvfcq§r             &l = §lBold");
                Sender.sendMessage("&m = §mStrikethrough§r &n = §nUnderline");
                Sender.sendMessage("&o = §oItalic§r            &r = §rReset");
            }
        }
        else if (Sender instanceof ConsoleCommandSender) {
            if (command.getName().equalsIgnoreCase("colorcode")){
                Sender.sendMessage("§c===============================");
                Sender.sendMessage("&0 = §0Black§r(Black)\n                 &1 = §1Dark Blue§r\n                 &2 = §2Dark Green§r\n                 &3 = §3Dark Aqua§r\n                 &4 = §4Dark Red§r\n                 &5 = §5Purple§r\n                 &6 = §6Orange§r\n                 &7 = §7Gray§r\n                 &8 = §8Dark gray§r\n                 &9 = §9Blue§r\n                 &a = §aGreen§r\n                 &b = §bAqua§r\n                 &c = §cRed§r\n                 &d = §dPink§r\n                 &e = §eYellow§r\n                 &f = §fWhite");

            }
        }
        else{
            if (command.getName().equalsIgnoreCase("colorcode")) {
                String msg = main.getConfig().getString("message.no-permission");
                Sender.sendMessage(msg.replace("&", "§"));
            }
        }


        return true;
    }
}
