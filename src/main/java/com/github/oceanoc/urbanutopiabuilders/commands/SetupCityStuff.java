package com.github.oceanoc.urbanutopiabuilders.commands;

import com.github.oceanoc.urbanutopiabuilders.PlayerAttributes;
import com.github.oceanoc.urbanutopiabuilders.UrbanUtopiaBuilders;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SetupCityStuff implements CommandExecutor {

    PlayerAttributes playerAttributes = new PlayerAttributes();
    Map<String, Integer> money = playerAttributes.getMoneyInstance();

    public static final ItemStack roadBuilderItem = new ItemStack(Material.NETHERITE_SHOVEL);
    public static final ItemMeta roadBuilderItemMeta = roadBuilderItem.getItemMeta();
    public static final ItemStack cityMenuItem = new ItemStack(Material.COMPASS);
    public static final ItemMeta cityMenuItemMeta = cityMenuItem.getItemMeta();
    List<Player> listOfPlayers = new ArrayList<>(Bukkit.getOnlinePlayers());

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Bukkit.broadcast(Component.text("Use \"/citymenu\" to open up the main menu"));

        roadBuilderItemMeta.displayName(Component.text("§lRoad Builder"));
        roadBuilderItemMeta.setUnbreakable(true);
        roadBuilderItem.setItemMeta(roadBuilderItemMeta);
        cityMenuItemMeta.displayName(Component.text("§l§6City Menu"));
        cityMenuItem.setItemMeta(cityMenuItemMeta);

        for (int i = 0; listOfPlayers.size() > i; i++){
            listOfPlayers.get(i).getInventory().addItem(roadBuilderItem);
            listOfPlayers.get(i).getInventory().addItem(cityMenuItem);
            money.put(listOfPlayers.get(i).getName(), 60000);
            listOfPlayers.get(i).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, -1, 2));
        }

        var runnable = new BukkitRunnable() {
            @Override
            public void run() {
                for (int i = 0; listOfPlayers.size() > i; i++){
                    listOfPlayers.get(i).sendActionBar(Component.text("Money: " + money.get(listOfPlayers.get(i).getName())));
                }
            }
        };
        runnable.runTaskTimer(UrbanUtopiaBuilders.getInstance(), 20L, 10L);

        return true;
    }

    public void addActionBar(Player player){
        var runnable = new BukkitRunnable() {
            @Override
            public void run() {
                // This is deprecated
                // TODO: Use something not deprecated
                    player.sendActionBar(Component.text("Money: " + money.get(player.getName())));
            }
        };
        runnable.runTaskTimer(UrbanUtopiaBuilders.getInstance(), 20L, 10L);
    }

    }
