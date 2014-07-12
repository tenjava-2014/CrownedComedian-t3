package com.tenjava.entries.CrownedComedian.t3.customEvents;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SignSpawnEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	
	
	public SignSpawnEvent(Location toSign) {
		toSign.getBlock().setType(Material.SIGN_POST);
		Sign s = (Sign) toSign.getBlock().getState();
		
	}
	
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
	    return handlers;
	}
}
