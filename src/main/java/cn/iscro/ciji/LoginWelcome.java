package cn.iscro.ciji;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;

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
            Bukkit.getPlayerExact(PlayerName).setGameMode(Bukkit.getDefaultGameMode());
            while (UnloginList.contains(PlayerName)) {
            UnloginList.remove(PlayerName);
            }
        } else {
            UnloginList.add(PlayerName);
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