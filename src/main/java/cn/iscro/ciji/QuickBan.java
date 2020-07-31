package cn.iscro.ciji;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class QuickBan implements CommandExecutor{
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if(!(sender instanceof Player))
                return false;
            if(command.getName().equalsIgnoreCase("bp"))
                Bukkit.getBanList(BanList.Type.NAME).addBan(args[0],"您由于违反本服规则被管理员封禁！", null,"管理员");
                sender.sendMessage("成功封禁玩家"+args[0]);
            if(command.getName().equalsIgnoreCase("bip"))
                Bukkit.getBanList(BanList.Type.IP).addBan(args[0],"您由于违反本服规则被管理员封禁！", null,"管理员");
                sender.sendMessage("成功封禁IP"+args[0]);
            if (command.getName().equalsIgnoreCase("ubp"))
                Bukkit.getBanList(BanList.Type.NAME).pardon(args[0]);
                sender.sendMessage("成功解封玩家"+args[0]);
            if (command.getName().equalsIgnoreCase("ubip"))
                Bukkit.getBanList(BanList.Type.IP).pardon(args[0]);
                sender.sendMessage("成功解封IP"+args[0]);
            if(command.getName().equalsIgnoreCase("gbp"))
                sender.sendMessage("封禁玩家列表有"+Bukkit.getBanList(BanList.Type.NAME).getBanEntries().toString());
            if(command.getName().equalsIgnoreCase("gbip"))
                sender.sendMessage("封禁IP列表有"+Bukkit.getBanList(BanList.Type.IP).getBanEntries().toString());
            return true;
        }
    }

