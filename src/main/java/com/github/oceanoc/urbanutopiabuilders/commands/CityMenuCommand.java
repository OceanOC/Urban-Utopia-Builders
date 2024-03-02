package com.github.oceanoc.urbanutopiabuilders.commands;

import com.github.oceanoc.urbanutopiabuilders.PlayerAttributes;
import com.github.oceanoc.urbanutopiabuilders.UrbanUtopiaBuilders;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class CityMenuCommand implements CommandExecutor {
    // GUIs
    public static Inventory CMenu = Bukkit.createInventory(null, 54, Component.text("City Menu"));
    public static Inventory BMenu = Bukkit.createInventory(null, 54, Component.text("Build Menu"));

    // GUI Items
    public static final ItemStack BuildMenuItem = new ItemStack(Material.BRICKS);
    public static final ItemStack ZoneMenuItem = new ItemStack(Material.GREEN_WOOL);
    public static ItemMeta BuildMenuMeta = BuildMenuItem.getItemMeta();
    public static ItemMeta ZoneMenuMeta = ZoneMenuItem.getItemMeta();




    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player player) {

                if (!player.hasPlayedBefore()) {
                    new PlayerAttributes().SetMoney(player.getUniqueId(), 60000);
                }

                var runnable = new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.sendActionBar(Component.text("Money: " + new PlayerAttributes().GetMoney(player.getUniqueId())));
                    }
                };
                runnable.runTaskTimer(UrbanUtopiaBuilders.getInstance(), 20L, 10L);

                setupGUI(0, player);

            } else {
                sender.sendMessage("Only players can access this command");
            }

        } else {


            if (sender instanceof Player player){

            if (!player.hasPlayedBefore()) {
                new PlayerAttributes().SetMoney(((Player) sender).getUniqueId(), 60000);
            }

            var runnable = new BukkitRunnable() {
                @Override
                public void run() {
                    player.sendActionBar(Component.text("Money: " + new PlayerAttributes().GetMoney(player.getUniqueId())));
                }
            };
            runnable.runTaskTimer(UrbanUtopiaBuilders.getInstance(), 20L, 10L);
            }
        }


        return true;
    }



    // Setup GUI
    public void setupGUI(int guinum, Player player) {
        switch (guinum) {
            case 0:
                CMenu.clear();

                for (int i = 0; 54 > i; i++) {
                    CMenu.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                }

                BuildMenuMeta.displayName(Component.text("§lBuild Menu").color(TextColor.fromHexString("#FFAA00")));
                BuildMenuItem.setItemMeta(BuildMenuMeta);
                ZoneMenuMeta.displayName(Component.text("§lZone Menu").color(TextColor.fromHexString("#55FF55")));
                ZoneMenuItem.setItemMeta(ZoneMenuMeta);

                CMenu.setItem(11, BuildMenuItem);
                CMenu.setItem(13, ZoneMenuItem);

                player.openInventory(CMenu);
                break;

            case 1:
                BMenu.clear();

                for (int i = 0; 54 > i; i++) {
                    BMenu.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                }

                player.openInventory(BMenu);
                break;
        }
    }
}
