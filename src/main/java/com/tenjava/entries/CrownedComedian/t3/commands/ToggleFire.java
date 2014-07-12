package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class ToggleFire implements CommandAnswerable {
	
	private TenJava plugin;
	private boolean answer;
	
	public ToggleFire(TenJava main, CommandSender sender, Command command, String label, String[] args) {
		this.plugin = main;
		
		if(plugin.getConfig().getBoolean("spawnFire")) {
			plugin.getConfig().set("spawnFire", false);
			sender.sendMessage(ChatColor.GREEN + "are you a fireman?");
		} else {
			plugin.getConfig().set("spawnFire", true);
			sender.sendMessage(ChatColor.GREEN + "\"We didn't start the fire...\"");
		}
		
		answer = true;
	}
	
	public boolean result() {
		return answer;
	}
	
	
}
