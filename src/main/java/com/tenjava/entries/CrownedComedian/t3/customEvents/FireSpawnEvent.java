package com.tenjava.entries.CrownedComedian.t3.customEvents;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FireSpawnEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	private Location fire;
	
	public FireSpawnEvent(Location toFire) {
		this.fire = toFire;
		
		fire.getBlock().setType(Material.FIRE);
	}
	
	public Location getLocation() {
		return fire;
	}
	
	public HandlerList getHandlers() {
	    return handlers;
	}
	 
	public static HandlerList getHandlerList() {
	    return handlers;
	}
}
