package me.cedi.setsunny;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SetSunnyCore extends JavaPlugin {
	
	private SunCommandExecutor sunExecutor;
	private RainCommandExecutor rainExecutor;
	private StormCommandExecutor stormExecutor;
	
	public void onDisable() {
		System.out.println(getDescription().getName() + " v" + getDescription().getVersion() + " Disabled!");
	}

	public void onEnable() {
		System.out.println(getDescription().getName() + " v" + getDescription().getVersion() + " Enabled!");
		
		this.sunExecutor = new SunCommandExecutor(this);
		this.rainExecutor = new RainCommandExecutor(this);
		this.stormExecutor = new StormCommandExecutor(this);
		
		this.getCommand("sun").setExecutor(sunExecutor);
		this.getCommand("rain").setExecutor(rainExecutor);
		this.getCommand("storm").setExecutor(stormExecutor);
		
		final FileConfiguration config = this.getConfig();
		config.options().header("Change this value for the default duration of the '/sun', '/rain' or '/storm' commands.");
		config.addDefault("DEFAULT_DURATION", 1000000);
		config.options().copyDefaults(true);
		saveConfig();
	}

}