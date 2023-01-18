package de.fuchscrafter.pokeboxmc.pokeboxcommands.commands;

import de.fuchscrafter.pokeboxmc.pokeboxcommands.PokeboxCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetVersion implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        String prefix = PokeboxCommands.prefix;

        if (!(sender instanceof Player)) {
            sender.sendMessage(prefix + ChatColor.RED + "Plugin Version: " + ChatColor.GREEN + PokeboxCommands.version);

        } else {
            sender.sendMessage(prefix + ChatColor.RED + "Plugin Version: " + ChatColor.GREEN + PokeboxCommands.version);

        }


        return true;
    }
}
