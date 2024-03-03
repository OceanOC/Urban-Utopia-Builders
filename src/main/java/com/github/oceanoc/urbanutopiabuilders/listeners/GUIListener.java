package com.github.oceanoc.urbanutopiabuilders.listeners;

import com.github.oceanoc.urbanutopiabuilders.PlayerAttributes;
import com.github.oceanoc.urbanutopiabuilders.commands.CityMenuCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.net.http.WebSocket;
import java.util.Map;

import static com.github.oceanoc.urbanutopiabuilders.commands.CityMenuCommand.*;

public class GUIListener implements Listener {

    public Map<String, Integer> money = new PlayerAttributes().getMoneyInstance();

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getClickedInventory().equals(CMenu)){

            // Check if BuildMenuItem is clicked
            if (event.getRawSlot() == 11) {

                player.getItemOnCursor().setAmount(0);
                event.setCancelled(true);
                player.closeInventory();
                new CityMenuCommand().setupGUI(1, player);

                // Check if ZoneMenuItem is clicked
            } else if (event.getRawSlot() == 13) {
                player.getItemOnCursor().setAmount(0);
                event.setCancelled(true);
                player.closeInventory();
                new CityMenuCommand().setupGUI(1, player);

            }

        }


    }
}
