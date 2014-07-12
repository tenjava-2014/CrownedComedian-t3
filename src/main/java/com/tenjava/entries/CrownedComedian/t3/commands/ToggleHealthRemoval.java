package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class ToggleHealthRemoval implements CommandAnswerable {
	
	private TenJava plugin;
	
	public ToggleHealthRemoval(Player p, TenJava main, CommandSender sender, Command command, String label, String[] args) {
		
		if(plugin.getPlayerConfig()) {
			
		}
	}
	
	public boolean result() {
		return false;
	}
}
