package com.tenjava.entries.CrownedComedian.t3.eventListeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class PlayerListener implements Listener {
	
	private TenJava plugin;
	
	public PlayerListener(TenJava main) {
		this.plugin = main;
	}
	
	@EventHandler
	public void onPlayerLogin(final PlayerLoginEvent e) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new BukkitRunnable() {
			
			@Override
			public void run() {
				plugin.getPlayerConfig(e.getPlayer().getName()).addDefault("caveBombs", true);
				plugin.getPlayerConfig(e.getPlayer().getName()).addDefault("creeperHiss", true);
				plugin.getPlayerConfig(e.getPlayer().getName()).addDefault("heathRemoval", true);
				plugin.getPlayerConfig(e.getPlayer().getName()).addDefault("inventoryItemRemoval", true);
			}
		}, 20 * 1);  //1 second delay to finish event
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		double percent = Math.random();
		
		if(e.getPlayer().getLocation().getBlockY() <= 35) {  // underground-ish
			
			if(percent <= 0.01) {  // 1%
				
				if(percent <= 0.08) {
					double x = Math.random() * 20;
					double y = Math.random() * 20;
					double z = Math.random() * 20;
					e.getPlayer().playSound(e.getPlayer().getLocation().add(x, y, z), Sound.EXPLODE, 1f, 1f);
				}
			}
		} else {  // not underground-ish
			
		}
	}
}
