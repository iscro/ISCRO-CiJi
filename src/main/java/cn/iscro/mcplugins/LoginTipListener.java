package cn.iscro.mcplugins;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LoginTipListener implements Listener {
    @EventHandler
    private void OnPlayerJoin(PlayerJoinEvent ThisEvent){
        ThisEvent.getPlayer().sendMessage(LoginWelcome.isRegister(ThisEvent.getPlayer().getName())?"欢迎来到本服！请输入/l <密码>进行登录":"欢迎来到本服！请输入/reg <密码>进行注册");
    }
}
