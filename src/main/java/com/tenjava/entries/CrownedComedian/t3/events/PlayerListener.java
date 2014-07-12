package com.tenjava.entries.CrownedComedian.t3.events;

import org.bukkit.World.Environment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		double percent = Math.random();
		
		if(e.getPlayer().getLocation().getBlockY() <= 35) {
			
			if(percent <= 0.01) {
				
			}
		}
	}
}
