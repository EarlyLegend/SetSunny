package me.cedi.setsunny;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class setsunny extends JavaPlugin{
	public void onDisable() {
		System.out.println("SetSunny v" + getDescription().getVersion() + " Disabled!");
	}
	public void onEnable() {
		System.out.println("SetSunny v" + getDescription().getVersion() + " Enabled!");
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[]args){
		if(sender instanceof ConsoleCommandSender){
			System.out.println("Cannot run this from the console");
			return true;
		}
		Player player = (Player)sender;
		World world = player.getWorld();
		
		if(sender instanceof Player){
			if((cmd.getName().equalsIgnoreCase("w")) || (cmd.getName().equalsIgnoreCase("weather"))){
					if(args.length < 1){
						player.sendMessage(ChatColor.RED+"Not enough arguments.");
						player.sendMessage(ChatColor.RED+"Correct usage: /w [weathertype] [world]");
						}
					if(args.length == 1){
						if(args[0].equalsIgnoreCase("sun") && (player.hasPermission("SetWeather.sunny") || player.isOp())){
							world.setThundering(false);
							world.setStorm(false);
							world.setWeatherDuration(1000000);
							player.sendMessage(ChatColor.YELLOW+"Weather set to sunny.");
						}
						if(args[0].equalsIgnoreCase("rain") && (player.hasPermission("SetWeather.rainy") || player.isOp())){
							world.setThundering(false);
							world.setStorm(true);
							world.setWeatherDuration(1000000);
							player.sendMessage(ChatColor.AQUA+"Weather set to rainy.");
						}
						if(args[0].equalsIgnoreCase("storm") && (player.hasPermission("SetWeather.stormy") || player.isOp())){
							world.setThundering(true);
							world.setStorm(true);
							world.setThunderDuration(1000000);
							world.setWeatherDuration(1000000);
							player.sendMessage(ChatColor.GRAY+"Weather set to stormy");
						}
					}
					if (args.length == 2){
						World w = this.getServer().getWorld(args[1]);
						if(w == null){
							player.sendMessage("The world '" + args[1] + "' doesn't exist.");
							return true;
						}
						if(args[0].equalsIgnoreCase("sun") && (player.hasPermission("SetWeather.othersunny") || player.isOp())){
							w.setThundering(false);
							w.setStorm(false);
							w.setWeatherDuration(1000000);
							player.sendMessage(ChatColor.YELLOW+"Weather set to sunny in "+ChatColor.GREEN+w.getName());
						}
						if(args[0].equalsIgnoreCase("rain") && (player.hasPermission("SetWeather.otherrainy") || player.isOp())){
							w.setThundering(false);
							w.setStorm(true);
							w.setWeatherDuration(1000000);
							player.sendMessage(ChatColor.AQUA+"Weather set to rainy in "+ChatColor.GREEN+w.getName());
						}
						if(args[0].equalsIgnoreCase("storm") && (player.hasPermission("SetWeather.otherstormy") || player.isOp())){
							w.setThundering(true);
							w.setStorm(true);
							w.setWeatherDuration(1000000);
							w.setThunderDuration(1000000);
							player.sendMessage(ChatColor.GRAY+"Weather set to stormy in "+ChatColor.GREEN+w.getName());
							}
						}
					if(args.length > 2){
						player.sendMessage(ChatColor.RED+"Too many arguments.");
						player.sendMessage(ChatColor.RED+"Correct usage: /w [weathertype] [world]");
					}	
				}
			}
		return true;
	}
}