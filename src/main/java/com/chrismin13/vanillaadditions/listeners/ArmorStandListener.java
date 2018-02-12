package com.chrismin13.vanillaadditions.listeners;

import com.chrismin13.vanillaadditions.Items;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public class ArmorStandListener implements Listener {

    @EventHandler
    public void onArmorStandPlace(CreatureSpawnEvent event) {
        if (Items.config == null || Items.config.getStringList("enabled-mechanics") == null)
            return;
        List<String> mechanics = Items.config.getStringList("enabled-mechanics");
        if (event.isCancelled() || event.getEntityType() == null
                || !event.getEntityType().equals(EntityType.ARMOR_STAND)
                || mechanics == null || mechanics.isEmpty()
                || !mechanics.contains("ARMOR_STANDS_WITH_ARMS"))
            return;

        ArmorStand stand = (ArmorStand) event.getEntity();
        if (!stand.hasArms())
            stand.setArms(true);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onArmorStandItemAdd(PlayerInteractAtEntityEvent event) {
        List<String> mechanics = Items.config.getStringList("enabled-mechanics");
        if (event.isCancelled() || !mechanics.contains("ARMOR_STAND_ITEM_IN_OFF_HAND")
                || !event.getRightClicked().getType().equals(EntityType.ARMOR_STAND) || event.getHand() == null
                || !event.getHand().equals(EquipmentSlot.HAND))
            return;

        ArmorStand stand = (ArmorStand) event.getRightClicked();

        if (!stand.hasArms())
            return;

        EntityEquipment standInv = stand.getEquipment();
        ItemStack itemStand = standInv.getItemInOffHand();

        Player player = event.getPlayer();
        PlayerInventory playerInv = player.getInventory();
        ItemStack itemPlayer = playerInv.getItemInOffHand();

        if (itemStand.getType().equals(Material.AIR) && itemPlayer != null && !itemPlayer.getType().equals(Material
                .AIR)) {
            if (itemPlayer.getAmount() == 1) {
                standInv.setItemInOffHand(itemPlayer);
                playerInv.setItemInOffHand(null);
            } else if (itemPlayer.getAmount() > 1) {
                ItemStack oneItemPlayer = itemPlayer.clone();

                itemPlayer.setAmount(itemPlayer.getAmount() - 1);
                oneItemPlayer.setAmount(1);

                standInv.setItemInOffHand(oneItemPlayer);
            }
        } else if (!itemStand.getType().equals(Material.AIR) && itemPlayer.getType().equals(Material.AIR)) {
            playerInv.setItemInOffHand(itemStand);
            standInv.setItemInOffHand(null);
        } else if (!itemStand.getType().equals(Material.AIR) && !itemPlayer.getType().equals(Material.AIR)
                && itemPlayer.getAmount() == 1) {
            ItemStack oldItemPlayer = itemPlayer.clone();

            playerInv.setItemInOffHand(itemStand);
            standInv.setItemInOffHand(oldItemPlayer);
        }
    }

}