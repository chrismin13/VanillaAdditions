package com.chrismin13.vanillaadditions.listeners;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentOffer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import com.chrismin13.vanillaadditions.items.lapis.LapisArmor;
import com.chrismin13.vanillaadditions.items.lapis.LapisItem;

public class LapisItemsListener implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onPrepareItemEnchant(PrepareItemEnchantEvent event) {
		if (event.isCancelled())
			return;

		ItemStack item = event.getItem();
		if (!AdditionsAPI.isCustomItem(item))
			return;

		CustomItemStack cStack = new CustomItemStack(item);
		if (!(cStack.getCustomItem() instanceof LapisItem || cStack.getCustomItem() instanceof LapisArmor))
			return;

		EnchantmentOffer[] offers = event.getOffers();
		for (int i = 0; i < offers.length; i++) {
			EnchantmentOffer offer = offers[i];

			if (offer != null && offer.getEnchantment() != null && offer.getEnchantment().getMaxLevel() > 1 &&
					!VanillaAdditions.blacklistedEnchantments.contains(offer.getEnchantment()))
				offer.setEnchantmentLevel(offer.getEnchantmentLevel() + 1);
		}
	}

	@EventHandler
	public void onItemEnchant(EnchantItemEvent event) {
		if (event.isCancelled())
			return;

		ItemStack item = event.getItem();
		if (!AdditionsAPI.isCustomItem(item))
			return;

		CustomItemStack cStack = new CustomItemStack(item);
		if (!(cStack.getCustomItem() instanceof LapisItem || cStack.getCustomItem() instanceof LapisArmor))
			return;

		Map<Enchantment, Integer> enchants = event.getEnchantsToAdd();
		for (Enchantment enchant : enchants.keySet())
			if (enchant.getMaxLevel() > 1 && !VanillaAdditions.blacklistedEnchantments.contains(enchant))
				enchants.put(enchant, enchants.get(enchant) + 1);

		if (event.getInventory() instanceof EnchantingInventory) {
			EnchantingInventory inv = (EnchantingInventory) event.getInventory();

			if (inv.getSecondary() != null) {
				ItemStack lapis = inv.getSecondary();

				if (!(lapis.getType().equals(Material.INK_SACK) && lapis.getData().equals((byte) 4))) {
					int amount = lapis.getAmount();
					Bukkit.getScheduler().scheduleSyncDelayedTask(VanillaAdditions.getInstance(), () -> {
						lapis.setAmount(amount);
					});
				}

			}

		}
	}

}
