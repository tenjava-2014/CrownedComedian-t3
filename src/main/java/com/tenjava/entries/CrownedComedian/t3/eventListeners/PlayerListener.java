package com.tenjava.entries.CrownedComedian.t3.eventListeners;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class PlayerListener implements Listener {
	
	private TenJava plugin;
	
	public PlayerListener(TenJava main) {
		this.plugin = main;
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
		}
	}
}
