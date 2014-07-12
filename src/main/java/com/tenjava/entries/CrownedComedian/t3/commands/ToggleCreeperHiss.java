package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class ToggleCreeperHiss implements CommandAnswerable {
	
	private TenJava plugin;
	private boolean answer;
	
	public ToggleCreeperHiss(Player p, TenJava main, CommandSender sender, Command command, String label, String[] args) {
		this.plugin = main;
		
		if(plugin.getPlayerConfig(p.getName()).getBoolean("creeperHiss")) {
			plugin.getPlayerConfig(p.getName()).set("creeperHiss", false);
			sender.sendMessage(ChatColor.GREEN + "awww, you're no fun");
		} else {
			plugin.getPlayerConfig(p.getName()).set("creeperHiss", true);
			sender.sendMessage(ChatColor.GREEN + "mwaahaha");
		}
		
		answer = true;
	}

	public boolean result() {
		return answer;
	}
}
