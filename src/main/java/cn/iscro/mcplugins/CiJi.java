package cn.iscro.mcplugins;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class CiJi extends JavaPlugin {
    public static CiJi instance;
    @Override
    public void onEnable() {
       instance = this;
       getLogger().info("插件成功启动！刺稽");
       this.saveDefaultConfig();
       Bukkit.getPluginManager().registerEvents(new LoginListener(),this);
       Bukkit.getPluginManager().registerEvents(new LoginCommand(),this);
       Bukkit.getPluginManager().registerEvents(new LoginTipListener(),this);
       CommandExecutor ce = new LoginCommand();
       Bukkit.getPluginCommand("l").setExecutor(ce);
       Bukkit.getPluginCommand("reg").setExecutor(ce);
       Bukkit.getPluginCommand("ciji").setExecutor(new CiJiCommand());
       Player p1 = Bukkit.getPlayer("ImOxygen233");
       Player p2 = Bukkit.getPlayer("LiteCat");
       Player p3 = Bukkit.getPlayer("jared2021");
       Player p4 = Bukkit.getPlayer("HKZ");
       Player p5 = Bukkit.getPlayer("ColdShine");
       if(p1!=null)
           p1.sendMessage("你确定你是Oxygen吗？");
       if(p2!=null)
           p2.sendMessage("口也，华喵！");
       if(p3!=null)
           p3.sendMessage("2333");
       if(p4!=null)
           p4.sendMessage("刺稽");
       if(p5!=null)
           p5.sendMessage("小可爱！");
        // Plugin startup logic
    }

    public class CiJiCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            sender.sendMessage("&3刺稽");
            return true;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
