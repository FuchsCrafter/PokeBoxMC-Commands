package de.fuchscrafter.pokeboxmc.pokeboxcommands.commands;

import de.fuchscrafter.pokeboxmc.pokeboxcommands.PokeboxCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GotoSpawn implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        String prefix = PokeboxCommands.prefix;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players may use this command.)");
            return true;
        }

        Player player = (Player) sender;
        boolean hasUsePerms = player.hasPermission("pokeboxmc.setspawn.use");

        if (hasUsePerms) {
        player.performCommand("warp spawn");
        player.sendMessage(prefix + ChatColor.GREEN + "Teleported to spawn!");

        } else {
            player.sendMessage(ChatColor.RED + "You are not allowed to use this command!");
        }
        return true;


    }
}
