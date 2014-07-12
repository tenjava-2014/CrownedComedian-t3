package com.tenjava.entries.CrownedComedian.t3;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.tenjava.entries.CrownedComedian.t3.commands.CommandHandler;
import com.tenjava.entries.CrownedComedian.t3.eventListeners.BlockListener;
import com.tenjava.entries.CrownedComedian.t3.eventListeners.EntityListener;
import com.tenjava.entries.CrownedComedian.t3.eventListeners.PlayerListener;

public class TenJava extends JavaPlugin {
	
	/*				TODO
	 * ADD	permissions
	 * ADD	commands!!!
	 * ADD	toggleEventListener
	 * ADD	creeper hiss
	 * ADD	signs spawn
	 * ADD	fire spawn
	 * ADD	indev. removal
	 * ADD	health removal
	 * ADD	other?
	 * ADD	Herobrine?
	 * TST	CavePermission + Cmd
	 * TST	plugin.yml
	 */
	
	private FileConfiguration playerConfig = null;
	private File playerConfigFile = null;
	
	
	/*
	 * The following three methods are from the Bukkit wiki found here:
	 * http://wiki.bukkit.org/Configuration_API_Reference
	 * 
	 * I have just altered them a little  :D
	 */
	public void reloadPlayerConfig(String playername) {
	    if (playerConfigFile == null) {
	    playerConfigFile = new File(getDataFolder(), playername + ".yml");
	    }
	    playerConfig = YamlConfiguration.loadConfiguration(playerConfigFile);
	 
	    // Look for defaults in the jar
	    Reader defConfigStream = null;
		try {
			defConfigStream = new InputStreamReader(this.getResource(playername + ".yml"), "UTF8");
		} catch (UnsupportedEncodingException e) {}
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        playerConfig.setDefaults(defConfig);
	    }
	}
	
	public FileConfiguration getPlayerConfig(String playername) {
	    if (playerConfig == null) {
	        reloadPlayerConfig(playername);
	    }
	    return playerConfig;
	}
	
	public void savePlayerConfig(String playername) {
	    if (playerConfig == null || playerConfigFile == null) {
	        return;
	    }
	    try {
	        getPlayerConfig(playername).save(playerConfigFile);
	    } catch (IOException ex) {
	        getLogger().log(Level.SEVERE, "Could not save config to " + playerConfigFile, ex);
	    }
	}
	
	
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
		Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityListener(this), this);
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		return new CommandHandler(this, sender, command, label, args).result();
	}
	
	@SuppressWarnings("unused")
	private void newRandom(long maxTime, final Event e) {
		final long rand = (long) (Math.random() * maxTime);
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new BukkitRunnable() {
			
			@Override
			public void run() {
				Bukkit.getPluginManager().callEvent(e);
				//newRandom(rand, new SignSpawnEvent(new Location()));  // <-- working on it
			}
		}, rand);
	}
}
