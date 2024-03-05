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

import java.util.HashMap;
import java.util.Map;

public class CityMenuCommand implements CommandExecutor {

    PlayerAttributes playerAttributes = new PlayerAttributes();
    Map<String, Integer> money = playerAttributes.getMoneyInstance();
    
    // GUIs
    public static Inventory cMenu = Bukkit.createInventory(null, 54, Component.text("City Menu"));
    public static Inventory bMenu = Bukkit.createInventory(null, 54, Component.text("Build Menu"));
    public static Inventory fMenu = Bukkit.createInventory(null, 54, Component.text("Finance Menu"));

    // GUI Items
    public static final ItemStack buildMenuItem = new ItemStack(Material.BRICKS);
    public static final ItemStack financeMenuItem = new ItemStack(Material.PAPER);
    public static final ItemStack backButtonItem = new ItemStack(Material.BARRIER);
    public static ItemMeta buildMenuMeta = buildMenuItem.getItemMeta();
    public static ItemMeta financeMenuMeta = financeMenuItem.getItemMeta();




    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player player) {

                setupGUI(0, player);

            } else {
                sender.sendMessage("Only players can access this command");
            }

        }

        return true;
    }



    // Setup GUI
    public void setupGUI(int guinum, Player player) {
        switch (guinum) {
            case 0:
                cMenu.clear();

                for (int i = 0; 54 > i; i++) {
                    cMenu.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                }

                buildMenuMeta.displayName(Component.text("§lBuild Menu").color(TextColor.fromHexString("#FFAA00")));
                buildMenuItem.setItemMeta(buildMenuMeta);
                financeMenuMeta.displayName(Component.text("§lFinances").color(TextColor.fromHexString("#55FF55")));
                financeMenuItem.setItemMeta(financeMenuMeta);

                cMenu.setItem(11, buildMenuItem);
                cMenu.setItem(29, financeMenuItem);

                player.openInventory(cMenu);
                break;

            case 1:
                bMenu.clear();

                for (int i = 0; 54 > i; i++) {
                    bMenu.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                }

                bMenu.setItem(0, backButtonItem);

                player.openInventory(bMenu);
                break;
            case 2:
                fMenu.clear();

                for (int i = 0; 54 > i; i++) {
                    fMenu.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
                }

                fMenu.setItem(0, backButtonItem);

                player.openInventory(fMenu);
                break;
        }
    }
}
