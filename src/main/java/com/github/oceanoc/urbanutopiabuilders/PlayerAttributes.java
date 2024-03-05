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
        SetupCityStuff.roadBuilderItemMeta.displayName(Component.text("§lRoad Builder"));
        SetupCityStuff.roadBuilderItemMeta.setUnbreakable(true);
        SetupCityStuff.roadBuilderItem.setItemMeta(SetupCityStuff.roadBuilderItemMeta);
        SetupCityStuff.cityMenuItemMeta.displayName(Component.text("§l§6City Menu"));
        SetupCityStuff.cityMenuItem.setItemMeta(SetupCityStuff.cityMenuItemMeta);
        player.getInventory().setItem(0, SetupCityStuff.roadBuilderItem);
        player.getInventory().setItem(9, SetupCityStuff.cityMenuItem);

    }
    }
