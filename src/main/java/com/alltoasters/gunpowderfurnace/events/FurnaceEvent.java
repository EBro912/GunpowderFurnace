package com.alltoasters.gunpowderfurnace.events;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

public class FurnaceEvent implements Listener {
    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {
        ItemStack source = event.getSource();
        ItemStack result = event.getResult();
        Block furnace = event.getBlock();

        if (source.getType() == Material.GUNPOWDER && result.getType() == Material.DIAMOND) {
            int size = source.getAmount();
            // remove all the gunpowder. they were used in the explosion!
            source.setAmount(0);
            World world = furnace.getWorld();
            world.createExplosion(furnace.getLocation(), size, true, true, null);
        }
    }
}
