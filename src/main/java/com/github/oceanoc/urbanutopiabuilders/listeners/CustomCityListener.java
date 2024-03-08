package com.github.oceanoc.urbanutopiabuilders.listeners;

import com.github.oceanoc.urbanutopiabuilders.GetCustomItem;
import com.github.oceanoc.urbanutopiabuilders.PlayerAttributes;
import com.github.oceanoc.urbanutopiabuilders.UrbanUtopiaBuilders;
import com.github.oceanoc.urbanutopiabuilders.commands.CityMenuCommand;
import com.github.oceanoc.urbanutopiabuilders.commands.SetupCityStuff;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CustomCityListener implements Listener {
    PlayerAttributes playerAttributes = new PlayerAttributes();

    Map<UUID, Location> firstblockplace = new HashMap<>();
    Map<UUID, Double> blockdistance = new HashMap<>();



    Map<String, Integer> money = playerAttributes.getMoneyInstance();

    private ItemMeta roadBuilderItemMeta = new GetCustomItem().getRoadBuilderItemMeta();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // All of these ifs are necessary if we don't want any errors in the server logs
        // Add roads
        if (event.hasItem() && event.hasBlock()){
            if (event.getAction().isRightClick() && event.getItem().hasItemMeta()){
                if (event.getItem().getItemMeta().equals(roadBuilderItemMeta)){
                    firstblockplace.put(event.getPlayer().getUniqueId(), event.getClickedBlock().getLocation());
                    event.getClickedBlock().setType(Material.LIME_WOOL);
                    money.put(event.getPlayer().getName(), (money.get(event.getPlayer().getName()) - 50));
                }
            }

            if (event.getAction().isLeftClick() && event.getItem().hasItemMeta() ){ // && event.getClickedBlock().getType().equals(Material.LIME_WOOL)
                if (event.getItem().getItemMeta().equals(new GetCustomItem().getRoadBuilderItemMeta())){
                    blockdistance.put(event.getPlayer().getUniqueId(), event.getClickedBlock().getLocation().distance(firstblockplace.get(event.getPlayer().getUniqueId())));
                    event.getClickedBlock().setType(Material.LIME_WOOL);
                    BlockIterator blocksToAdd = new BlockIterator(firstblockplace.get(event.getPlayer().getUniqueId()).getWorld(), firstblockplace.get(event.getPlayer().getUniqueId()).toVector(), new Vector(event.getClickedBlock().getLocation().getBlockX()-firstblockplace.get(event.getPlayer().getUniqueId()).getBlockX(), event.getClickedBlock().getLocation().getBlockY()-firstblockplace.get(event.getPlayer().getUniqueId()).getBlockY(), event.getClickedBlock().getLocation().getBlockZ()-firstblockplace.get(event.getPlayer().getUniqueId()).getBlockZ()), 0, (int) Math.floor(firstblockplace.get(event.getPlayer().getUniqueId()).distanceSquared(event.getClickedBlock().getLocation())));

                    Location blockToAdd;
                    while(blocksToAdd.hasNext()) {
                        blockToAdd = blocksToAdd.next().getLocation();
                        if (event.getClickedBlock().getLocation().distance(firstblockplace.get(event.getPlayer().getUniqueId())) < 15){
                            Location addblock = new Location(blockToAdd.getWorld(), blockToAdd.getBlockX(), blockToAdd.getBlockY(), blockToAdd.getBlockZ());
                            if (!addblock.getBlock().getType().equals(Material.AIR)){
                                blockToAdd.getWorld().setType(addblock, Material.LIME_WOOL);
                            }

                        }
                    }

                    money.put(event.getPlayer().getName(), (money.get(event.getPlayer().getName()) - 100));
                }
            }


        }

        // City Menu Item
        if (event.hasItem()){
            if (event.getAction().isRightClick() && event.getItem().hasItemMeta()){
                if (event.getItem().getItemMeta().equals(new GetCustomItem().getCityMenuItem().getItemMeta())){
                    new CityMenuCommand().setupGUI(0, event.getPlayer());
                }
            }
        }

}
}
