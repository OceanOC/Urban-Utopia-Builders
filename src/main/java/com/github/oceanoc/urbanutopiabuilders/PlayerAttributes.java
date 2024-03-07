package com.github.oceanoc.urbanutopiabuilders;

import com.github.oceanoc.urbanutopiabuilders.commands.SetupCityStuff;
import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;

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
        if (player.hasPlayedBefore()) {
            money.get(player.getName());
        } else {
            money.put(player.getName(), 60000);
        }
        new SetupCityStuff().addActionBar(player);
        player.getInventory().clear();
        new GetCustomItem().giveCityMenu(player, true);
        new GetCustomItem().giveRoadBuilder(player, true);

    }
    }
