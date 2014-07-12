package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class ToggleHealthRemoval implements CommandAnswerable {
	
	private TenJava plugin;
	private boolean answer;
	
	public ToggleHealthRemoval(Player p, TenJava main, CommandSender sender, Command command, String label, String[] args) {
		this.plugin = main;
		
		if(plugin.getPlayerConfig(p.getName()).getBoolean("healthRemovable")) {
			plugin.getPlayerConfig(p.getName()).set("healthRemovable", false);
			sender.sendMessage(ChatColor.GREEN + "" + p.getName() + " feel's heathier now");
		} else {
			plugin.getPlayerConfig(p.getName()).set("healthRemovable", true);
			sender.sendMessage(ChatColor.GREEN + "" + p.getName() + " is withering away");
		}
		
		answer = true;
	}
	
	public boolean result() {
		return answer;
	}
}
