package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.vanillaadditions.Items;
import com.chrismin13.vanillaadditions.utils.BookUtils;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class BookListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemFrameInteract(PlayerInteractEntityEvent event) {
        List<String> mechanics = Items.config.getStringList("enabled-mechanics");
        if (event.isCancelled() || event.getPlayer().isSneaking() || !mechanics.contains("OPEN_BOOK_IN_ITEM_FRAME"))
            return;

        if (!event.getRightClicked().getType().equals(EntityType.ITEM_FRAME))
            return;

        ItemFrame frame = (ItemFrame) event.getRightClicked();
        ItemStack item = frame.getItem();

        if (item == null || !item.getType().equals(Material.WRITTEN_BOOK))
            return;

        BookUtils.openBook(item, event.getPlayer());
        event.setCancelled(true);
    }

}
