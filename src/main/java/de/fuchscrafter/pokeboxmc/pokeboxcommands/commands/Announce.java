package de.fuchscrafter.pokeboxmc.pokeboxcommands.commands;

import de.fuchscrafter.pokeboxmc.pokeboxcommands.PokeboxCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Announce implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        String prefix = PokeboxCommands.prefix;

        if (!(sender instanceof Player)) {

            sender.sendMessage("Only players may use this command.");
            return true;
        }



        Player player = (Player) sender;
        boolean hasUsePerms = player.hasPermission("pokeboxmc.announce");

        if (args.length == 0) {
            player.sendMessage(prefix + ChatColor.RED + "You can't announce nothing!");
            return true;
        }


        if (hasUsePerms) {

            StringBuilder userArgs = new StringBuilder(); // init the string builder


            for (String arg : args) { // loop through all in args using advanced for loops
                userArgs.append(arg).append(" "); // appends it to the string builder
            }
            

            String msg =ChatColor.GOLD + "[Announcement] " + ChatColor.RESET + ChatColor.BOLD + userArgs; // constructs the message by using the prefix, a golden color for the announcement prefix, and the message from the string builder

            

            for (Player p : Bukkit.getOnlinePlayers()) { // loops through all online players
                p.sendMessage(msg); // sends the message
            }

            player.sendMessage(prefix + ChatColor.GREEN + "Announcement sent!"); // reports the success of announcing to the command user


        } else {
            player.sendMessage(ChatColor.RED + "You are not allowed to use this command!");
        }
        return true;


    }
}
