package com.tenjava.entries.CrownedComedian.t3;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.CrownedComedian.t3.eventListeners.BlockListener;
import com.tenjava.entries.CrownedComedian.t3.eventListeners.EntityListener;
import com.tenjava.entries.CrownedComedian.t3.eventListeners.PlayerListener;

public class TenJava extends JavaPlugin {
	
	/*				TODO
	 * ADD	permissions
	 * ADD	commands
	 * ADD	signs spawn
	 * ADD	fire spawn
	 * ADD	indev. removal
	 * ADD	health removal
	 * ADD	other?
	 * ADD	Herobrine?
	 */
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new EntityListener(), this);
	}
}
