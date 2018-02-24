package me.zackpollard.TNT;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class TnT extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public void onDisable() {
		this.logger.info("TnT version 0.1 is now disabled");
	}
	public void onEnable() {
		new MyTnTListener(this);
		new MyBlockListener(this);
//		final FileConfiguration config = this.getConfig();
//        config.addDefault("AntiGrief.Explosion.TntExplosionBlocking", true);
//        String[] tntignoredworlds = {"world1", "world2", "world3"};
//        config.addDefault("AntiGrief.Explosion.IgnoredWorlds.TntExplosionBlocking", Arrays.asList(tntignoredworlds));
//        config.options().copyDefaults(true);
//        saveConfig();
		this.logger.info("TnT version 0.1 is enabled");
	}
}