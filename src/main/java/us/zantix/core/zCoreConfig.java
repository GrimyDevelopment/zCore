package us.zantix.core;

import lombok.Getter;

import us.zantix.core.file.ConfigCursor;

import java.util.List;

@Getter
public class zCoreConfig {

    private List<String> helpMessage;
    private List<String> joinMessages;

    private String permissionMessage;

    public void load() {
        ConfigCursor cursor = new ConfigCursor(zCore.getInstance().getMainFileConfig(), "server");

        this.permissionMessage = cursor.getString("message.permission");

        cursor.setPath("settings");
        this.helpMessage = cursor.getStringList("help-message");
        this.joinMessages = cursor.getStringList("join-messages");
    }
}
