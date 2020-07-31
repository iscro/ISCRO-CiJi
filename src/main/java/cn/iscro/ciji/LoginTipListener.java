package cn.iscro.ciji;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.concurrent.TimeUnit;

public class LoginTipListener implements Listener {
    @EventHandler
    private void OnPlayerJoin(PlayerJoinEvent ThisEvent) throws InterruptedException {
        while (!LoginWelcome.isLogin(ThisEvent.getPlayer().getName())) {
            ThisEvent.getPlayer().sendMessage(LoginWelcome.isRegister(ThisEvent.getPlayer().getName()) ? "欢迎来到本服！请输入/l <密码>进行登录" : "欢迎来到本服！请输入/reg <密码>进行注册");
            TimeUnit.MILLISECONDS.sleep(5000);
        }
    }
}
