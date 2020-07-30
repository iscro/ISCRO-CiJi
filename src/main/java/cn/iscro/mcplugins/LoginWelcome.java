package cn.iscro.mcplugins;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;

public class LoginWelcome{
    private static List<String> UnloginList = new ArrayList<>();
    public static boolean isLogin(String PlayerName){
        return !UnloginList.contains(PlayerName);
    }
    public static void SetPlayerLogin(String PlayerName,boolean Flag){
        if(Flag){
            UnloginList.remove(PlayerName);
            return;
        } else {
            UnloginList.add(PlayerName);
            return;
        }
    }
    public static boolean isRegister(String PlayerName){
        return CiJi.instance.getConfig().contains("player_data." + PlayerName);
    }
    public static boolean Register(String PlayerName,String Password){
        if(isRegister(PlayerName))
            return false;
        CiJi.instance.getConfig().set("player_data." + PlayerName + ".password",Password);
        CiJi.instance.saveConfig();
        return true;
    }
    public static boolean isCorrectPassword(String PlayerName,String Password){
        if(!isRegister(PlayerName))
            return false;
        String pass = CiJi.instance.getConfig().getString("player_data." + PlayerName + ".password");
        return pass.equals(Password);
    }
}