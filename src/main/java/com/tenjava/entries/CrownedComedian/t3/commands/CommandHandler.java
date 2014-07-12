package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class CommandHandler {
	
	private TenJava plugin;
	private boolean answer;
	
	public CommandHandler(TenJava main, CommandSender sender, Command command, String label, String[] args) {
		this.plugin = main;
		
		if(command.getName().equalsIgnoreCase("SpookyEvents")) {
			
			if(args.length == 0) {
				answer = false;
				return;
			} else if(args.length == 1) {
				
			} else if(args.length == 2) {
				
			}
		}
	}
	
	public boolean result() {
		return answer;
	}
}
