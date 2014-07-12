package com.tenjava.entries.CrownedComedian.t3.eventListeners;

import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class EntityListener implements Listener {
	
	private TenJava plugin;
	
	public EntityListener(TenJava main) {
		this.plugin = main;
	}

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		
		if(e.getEntity().getWorld().getEnvironment() == Environment.NETHER) {
			
			if(e.getEntityType() == EntityType.PIG_ZOMBIE) {
				boolean canSpawn = true;
				
				for(int i = 0; i < 12; i++) {  // giants are 12 blocks tall
					Block isAir = e.getEntity().getLocation().getBlock().getRelative(0, i, 0);
					
					if(!isAir.getType().equals(Material.AIR)) {
						canSpawn = false;
					}
				}
				
				if(canSpawn && plugin.getConfig().getBoolean("spawnGiant")) {
					double percent = Math.random();
					
					if(percent <= 0.1) {
						e.getEntity().getWorld().spawnEntity(e.getLocation(), EntityType.GIANT);
						e.getEntity().remove();
					}
				}
			}
		}
	}
}
