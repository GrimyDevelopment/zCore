package us.zantix.core;

import lombok.Getter;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import us.zantix.api.zAPI;
import us.zantix.core.file.ConfigCursor;
import us.zantix.core.file.FileConfig;

@Getter
public class zCore extends JavaPlugin {

    @Getter private static zCore instance;
    private zAPI api;
    private zCoreManager zCoreManager;
    private FileConfig mainFileConfig;
    private zCoreConfig zCoreConfig;

    public void onEnable() {
        instance = this;

        this.mainFileConfig = new FileConfig(this, "lang.yml");
        this.zCoreConfig = new zCoreConfig();
        this.zCoreConfig.load();

        ConfigCursor cursor = new ConfigCursor(this.mainFileConfig, null);

        this.zCoreManager = new zCoreManager(this);

        this.api = (zAPI) Bukkit.getPluginManager().getPlugin("zAPI");
    }

    public void onDisable() {
        instance = null;
    }
}
