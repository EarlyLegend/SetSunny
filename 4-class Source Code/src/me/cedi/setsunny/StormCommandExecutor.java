package me.cedi.setsunny;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class StormCommandExecutor implements CommandExecutor{
	
	SetSunnyCore plugin;
	
	StormCommandExecutor(SetSunnyCore instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
//onCommand(start)-------------------------------------------------		
		
		if (sender instanceof ConsoleCommandSender){
			
//If ConsoleCommandSender(start)-----------------------------------	
	
			//If there are less than 1 arguments after "/storm"
			if(args.length < 1){
			
				sender.sendMessage("Not enough arguments.");
				sender.sendMessage("Correct usage is: /storm [world] [duration]");
			
			}
		
//-----------------------------------------------------------------
		
			//If there is 1 argument after "/storm"
			else if(args.length == 1){
			
				World w = sender.getServer().getWorld(args[0]);
			
				if (w == null){
					sender.sendMessage("The world '" + args[0] + "' doesn't exist.");
					return true;
				}
			
				w.setThundering(true);
				w.setStorm(true);
				w.setThunderDuration(plugin.getConfig().getInt("DEFAULT_DURATION"));
				w.setWeatherDuration(plugin.getConfig().getInt("DEFAULT_DURATION"));
				sender.sendMessage("Weather set to stormy in " + args[0]);
		
			}
		
//-----------------------------------------------------------------		
		
			//If there are 2 arguments after "/storm"
			else if(args.length == 2){
				
				World w = sender.getServer().getWorld(args[0]);
				
				if (w == null){
					sender.sendMessage("The world '" + args[0] + "' doesn't exist.");
					return true;
				}
					
				w.setThundering(true);
				w.setStorm(true);
				w.setThunderDuration(Integer.parseInt(args[1]));
				w.setWeatherDuration(Integer.parseInt(args[1]));
				sender.sendMessage("Weather set to stormy in " + args[0] + " for " + args[1] + " ticks.");
					
			}
		
//-----------------------------------------------------------------		
		
			//If there are more than 2 arguments after "/storm"
			else if(args.length > 2){
				
				sender.sendMessage("Too many arguments.");
				sender.sendMessage("Correct usage is: /storm [world] [duration]");
				
			}

//If ConsoleCommandSender(end)-------------------------------------
			
		}
		
		//If the sender is a player
		else if(sender instanceof Player){
			
//If Player(start)-------------------------------------------------			

			//If there are less than 1 arguments after "/storm"
			if(args.length < 1 && (sender.hasPermission("SetSunny.local.storm") || sender.hasPermission("SetSunny.local") || sender.hasPermission("SetSunny.*") || sender.isOp())){
				
				Player p = (Player)sender;
				World world = p.getWorld();
			
				world.setThundering(true);
				world.setStorm(true);
				world.setThunderDuration(plugin.getConfig().getInt("DEFAULT_DURATION"));
				world.setWeatherDuration(plugin.getConfig().getInt("DEFAULT_DURATION"));
				sender.sendMessage(ChatColor.YELLOW + "Weather set to sunny in " + ChatColor.GREEN + world.getName());
				
			}
		
//-----------------------------------------------------------------
		
			//If there is 1 argument after "/storm"
			else if(args.length == 1 && (sender.hasPermission("SetSunny.world.rain") || sender.hasPermission("SetSunny.world") || sender.hasPermission("SetSunny.*") || sender.isOp())){
			
				World world = sender.getServer().getWorld(args[0]);
			
				if (world == null){
					sender.sendMessage(ChatColor.RED + "The world '" + args[0] + "' doesn't exist.");
					return true;
				}
			
				world.setThundering(true);
				world.setStorm(true);
				world.setThunderDuration(plugin.getConfig().getInt("DEFAULT_DURATION"));
				world.setWeatherDuration(plugin.getConfig().getInt("DEFAULT_DURATION"));
				sender.sendMessage(ChatColor.GRAY + "Weather set to stormy in " + ChatColor.GREEN + args[0]);
		
			}
		
//-----------------------------------------------------------------		
		
			//If there are 2 arguments after "/storm"
			else if(args.length == 2 && (sender.hasPermission("SetSunny.world.rain") || sender.hasPermission("SetSunny.world") || sender.hasPermission("SetSunny.*") || sender.isOp())){
				
				World world = sender.getServer().getWorld(args[0]);
				
				if (world == null){
					sender.sendMessage(ChatColor.RED + "The world '" + args[0] + "' doesn't exist.");
					return true;
				}
					
				world.setThundering(true);
				world.setStorm(true);
				world.setThunderDuration(Integer.parseInt(args[1]));
				world.setWeatherDuration(Integer.parseInt(args[1]));
				sender.sendMessage(ChatColor.GRAY + "Weather set to stormy in " + ChatColor.GREEN + args[0] + ChatColor.GRAY + " for " + ChatColor.GREEN + args[1] + ChatColor.GRAY + " ticks.");
					
			}
		
//-----------------------------------------------------------------		
		
			//If there are more than 2 arguments after "/storm"
			else if(args.length > 2){
				
				sender.sendMessage(ChatColor.RED + "Too many arguments.");
				sender.sendMessage(ChatColor.RED + "Correct usage is: /storm [world] [duration]");
				
			}
			
//If Player(end)---------------------------------------------------			

		}
		
//onCommand(end)---------------------------------------------------
		
		return true;
	}
}
