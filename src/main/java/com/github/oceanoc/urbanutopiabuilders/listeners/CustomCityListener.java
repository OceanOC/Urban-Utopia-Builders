package com.github.oceanoc.urbanutopiabuilders.listeners;

import com.github.oceanoc.urbanutopiabuilders.GetCustomItem;
import com.github.oceanoc.urbanutopiabuilders.PlayerAttributes;
import com.github.oceanoc.urbanutopiabuilders.commands.CityMenuCommand;
import com.github.oceanoc.urbanutopiabuilders.commands.SetupCityStuff;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Map;

public class CustomCityListener implements Listener {
    PlayerAttributes playerAttributes = new PlayerAttributes();
    Map<String, Integer> money = playerAttributes.getMoneyInstance();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // All of these ifs are necessary if we don't want any errors in the server logs
        // Add roads
        if (event.hasItem() && event.hasBlock()){
            if (event.getAction().isRightClick() && event.getItem().hasItemMeta()){
                if (event.getItem().getItemMeta().equals(new GetCustomItem().getRoadBuilderItem())){
                    event.getClickedBlock().setType(Material.GRAY_CONCRETE);
                    money.put(event.getPlayer().getName(), (money.get(event.getPlayer().getName()) - 50));
                }
            }

            if (event.getAction().isLeftClick() && event.getItem().hasItemMeta() && event.getClickedBlock().getType().equals(Material.GRAY_CONCRETE)){
                if (event.getItem().getItemMeta().equals(new GetCustomItem().getRoadBuilderItemMeta())){
                    event.getClickedBlock().setType(Material.GRASS_BLOCK);
                    money.put(event.getPlayer().getName(), (money.get(event.getPlayer().getName()) - 100));
                }
            }


        }

        // City Menu Item
        if (event.hasItem()){
            if (event.getAction().isRightClick() && event.getItem().hasItemMeta()){
                if (event.getItem().getItemMeta().equals(new GetCustomItem().getCityMenuItemMeta())){
                    new CityMenuCommand().setupGUI(0, event.getPlayer());
                }
            }
        }

}
}
