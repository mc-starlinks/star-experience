package com.starlinks.experience;

import com.starlinks.core.api.StarAPI;
import com.starlinks.core.api.database.StarDatabaseProvider;
import com.starlinks.core.sdk.database.credentials.UniversalCredentials;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LinkExperience extends JavaPlugin {

    public static LinkExperience getInstance() {
        return getPlugin(LinkExperience.class);
    }

    private StarAPI starAPI;
    private StarDatabaseProvider starDatabaseProvider;

    @Override
    public void onEnable() {
        starAPI = Bukkit.getServicesManager().load(StarAPI.class);

        starDatabaseProvider = starAPI.getDatabaseFactory().newMysqlProvider()
                .loginWithCredentials(new UniversalCredentials("localhost:3304", "starlinks", "root", ""));
    }

    public StarDatabaseProvider getDatabaseProvider() {
        return starDatabaseProvider;
    }

    public StarAPI getAPI() {
        return starAPI;
    }
}
