package me.cedi.setsunny;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

@EventHandler
public class RainCommandExecutor implements CommandExecutor{
	
	SetSunnyCore plugin;
	
	RainCommandExecutor(SetSunnyCore instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
//onCommand(start)-------------------------------------------------		
		
		if (sender instanceof ConsoleCommandSender){
			
//If ConsoleCommandSender(start)-----------------------------------	
	
			//If there are less than 1 arguments after "/rain"
			if(args.length < 1){
			
				sender.sendMessage("Not enough arguments.");
				sender.sendMessage("Correct usage is: /rain [world] [duration]");
			
			}
		
//-----------------------------------------------------------------
		
			//If there is 1 argument after "/rain"
			else if(args.length == 1){
			
				World w = sender.getServer().getWorld(args[0]);
			
				if (w == null){
					sender.sendMessage("The world '" + args[0] + "' doesn't exist.");
					return true;
				}
			
				w.setThundering(false);
				w.setStorm(true);
				w.setWeatherDuration(plugin.getConfig().getInt("DEFAULT_DURATION"));
				sender.sendMessage("Weather set to rainy in " + args[0]);
		
			}
		
//-----------------------------------------------------------------		
		
			//If there are 2 arguments after "/rain"
			else if(args.length == 2){
				
				World w = sender.getServer().getWorld(args[0]);
				
				if (w == null){
					sender.sendMessage("The world '" + args[0] + "' doesn't exist.");
					return true;
				}
					
				w.setThundering(false);
				w.setStorm(true);
				w.setWeatherDuration(Integer.parseInt(args[1]));
				sender.sendMessage("Weather set to rainy in " + args[0] + " for " + args[1] + " ticks.");
					
			}
		
//-----------------------------------------------------------------		
		
			//If there are more than 2 arguments after "/rain"
			else if(args.length > 2){
				
				sender.sendMessage("Too many arguments.");
				sender.sendMessage("Correct usage is: /rain [world] [duration]");
				
			}

//If ConsoleCommandSender(end)-------------------------------------
		}
		
		//If the sender is a player
		else if(sender instanceof Player){
			
//If Player(start)-------------------------------------------------			

			//If there are less than 1 arguments after "/rain"
			if(args.length < 1 && (sender.hasPermission("SetSunny.local.rain") || sender.hasPermission("SetSunny.local") || sender.hasPermission("SetSunny.*") || sender.isOp())){
				
				Player p = (Player)sender;
				World world = p.getWorld();
				
				world.setThundering(false);
				world.setStorm(true);
				world.setWeatherDuration(plugin.getConfig().getInt("DEFAULT_DURATION"));
				sender.sendMessage(ChatColor.AQUA + "Weather set to rainy in " + ChatColor.GREEN + world.getName());
				
			}
		
//-----------------------------------------------------------------
		
			//If there is 1 argument after "/rain"
			else if(args.length == 1 && (sender.hasPermission("SetSunny.world.rain") || sender.hasPermission("SetSunny.world") || sender.hasPermission("SetSunny.*") || sender.isOp())){
			
				World world = sender.getServer().getWorld(args[0]);
			
				if (world == null){
					sender.sendMessage(ChatColor.RED + "The world '" + args[0] + "' doesn't exist.");
					return true;
				}
			
				world.setThundering(false);
				world.setStorm(true);
				world.setWeatherDuration(plugin.getConfig().getInt("DEFAULT_DURATION"));
				sender.sendMessage(ChatColor.AQUA + "Weather set to rainy in " + ChatColor.GREEN + args[0]);
		
			}
		
//-----------------------------------------------------------------		
		
			//If there are 2 arguments after "/rain"
			else if(args.length == 2 && (sender.hasPermission("SetSunny.world.rain") || sender.hasPermission("SetSunny.world") || sender.hasPermission("SetSunny.*") || sender.isOp())){
				
				World world = sender.getServer().getWorld(args[0]);
				
				if (world == null){
					sender.sendMessage(ChatColor.RED + "The world '" + args[0] + "' doesn't exist.");
					return true;
				}
					
				world.setThundering(false);
				world.setStorm(true);
				world.setWeatherDuration(Integer.parseInt(args[1]));
				sender.sendMessage(ChatColor.AQUA + "Weather set to rainy in " + ChatColor.GREEN + args[0] + ChatColor.AQUA + " for " + ChatColor.GREEN + args[1] + ChatColor.AQUA + " ticks.");
					
			}
		
//-----------------------------------------------------------------		
		
			//If there are more than 2 arguments after "/rain"
			else if(args.length > 2){
				
				sender.sendMessage(ChatColor.RED + "Too many arguments.");
				sender.sendMessage(ChatColor.RED + "Correct usage is: /rain [world] [duration]");
				
			}
			
//If Player(end)---------------------------------------------------			

		}
		
//onCommand(end)---------------------------------------------------
		
		return true;
	}
}
