package us.zantix.core;

import org.bukkit.event.Listener;
import us.zantix.core.listeners.PlayerListeners;

import java.util.Arrays;

public class zCoreManager implements Listener {

    private zCore plugin;

    public zCoreManager(final zCore plugin) {
        this.plugin = plugin;

        Arrays.asList(
                new PlayerListeners(plugin)
        ).forEach(listener -> plugin.getServer().getPluginManager().registerEvents(this, plugin));
    }
}
