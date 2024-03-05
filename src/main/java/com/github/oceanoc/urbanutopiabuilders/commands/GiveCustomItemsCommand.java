package com.github.oceanoc.urbanutopiabuilders.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GiveCustomItemsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            player.getInventory().clear();
            SetupCityStuff.roadBuilderItemMeta.displayName(Component.text("§lRoad Builder"));
            SetupCityStuff.roadBuilderItemMeta.setUnbreakable(true);
            SetupCityStuff.roadBuilderItem.setItemMeta(SetupCityStuff.roadBuilderItemMeta);
            SetupCityStuff.cityMenuItemMeta.displayName(Component.text("§l§6City Menu"));
            SetupCityStuff.cityMenuItem.setItemMeta(SetupCityStuff.cityMenuItemMeta);
            player.getInventory().setItem(0, SetupCityStuff.roadBuilderItem);
            player.getInventory().setItem(8, SetupCityStuff.cityMenuItem);
        }

            return true;
    }
}
