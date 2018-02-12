package com.chrismin13.vanillaadditions.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.utils.NumberUtils;

public class CoalItemsListener implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		if (event.isCancelled())
			return;
		Player player = event.getPlayer();
		PlayerInventory inv = player.getInventory();

		if (!player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
			for (ItemStack item : inv.getArmorContents()) {
				if (AdditionsAPI.isCustomItem(item)
						&& AdditionsAPI.getIdName(item).contains("vanilla_additions:coal_")) {
					if (NumberUtils.calculateChance((double) 1 / (double) 200)) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 0), false);
						return;
					}
				}
			}
		}
	}
}
