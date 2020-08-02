package cn.iscro.ciji;
import org.apache.commons.codec.digest.DigestUtils;
import org.bukkit.Bukkit;

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
        CiJi.instance.getConfig().set("player_data." + PlayerName + ".password", DigestUtils.md5Hex(Password));
        CiJi.instance.saveConfig();
        return true;
    }
    public static boolean isCorrectPassword(String PlayerName,String Password){
        if(!isRegister(PlayerName))
            return false;
        String pass_md5 = CiJi.instance.getConfig().getString("player_data." + PlayerName + ".password");
        return pass_md5.equals(DigestUtils.md5Hex(Password));
    }
}