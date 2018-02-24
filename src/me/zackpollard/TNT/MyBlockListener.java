package me.zackpollard.TNT;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MyBlockListener implements Listener {
	public static TnT plugin;
	public static Material[] placedBlacklist = {Material.TNT};
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public MyBlockListener(TnT instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler(ignoreCancelled = true)
	public void onBlockPlace(BlockPlaceEvent event){
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		if(!player.hasPermission("tnt.place")){
			if (block == Material.TNT){
				logger.info("[TnT] " + player.getDisplayName() + " tried to place " + event.getBlock().getType());
				event.setCancelled(true);
				player.sendMessage(ChatColor.RED + "[TnT]" + ChatColor.YELLOW + " You aren't allowed to place TnT here " + player.getDisplayName() + ". Please contact an admin");
				for (Player p : event.getPlayer().getServer().getOnlinePlayers()){
					if(p.hasPermission("tnt.alert")){
						p.sendMessage(ChatColor.RED + "[TnT] " + ChatColor.YELLOW + player.getDisplayName() + ChatColor.WHITE + " tried to place " + event.getBlock().getType());
					}
				}
			}
		}
	}
}