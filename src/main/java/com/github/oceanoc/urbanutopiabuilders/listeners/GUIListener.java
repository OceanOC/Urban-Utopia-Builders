package com.github.oceanoc.urbanutopiabuilders.listeners;

import com.github.oceanoc.urbanutopiabuilders.commands.CityMenuCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.net.http.WebSocket;

import static com.github.oceanoc.urbanutopiabuilders.commands.CityMenuCommand.*;

public class GUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getClickedInventory().equals(CMenu)){

            // Check if BuildMenuItem is clicked
            if (player.getItemOnCursor().getItemMeta().equals(BuildMenuMeta)) {
                player.getItemOnCursor().setAmount(0);
                CMenu.setItem(11, BuildMenuItem);
                player.closeInventory();
                new CityMenuCommand().setupGUI(1, player);

            } else if (player.getItemOnCursor().getItemMeta().equals(ZoneMenuMeta)) {
                player.getItemOnCursor().setAmount(0);
                CMenu.setItem(11, BuildMenuItem);
                player.closeInventory();
                new CityMenuCommand().setupGUI(1, player);

            }
        }
    }
}
