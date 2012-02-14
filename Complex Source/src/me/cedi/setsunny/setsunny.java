package me.cedi.setsunny;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
			
			if(sender instanceof Player){
				World w = ((Player) sender).getWorld();
				if(cmd.getName().equalsIgnoreCase("setsunny") && (sender.hasPermission("SetWeather.sunny") || sender.isOp())){
					w.setThundering(false);
					w.setStorm(false);
					w.setWeatherDuration(1000000);
					sender.sendMessage("Weather set to sunny.");
					return true;
				}
				if(cmd.getName().equalsIgnoreCase("setstormy") && (sender.hasPermission("SetWeather.stormy") || sender.isOp())){
					w.setThundering(true);
					w.setStorm(true);
					w.setWeatherDuration(1000000);
					sender.sendMessage("Weather set to stormy.");
					return true;
				}
				if(cmd.getName().equalsIgnoreCase("setrainy") && (sender.hasPermission("SetWeather.rainy") || sender.isOp())){
					w.setThundering(false);
					w.setStorm(true);
					w.setWeatherDuration(1000000);
					sender.sendMessage("Weather set to rainy.");
					return true;
				}
			}
			return false;
	}
}