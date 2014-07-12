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
				
				//checked in alphabetical order by args[0]
				if(args[0].equalsIgnoreCase("toggleCaveBombs")
						&& sender instanceof Player
						&& sender.hasPermission("SpookyEvents.cmd.toggleCaveBombsSelf")) {
					
					ToggleCaveBombs cmd = new ToggleCaveBombs((Player) sender, plugin, sender, command, label, args);
					answer = cmd.result();
				} else if(args[0].equalsIgnoreCase("toggleCreeperHiss")
						&& sender instanceof Player
						&& sender.hasPermission("SpookyEvents.cmd.toggleCaveBombsSelf")) {
					
					ToggleCreeperHiss cmd = new ToggleCreeperHiss((Player) sender, plugin, sender, command, label, args);
					answer = cmd.result();
				} else if(args[0].equalsIgnoreCase("toggleHealthRemoval")) {
					sender.sendMessage(ChatColor.RED + "Too few arguments! A player name must be specified!");
					answer = false;
				} else if(args[0].equalsIgnoreCase("toggleInvetoryRemoval") && sender.hasPermission("SpookyEvents.cmd.toggleInventoryRemoval")) {
					ToggleInvetoryItemRemoval cmd = new ToggleInvetoryItemRemoval(null, plugin, sender, command, label, args);
					answer = cmd.result();
				} else if(args[0].equalsIgnoreCase("toggleSigns") && sender.hasPermission("SpookyEvents.cmd.toggleSigns")) {
					ToggleSigns cmd = new ToggleSigns(plugin, sender, command, label, args);
					answer = cmd.result();
				}
				
			} else if(args.length == 2) {
				
				//also checked in alphabetical order by args[0]
				
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
