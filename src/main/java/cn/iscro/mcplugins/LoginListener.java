package cn.iscro.mcplugins;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;
import cn.iscro.mcplugins.LoginWelcome;

public class LoginListener implements Listener {
    @EventHandler
    public void OnPlayerChat(PlayerChatEvent e){
        if(e.getMessage().substring(0,1).equals("/"))
            return;
        e.setCancelled(needCancelled(e.getPlayer().getName()));
    }
    @EventHandler
    public void OnPlayerMove(PlayerMoveEvent e){
        e.setCancelled(needCancelled(e.getPlayer().getName()));
    }
    private boolean needCancelled(String PlayerName){
        return  !LoginWelcome.isLogin(PlayerName);
    }

}
