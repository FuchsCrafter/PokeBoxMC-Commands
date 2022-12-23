package de.fuchscrafter.pokeboxmc.pokeboxcommands.commands;

import de.fuchscrafter.pokeboxmc.pokeboxcommands.PokeboxCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetVersion implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        PokeboxCommands instance = PokeboxCommands.getInstance();
        String prefix = PokeboxCommands.prefix;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Plugin version:" + instance.getConfig().getString("plugin-version"));

        } else {
            sender.sendMessage(prefix + ChatColor.GREEN + "Plugin version:" + instance.getConfig().getString("plugin-version"));

        }


        return true;
    }
}
