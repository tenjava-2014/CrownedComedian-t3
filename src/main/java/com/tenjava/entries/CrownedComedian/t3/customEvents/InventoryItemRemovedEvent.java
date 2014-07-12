package com.tenjava.entries.CrownedComedian.t3.customEvents;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class InventoryItemRemovedEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	private Inventory inv;
	private ItemStack gone;
	private TenJava plugin;
	
	public InventoryItemRemovedEvent(Inventory i, TenJava main) {
		this.plugin = main;
		
		if(i.getViewers().size() == 0) {
			
			if(i.getType().equals(InventoryType.PLAYER)) {
				
				for(OfflinePlayer p : Bukkit.getOfflinePlayers()) {
					
					if(p.getPlayer().getInventory() == i && plugin.getPlayerConfig(p.getPlayer().getName()).getBoolean("inventoryItemsRemovable")) {
						int randItemSlot = (int) Math.random() * 36;  // Player have 36 slots
						ItemStack before = i.getItem(randItemSlot);
						int randAmount = (int) Math.random() * before.getAmount();  // determine how much
						ItemStack replace = new ItemStack(before.getType(), randAmount, before.getDurability());
					}
				}
			}
		}
	}
	
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
	    return handlers;
	}
}
