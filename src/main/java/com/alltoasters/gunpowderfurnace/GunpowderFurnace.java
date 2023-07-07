package com.alltoasters.gunpowderfurnace;

import com.alltoasters.gunpowderfurnace.events.FurnaceEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class GunpowderFurnace extends JavaPlugin {
    public static Level LOG_LEVEL = Level.INFO;

    @Override
    public void onEnable() {
        Bukkit.getLogger().setLevel(LOG_LEVEL);
        Bukkit.getPluginManager().registerEvents(new FurnaceEvent(), this);
        createGunpowderRecipe();
        log("Loaded gunpowder recipe.");
    }

    private void createGunpowderRecipe() {
        FurnaceRecipe recipe = new FurnaceRecipe(
                new NamespacedKey(this, "gunpowder_furnace"),
                new ItemStack(Material.DIAMOND),
                Material.GUNPOWDER,
                0,
                200);
        Bukkit.addRecipe(recipe);
    }

    public static void log(String message) {
        Bukkit.getLogger().log(LOG_LEVEL, "[GunpowderFurnace] " + message);
    }
}
