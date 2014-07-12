package com.tenjava.entries.CrownedComedian.t3.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.tenjava.entries.CrownedComedian.t3.TenJava;

public class CommandHandler {
	
	private TenJava plugin;
	private boolean answer;
	
	public CommandHandler(TenJava main, CommandSender sender, Command command, String label, String[] args) {
		this.plugin = main;
		
		if(command.getName().equalsIgnoreCase("SpookyEvents")) {
			
			if(args.length == 0) {
				answer = false;
			} else if(args.length == 1) {
				
				if(args[0].equalsIgnoreCase("toggleCaveBombs") && sender instanceof Player && sender.hasPermission("SpookyEvents.cmd.toggleCaveBombsSelf")) {
					ToggleCaveBombs cmd = new ToggleCaveBombs((Player) sender, plugin, sender, command, label, args);
					answer = cmd.result();
				} else if(args[0].equalsIgnoreCase("toggleCreeperHiss")) {  // AND HAS PERMISSION!!!
					//answer = new ToggleCreeperHiss().result();  // <-- hold on there cowboy!
				}
				
			} else if(args.length == 2) {
				
			} else if(args.length > 2) {
				sender.sendMessage(ChatColor.RED + "Too many arguments!");
				answer = false;
			}
		}
	}
	
	public boolean result() {
		return answer;
	}
}
