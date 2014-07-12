package com.tenjava.entries.CrownedComedian.t3;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.tenjava.entries.CrownedComedian.t3.events.BlockListener;
import com.tenjava.entries.CrownedComedian.t3.events.PlayerListener;

public class TenJava extends JavaPlugin {
	
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		Bukkit.getPluginManager().registerEvents(new BlockListener(), this);
	}
}
