package com.tenjava.entries.CrownedComedian.t3.eventListeners;

import org.bukkit.Sound;
import org.bukkit.World.Environment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		double percent = Math.random();
		
		if(e.getPlayer().getLocation().getBlockY() <= 30 && e.getPlayer().getWorld().getEnvironment() == Environment.NORMAL) {
			
			if(percent <= 0.08) {
				double x = Math.random() * 20;
				double y = Math.random() * 20;
				double z = Math.random() * 20;
				e.getPlayer().playSound(e.getPlayer().getLocation().add(x, y, z), Sound.EXPLODE, 1f, 1f);
			}
		}
	}
}
