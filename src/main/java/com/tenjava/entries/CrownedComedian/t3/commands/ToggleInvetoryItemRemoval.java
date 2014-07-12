package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class ToggleInvetoryItemRemoval implements CommandAnswerable {
	
	private TenJava plugin;
	private boolean answer;

	public ToggleInvetoryItemRemoval(Player p, TenJava main, CommandSender sender, Command command, String label, String[] args) {
		this.plugin = main;
		
		if(p == null) {
			//stop all non-player inventories
			
		} else {
			
			if(plugin.getPlayerConfig(p.getName()).getBoolean("inventoryItemsRemovable")) {
				plugin.getPlayerConfig(p.getName()).set("inventoryItemsRemovable", false);
				sender.sendMessage(ChatColor.GREEN + "but, but, but.... why not?");
			} else {
				plugin.getPlayerConfig(p.getName()).set("inventoryItemsRemovable", true);
				sender.sendMessage(ChatColor.GREEN + "what the- what happened?");
			}
		}
		
		answer = true;
	}

	public boolean result() {
		return answer;
	}
}
