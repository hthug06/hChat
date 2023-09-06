package fr.ht06.hchat.Commands;

import fr.ht06.hchat.HChat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class muteCommand implements CommandExecutor {

    private HChat main;
    public muteCommand(HChat main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("mute")){
            if (args.length == 0){
                sender.sendMessage("§c/mute <player> <Time>");
            }

            if (args.length == 1) {
                sender.sendMessage("§c/mute <player> <Time>");
            }

            if (args.length == 2) {
                String targetName = args[0];

                //Pour vérifier si le joueur est en ligne ou pas
                if (Bukkit.getPlayer(targetName) == null){  //On vérifie si le joueur avec le pseudo de target est connecter ou non
                    Player target = Bukkit.getPlayer(targetName);
                    sender.sendMessage("Pas un joueur");
                }

                if (Bukkit.getPlayer(targetName) != null){  //si le joueur est en ligne
                    Integer time = Integer.valueOf(args[1]);

                    main.mutedPlayer.put(targetName, time);

                }
            }

        }

        return true;
    }
}
