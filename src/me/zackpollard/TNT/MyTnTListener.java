package me.zackpollard.TNT;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MyTnTListener implements Listener {
	public static TnT plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	public int i = 0;
	public int j = 0;
	public int k = 0;
	public MyTnTListener(TnT instance){
		plugin = instance;
		Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	} 
	@EventHandler(ignoreCancelled = true)
	public void onPlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		int item = player.getItemInHand().getTypeId();
		if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)){
			return;
		}
		
		if(player.hasPermission("tnt.bypass")){
			return;
		}
		
		if (item == 259 || item == 51 || item == 385){
			if (event.getClickedBlock().getTypeId() == 46){
				event.setCancelled(true);
				player.sendMessage(ChatColor.RED + "[TnT Blocker]" + ChatColor.YELLOW + "You are not allowed to explode TnT here. Please contact an admin");
				return;
			}
		}
		
		if(item == 76 || item == 55 || item == 331 || item == 356 || item == 69 || item == 77 || item == 75 || item == 73 || item == 74 || item == 259 || item == 51 || item == 385){
			for (i = -3; i <= 3; i++){
			    for (j = -3; j <= 3; j++) {
			        for (k = -3; k <= 3; k++) {
			        	int block = event.getClickedBlock().getRelative(i, j, k).getTypeId();
			            if (block == 46) {
							player.sendMessage(ChatColor.RED + "[TnT Blocker]" + ChatColor.YELLOW + "You are not allowed to place this item near TnT. Please contact an admin");
							event.setCancelled(true);
							player.sendMessage("Relative Co-Ords " + i + "," + j + "," + k);
			            }
			        }
			    }
			}
		}
		
		if(item == 46){
			for (i = -3; i <= 3; i++){
			    for (j = -3; j <= 3; j++) {
			        for (k = -3; k <= 3; k++) {
			        	int block = event.getClickedBlock().getRelative(i, j, k).getTypeId();
			            if (block == 76 || block == 55 || block == 331 || block == 356 || block == 69 || block == 77 || block == 75 || block == 73 || block == 74 || block == 259 || block == 51 || block == 385) {
							player.sendMessage(ChatColor.YELLOW + "You are not allowed to place TnT near redstone here. Please contact an admin");
							event.setCancelled(true);
							player.sendMessage("Relative Co-Ords " + i + "," + j + "," + k);
			            }
			        }
			    }
			}
		}
	}
}