package com.tenjava.entries.CrownedComedian.t3.events;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		
		if(Math.random() <= 0.2 && e.getPlayer().getLocation().getBlockY() <= 30) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.AMBIENCE_CAVE, 1f, 1f);
		}
	}
}
