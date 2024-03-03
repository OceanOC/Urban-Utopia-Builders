package com.github.oceanoc.urbanutopiabuilders;

import com.github.oceanoc.urbanutopiabuilders.commands.SetupCityStuff;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerAttributes implements Listener {
    private static Map<String, Integer> money = new HashMap<String, Integer>();

    public Integer getMoney(String uuid){
        return money.get(uuid);
    }

    public void setMoney(String uuid, Integer val){
        money.put(uuid, val);

    }

    public Map<String, Integer> getMoneyInstance(){
        return money;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent evt) {
        Player player = evt.getPlayer();
        money.put(player.getName(), 60000);
        new SetupCityStuff().addactionbar(player);
        player.getInventory().clear();
        player.getInventory().addItem(SetupCityStuff.RoadBuilderItem);
    }

}
