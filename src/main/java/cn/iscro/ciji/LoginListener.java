package cn.iscro.ciji;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;

public class LoginListener implements Listener {
    @EventHandler
    public void OnPlayerChat(PlayerChatEvent ThisEvent){
        if(ThisEvent.getMessage().substring(0,1).equals("/"))
            return;
        ThisEvent.setCancelled(needCancelled(ThisEvent.getPlayer().getName()));
    }
    @EventHandler
    public void OnPlayerMove(PlayerMoveEvent ThisEvent){
        ThisEvent.setCancelled(needCancelled(ThisEvent.getPlayer().getName()));
    }
    @EventHandler
    public void OnPlayerInteract(PlayerInteractEvent ThisEvent){
        ThisEvent.setCancelled(needCancelled(ThisEvent.getPlayer().getName()));
    }
    @EventHandler
    public void OnPlayerInventory(InventoryOpenEvent ThisEvent){
        ThisEvent.setCancelled(needCancelled(ThisEvent.getPlayer().getName()));
    }
    private boolean needCancelled(String PlayerName){
        return  !LoginWelcome.isLogin(PlayerName);
    }
    @EventHandler
    private void OnPlayerJoin(PlayerJoinEvent ThisEvent){
        LoginWelcome.SetPlayerLogin(ThisEvent.getPlayer().getName(),false);
    }
    @EventHandler
    private void OnPlayerQuit(PlayerQuitEvent ThisEvent){
        LoginWelcome.SetPlayerLogin(ThisEvent.getPlayer().getName(),false);
    }

}
