package de.fuchscrafter.pokeboxmc.pokeboxcommands;

import de.fuchscrafter.pokeboxmc.pokeboxcommands.commands.Announce;
import de.fuchscrafter.pokeboxmc.pokeboxcommands.commands.DiscordLink;
import de.fuchscrafter.pokeboxmc.pokeboxcommands.commands.GetVersion;
import de.fuchscrafter.pokeboxmc.pokeboxcommands.commands.GotoSpawn;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public final class PokeboxCommands extends JavaPlugin {
    private static PokeboxCommands instance;

    public static final String prefix = ChatColor.BLUE + "[PokeBoxMC]" + ChatColor.RESET + " ";

    public static final String version = "1.2";



    @Override
    public void onEnable() {
        instance = this;

        instance.saveDefaultConfig();

        Objects.requireNonNull(this.getCommand("Spawn")).setExecutor(new GotoSpawn());
        Objects.requireNonNull(this.getCommand("Discord")).setExecutor(new DiscordLink());
        Objects.requireNonNull(this.getCommand("Pokeboxplugin")).setExecutor(new GetVersion());
        Objects.requireNonNull(this.getCommand("Announce")).setExecutor(new Announce());


        getLogger().info("----PokeboxCommands----");

        getLogger().info("Welcome to PokeBoxCommands by FuchsCoder.");

        getLogger().info("PLUGIN VERSION: "+ version);

        getLogger().info("API-VERSION: For Minecraft BukkitAPI/Paper 1.17");

        getLogger().info("PLUGIN CONFIG VERSION:" + this.getConfig().getInt("version"));

        getLogger().info("-----------------------");

    }

    @Override
    public void onDisable() {
        getLogger().info("Goodbye!");
    }

    public static PokeboxCommands getInstance() {
        return instance;
    }
}
