package de.fuchscrafter.pokeboxmc.pokeboxcommands.commands;

import de.fuchscrafter.pokeboxmc.pokeboxcommands.PokeboxCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class DiscordLink implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        PokeboxCommands instance = PokeboxCommands.getInstance();

        String prefix = PokeboxCommands.prefix;



        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players may use this command. You could also use the config.yml if you are familiar with configuration files.");
            return true;

        }

        Player player = (Player) sender;

        boolean hasUsePerms = player.hasPermission("pokeboxcommands.discordlink.use");

         if (!hasUsePerms){
            player.sendMessage(ChatColor.RED + "You are not allowed to use this command!");
         }

        if ((args.length == 0) && (hasUsePerms)) {

            String link = instance.getConfig().getString("discord-link");

            sender.sendMessage(prefix + "The Discord Link is: " + ChatColor.UNDERLINE + link);
        }

        if ((args.length > 0) && (hasUsePerms)){

            if ( (args[0].equalsIgnoreCase("set") ) && (args.length == 2) ) {

                if (player.hasPermission("pokeboxcommands.discordlink.set")) {

                    String newLink = args[1];
                    instance.getConfig().set("discord-link", newLink);
                    instance.saveConfig();
                    if ((instance.getConfig().getString("discord-link")) == (newLink)) {
                        getLogger().info("Set the Discord link to:" + newLink);
                        sender.sendMessage(prefix + "Successfully set the link to " + newLink);
                    } else {
                        sender.sendMessage(prefix + ChatColor.RED + "Could not set the prefix. Please contact an Developer.");
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "You are not allowed to use this command!");
                }

            } else {
                sender.sendMessage(prefix + ChatColor.RED + "Incorrect sub-command.");
            }


        }

        return true;

    }
}


