package com.tenjava.entries.CrownedComedian.t3;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.CrownedComedian.t3.events.BlockListener;
import com.tenjava.entries.CrownedComedian.t3.events.PlayerListener;

public class TenJava extends JavaPlugin {
	
	/*				TODO
	 * TST	Giants to nether
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
		//other events???
	}
}
