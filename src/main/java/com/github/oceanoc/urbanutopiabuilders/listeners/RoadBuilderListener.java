package com.github.oceanoc.urbanutopiabuilders.listeners;

import com.github.oceanoc.urbanutopiabuilders.PlayerAttributes;
import com.github.oceanoc.urbanutopiabuilders.commands.SetupCityStuff;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import java.util.Map;
import java.util.Objects;

public class RoadBuilderListener implements Listener {
    PlayerAttributes playerAttributes = new PlayerAttributes();
    Map<String, Integer> money = playerAttributes.getMoneyInstance();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // All of these ifs are necessary if we don't want any errors in the server logs
        // Add roads
        if (event.hasItem() && event.hasBlock()){
            if (event.getAction().isRightClick() && event.getItem().hasItemMeta()){
                if (event.getItem().getItemMeta().equals(SetupCityStuff.RoadBuilderItemMeta)){
                    event.getClickedBlock().setType(Material.GRAY_CONCRETE);
                    money.put(event.getPlayer().getName(), (money.get(event.getPlayer().getName()) - 50));
                }
            }

            if (event.getAction().isLeftClick() && event.getItem().hasItemMeta() && event.getClickedBlock().getType().equals(Material.GRAY_CONCRETE)){
                if (event.getItem().getItemMeta().equals(SetupCityStuff.RoadBuilderItemMeta)){
                    event.getClickedBlock().setType(Material.GRASS_BLOCK);
                    money.put(event.getPlayer().getName(), (money.get(event.getPlayer().getName()) - 100));
                }
            }
        }

}
}
