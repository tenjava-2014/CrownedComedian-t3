package com.tenjava.entries.CrownedComedian.t3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.tenjava.entries.CrownedComedian.t3.commands.CommandHandler;
import com.tenjava.entries.CrownedComedian.t3.customEvents.SignSpawnEvent;
import com.tenjava.entries.CrownedComedian.t3.eventListeners.BlockListener;
import com.tenjava.entries.CrownedComedian.t3.eventListeners.EntityListener;
import com.tenjava.entries.CrownedComedian.t3.eventListeners.PlayerListener;

public class TenJava extends JavaPlugin {
	
	/*				TODO
	 * ADD	permissions
	 * ADD	commands!!!
	 * ADD	commandTab  <-- I almost forgot this one
	 * ADD	toggleEventListener
	 * FIN	signs spawn
	 * FIN	fire spawn
	 * FIN	indev. removal
	 * FIN	health removal
	 * ADD	other?
	 * ADD	Endermen stare in End?
	 * ADD	world specification to signspawn + firespawn
	 * REMOVED	Herobrine
	 */
	
	private FileConfiguration playerConfig = null;
	private File playerConfigFile = null;
	private HashMap<String, BukkitRunnable> runners = new HashMap<String, BukkitRunnable>();
	private BukkitRunnable runSigns = new BukkitRunnable() {
		
		
		
		public void run() {
			
			for(Entity e : Bukkit.getWorlds().get(0).getEntities()) {
				Location l;
				
				do {
					int x = (int) Math.random() * 20;
					int y = (int) Math.random() * 20;
					int z = (int) Math.random() * 20;
					l = e.getLocation().add(x, y, z);
				} while (!l.getBlock().getType().equals(Material.AIR) & !l.getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.AIR));  // check if it is on the ground
				
				Bukkit.getPluginManager().callEvent(new SignSpawnEvent(l, Bukkit.getPluginManager().getPlugin("CrownedComedian-t3")));
			}
		}
	};
	
	
	/*
	 * The following three methods are from the Bukkit wiki found here:
	 * http://wiki.bukkit.org/Configuration_API_Reference
	 * 
	 * I have just altered them a little  :D
	 */
	@SuppressWarnings("deprecation")
	public void reloadPlayerConfig(String playername) {
	    if (playerConfigFile == null) {
	    playerConfigFile = new File(getDataFolder(), playername + ".yml");
	    }
	    playerConfig = YamlConfiguration.loadConfiguration(playerConfigFile);
	    
	    InputStream defConfigStream = null;
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
		Bukkit.getPluginManager().registerEvents(new BlockListener(this), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityListener(this), this);
		
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		return new CommandHandler(this, sender, command, label, args).result();  // <-- brace yourself
	}
	
	
	public BukkitRunnable getRunSigns() {
		return runSigns;
	}
}
