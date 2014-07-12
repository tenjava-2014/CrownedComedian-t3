package com.tenjava.entries.CrownedComedian.t3;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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
		Bukkit.getServer().getPluginManager().registerEvents(new EntityListener(this), this);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new BukkitRunnable() {
			
			@Override
			public void run() {
				
			}
		}, 20 * 1);
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
