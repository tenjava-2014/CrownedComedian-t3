package com.tenjava.entries.CrownedComedian.t3.eventListeners;

import org.bukkit.Sound;
import org.bukkit.World.Environment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class BlockListener implements Listener {
	
	TenJava plugin;
	
	public BlockListener(TenJava main) {
		this.plugin = main;
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		double percent = Math.random();
		
		if(e.getPlayer().getLocation().getBlockY() <= 30
				&& e.getPlayer().getWorld().getEnvironment() == Environment.NORMAL
				&& plugin.getPlayerConfig(e.getPlayer().getName()).getBoolean("caveBombs")) {
			
			if(percent <= 0.08) {
				double x = Math.random() * 20;
				double y = Math.random() * 20;
				double z = Math.random() * 20;
				e.getPlayer().playSound(e.getPlayer().getLocation().add(x, y, z), Sound.EXPLODE, 1f, 1f);
			}
		}
	}
}
