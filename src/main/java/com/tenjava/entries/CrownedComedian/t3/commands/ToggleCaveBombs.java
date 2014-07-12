package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class ToggleCaveBombs implements CommandAnswerable {

	private TenJava plugin;
	private boolean answer;
	
	public ToggleCaveBombs(Player p, TenJava main, CommandSender sender, Command command, String label, String[] args) {
		this.plugin = main;

		if(plugin.getPlayerConfig(sender.getName()).getBoolean("caveBombs")) {
			plugin.getPlayerConfig(sender.getName()).set("caveBombs", false);
			sender.sendMessage(ChatColor.GREEN + "" + p.getName() + " can now sleep peacefully");
		} else {
			plugin.getPlayerConfig(sender.getName()).set("caveBombs", true);
			sender.sendMessage(ChatColor.GREEN + "" + p.getName() + " won't know what hit him");
		}
		
		plugin.savePlayerConfig(p.getName());
		answer = true;
	}
		
	
	public boolean result() {
		return answer;
	}

}
