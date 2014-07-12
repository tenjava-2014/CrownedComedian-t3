package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class ToggleCaveBombs implements CommandAnswerable {

	private TenJava plugin;
	private boolean answer;
	
	public ToggleCaveBombs(Player p, TenJava main, CommandSender sender, Command command, String label, String[] args) {
		this.plugin = main;
		
		if(p == null) {  // if the args.lenght == 1
			
		} else {  // the args.lenght must be 2
			
		}
	}
		
	
	public boolean result() {
		return answer;
	}

}
