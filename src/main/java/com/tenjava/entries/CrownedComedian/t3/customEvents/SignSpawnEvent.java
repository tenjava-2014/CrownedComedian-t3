package com.tenjava.entries.CrownedComedian.t3.customEvents;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class SignSpawnEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	private Plugin plugin;
	
	
	public SignSpawnEvent(Location toSign, Plugin main) {
		this.plugin = main;
		
		toSign.getBlock().setType(Material.SIGN_POST);
		Sign s = (Sign) toSign.getBlock().getState();
		// add signText
		
		long next = (long) Math.random() * 100;  // <-- increase this
		TenJava paradox = (TenJava) plugin;
		Bukkit.getScheduler().runTaskLater(paradox, paradox.getRunSigns(), next);
	}
	
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
	    return handlers;
	}
}
