package com.github.oceanoc.urbanutopiabuilders;

import com.github.oceanoc.urbanutopiabuilders.commands.CityMenuCommand;
import com.github.oceanoc.urbanutopiabuilders.commands.SetupCityStuff;
import com.github.oceanoc.urbanutopiabuilders.listeners.GUIListener;
import com.github.oceanoc.urbanutopiabuilders.listeners.RoadBuilderListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public final class UrbanUtopiaBuilders extends JavaPlugin {

    static UrbanUtopiaBuilders instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        Bukkit.getPluginCommand("citymenu").setExecutor(new CityMenuCommand());
        Bukkit.getPluginCommand("setupcity").setExecutor(new SetupCityStuff());
        getServer().getPluginManager().registerEvents(new RoadBuilderListener(), this);
        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerAttributes(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static UrbanUtopiaBuilders getInstance() {
        return instance;
    }
}
