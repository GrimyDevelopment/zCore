package us.zantix.core.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import us.zantix.api.utils.CC;
import us.zantix.core.zCore;

public class PlayerListeners implements Listener {

    private zCore plugin;

    public PlayerListeners(zCore plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPLayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        for(String msg : zCore.getInstance().getZCoreConfig().getJoinMessages()) {
            player.sendMessage(CC.translate(msg));
        }
    }
}
