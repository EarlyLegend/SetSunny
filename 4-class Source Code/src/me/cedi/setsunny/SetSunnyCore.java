package me.cedi.setsunny;

import org.bukkit.plugin.java.JavaPlugin;

public class SetSunnyCore extends JavaPlugin {
	
	private SunCommandExecutor sunExecutor;
	private RainCommandExecutor rainExecutor;
	private StormCommandExecutor stormExecutor;
	
	public void onDisable() {
		System.out.println("[SetSunny] v" + getDescription().getVersion() + " Disabled!");
	}

	public void onEnable() {
		System.out.println("[SetSunny] v" + getDescription().getVersion() + " Enabled!");
		
		this.sunExecutor = new SunCommandExecutor();
		this.rainExecutor = new RainCommandExecutor();
		this.stormExecutor = new StormCommandExecutor();
		
		this.getCommand("sun").setExecutor(sunExecutor);
		this.getCommand("rain").setExecutor(rainExecutor);
		this.getCommand("storm").setExecutor(stormExecutor);
		
	}

}