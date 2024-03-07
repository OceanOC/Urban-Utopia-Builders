package com.github.oceanoc.urbanutopiabuilders;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetCustomItem {
    private ItemStack roadBuilderItem = new ItemStack(Material.NETHERITE_SHOVEL);
    private ItemMeta roadBuilderItemMeta = roadBuilderItem.getItemMeta();
    private ItemStack cityMenuItem = new ItemStack(Material.COMPASS);
    private ItemMeta cityMenuItemMeta = cityMenuItem.getItemMeta();

    // Hopefully this is a better method to give items to the player

    public void giveCityMenu(Player player, boolean givePlayerItem){
        cityMenuItemMeta.displayName(Component.text("§l§6City Menu"));
        cityMenuItem.setItemMeta(cityMenuItemMeta);
        if (givePlayerItem){
            player.getInventory().setItem(8, roadBuilderItem);
        }
    }

    public void giveRoadBuilder(Player player, boolean givePlayerItem){
        roadBuilderItemMeta.displayName(Component.text("§lRoad Builder"));
        roadBuilderItemMeta.setUnbreakable(true);
        roadBuilderItem.setItemMeta(roadBuilderItemMeta);
        if (givePlayerItem) {
            player.getInventory().setItem(0, roadBuilderItem);
        }
    }

    public ItemStack getCityMenuItem(){
        cityMenuItemMeta.displayName(Component.text("§l§6City Menu"));
        cityMenuItem.setItemMeta(cityMenuItemMeta);
        return cityMenuItem;
    }

    public ItemStack getRoadBuilderItem(){
        roadBuilderItemMeta.displayName(Component.text("§lRoad Builder"));
        roadBuilderItemMeta.setUnbreakable(true);
        roadBuilderItem.setItemMeta(roadBuilderItemMeta);
        return roadBuilderItem;
    }

    public ItemMeta getRoadBuilderItemMeta(){
        roadBuilderItemMeta.displayName(Component.text("§lRoad Builder"));
        roadBuilderItemMeta.setUnbreakable(true);
        return roadBuilderItemMeta;
    }

    public ItemMeta getCityMenuItemMeta(){
        cityMenuItemMeta.displayName(Component.text("§l§6City Menu"));
        cityMenuItem.setItemMeta(cityMenuItemMeta);
        return cityMenuItemMeta;
    }
}
