package cn.iscro.ciji;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class AntiExplosionSuit implements Listener {
    @EventHandler
    public void OnTNTPlace(BlockPlaceEvent ThisEvent){
        if(ThisEvent.getBlock().getType() == Material.TNT)
            ThisEvent.setCancelled(true);
    }
    @EventHandler
    public void OnCreeperExp(EntityExplodeEvent ThisEvent){
        ThisEvent.setCancelled(true);
    }
}
