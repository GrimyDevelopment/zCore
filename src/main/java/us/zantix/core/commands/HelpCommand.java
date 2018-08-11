package us.zantix.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.zantix.api.utils.CC;
import us.zantix.core.zCore;

public class HelpCommand implements CommandExecutor  {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player) commandSender;

        for(String msg : zCore.getInstance().getZCoreConfig().getHelpMessage()) {
            player.sendMessage(CC.translate(msg));
        }
        return false;
    }
}
