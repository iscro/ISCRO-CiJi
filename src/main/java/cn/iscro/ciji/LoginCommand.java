package cn.iscro.ciji;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class LoginCommand implements Listener, CommandExecutor {
    @EventHandler
    public void OnPlayerCommand(PlayerCommandPreprocessEvent ThisEvent){
        if(LoginWelcome.isLogin(ThisEvent.getPlayer().getName()))
            return;
        ThisEvent.setCancelled(true);
        if(ThisEvent.getMessage().split(" ")[0].contains("l") || ThisEvent.getMessage().split(" ")[0].contains("reg"))
            ThisEvent.setCancelled(false);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player))
            return false;
        Player ThisPlayer = (Player)sender;
        if(command.getName().equalsIgnoreCase("l"))
            logincommand(ThisPlayer,args);
        if(command.getName().equalsIgnoreCase("reg"))
            registercommand(ThisPlayer,args);
        return true;
    }
    private void logincommand(Player ThisPlayer,String[] args){
        if(LoginWelcome.isLogin(ThisPlayer.getName())){
            ThisPlayer.sendMessage(ChatColor.BLUE + "你已经登录了哦！不能重复登录");
            return;
        }
        if(!LoginWelcome.isRegister(ThisPlayer.getName())){
            ThisPlayer.sendMessage(ChatColor.RED + "你还没有注册哦！快输入/reg <密码>去注册吧");
            return;
        }
        if(args.length!=1) {
            ThisPlayer.sendMessage(ChatColor.RED + "登录命令输入错误！正确的命令是/l <密码>");
            return;
        }
        if(LoginWelcome.isCorrectPassword(ThisPlayer.getName(),args[0])) {
            ThisPlayer.sendMessage(ChatColor.GREEN + "登录成功！快去服务器玩♂耍吧");
            LoginWelcome.SetPlayerLogin(ThisPlayer.getName(), true);
        }
    }
    private void registercommand(Player ThisPlayer,String[] args){
        if(LoginWelcome.isLogin(ThisPlayer.getName())){
            ThisPlayer.sendMessage(ChatColor.BLUE + "你已经注册并登录了哦！不能重复注册");
            return;
        }
        if(LoginWelcome.isRegister(ThisPlayer.getName())) {
            ThisPlayer.sendMessage(ChatColor.BLUE + "你已经注册了哦！不能重复注册");
            return;
        }
        if(args.length!=1) {
            ThisPlayer.sendMessage(ChatColor.RED + "注册命令输入错误！正确的命令是/reg <密码>");
            return;
        }
        LoginWelcome.Register(ThisPlayer.getName(),args[0]);
        ThisPlayer.sendMessage(ChatColor.GREEN + "注册成功！快去登录并玩♂耍吧");
    }
}
