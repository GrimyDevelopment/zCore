package us.zantix.core.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.zantix.api.utils.CC;
import us.zantix.core.zCore;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission("zcore.gamemode")) {
            player.sendMessage(CC.translate(zCore.getInstance().getZCoreConfig().getPermissionMessage()));
        }

        if(args.length == 0) {
            player.sendMessage(CC.RED + "Your not using the right usage: /gamemode <1, 2>");
            return true;
        } else if (args[0].equalsIgnoreCase("1")) {
            player.setGameMode(GameMode.CREATIVE);
            player.sendMessage(CC.translate("&eYour game-mode has been changed too&F CREATIVE"));
        } else if (args[0].equalsIgnoreCase("0")) {
            player.setGameMode(GameMode.SURVIVAL);
            player.sendMessage(CC.translate("&eYour game-mode has been changed too&F SURVIVAL"));
        }
        return false;
    }
}
