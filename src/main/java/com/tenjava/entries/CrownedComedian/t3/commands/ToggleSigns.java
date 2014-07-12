package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class ToggleSigns implements CommandAnswerable {
	
	private TenJava plugin;
	private boolean answer;
	
	public ToggleSigns(TenJava main, CommandSender sender, Command command, String label, String[] args) {
		this.plugin = main;
		
		if(plugin.getConfig().getBoolean("spawnSigns")) {
			plugin.getConfig().set("spawnSigns", false);
			sender.sendMessage(ChatColor.GREEN + "Signs will no longer invade your world...");
		} else {
			plugin.getConfig().set("spawnSigns", true);
			sender.sendMessage(ChatColor.GREEN + "Signs will now spawn in your world");
		}
	}
	
	public boolean result() {
		
		return false;
	}
}
