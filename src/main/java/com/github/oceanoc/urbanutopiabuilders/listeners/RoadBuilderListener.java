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

import java.util.Objects;

public class RoadBuilderListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // All of these ifs are necessary if we don't want any errors in the server logs
        if (event.hasItem() && event.hasBlock()){
            if (event.getAction().isRightClick() && event.getItem().hasItemMeta()){
                if (event.getItem().getItemMeta().equals(SetupCityStuff.RoadBuilderItemMeta)){
                    event.getClickedBlock().setType(Material.GRAY_CONCRETE);
                    new PlayerAttributes().SetMoney(event.getPlayer().getUniqueId(), (new PlayerAttributes().GetMoney(event.getPlayer().getUniqueId()) - 100));
                }
            }
        }

}
}
