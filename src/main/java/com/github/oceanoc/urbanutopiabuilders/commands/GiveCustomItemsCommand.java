package com.github.oceanoc.urbanutopiabuilders.commands;

import com.github.oceanoc.urbanutopiabuilders.GetCustomItem;
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
            new GetCustomItem().giveCityMenu(player, true);
            new GetCustomItem().giveRoadBuilder(player, true);
        }

            return true;
    }
}
