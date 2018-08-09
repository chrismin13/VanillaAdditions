package com.chrismin13.vanillaadditions.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.events.item.CustomItemBlockIgniteEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.utils.NumberUtils;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackArmor;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackHoe;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackItem;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackShovel;

public class NetherrackItemsListener implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onRightClickBlock(PlayerInteractEvent event) {
		if (event.isCancelled() || !event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
			return;

		Block blockClicked = event.getClickedBlock();
		BlockFace face = event.getBlockFace();
		Block blockAir = event.getClickedBlock().getRelative(face);
		if (blockAir == null || blockAir.getType() == null || blockAir.getType() != Material.AIR)
			return;

		Player player = event.getPlayer();
		ItemStack item = player.getInventory().getItemInMainHand();
		if (!AdditionsAPI.isCustomItem(item))
			return;

		CustomItemStack cStack = new CustomItemStack(item);
		CustomItem cItem = cStack.getCustomItem();
		if (!(cItem instanceof NetherrackItem))
			return;

		Material materialClicked = blockClicked.getType();
		if (face == BlockFace.UP || face == BlockFace.EAST || face == BlockFace.NORTH || face == BlockFace.SOUTH
				|| face == BlockFace.WEST) {
			if (cItem instanceof NetherrackShovel && materialClicked == Material.GRASS) {
				return;
			} else if (cItem instanceof NetherrackHoe
					&& (materialClicked == Material.GRASS || materialClicked == Material.GRASS_PATH
							|| (materialClicked == Material.PODZOL))) {
				return;
			}
		}

		CustomItemBlockIgniteEvent cEvent = new CustomItemBlockIgniteEvent(
				new BlockIgniteEvent(blockClicked, IgniteCause.FLINT_AND_STEEL, blockAir), cStack);
		Bukkit.getPluginManager().callEvent(cEvent);
		if (!cEvent.isCancelled()) {
			blockAir.setType(Material.FIRE);
			player.playSound(blockAir.getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 1F, 1F);
			cStack.reduceDurability(player, 1);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEnemyHit(EntityDamageByEntityEvent event) {
		if (event.isCancelled())
			return;

		if (!(event.getEntity() instanceof Player))
			return;
		Player player = (Player) event.getEntity();
		Entity damager = event.getDamager();

		for (ItemStack item : player.getInventory().getArmorContents()) {
			if (AdditionsAPI.isCustomItem(item)) {
				CustomItemStack cStack = new CustomItemStack(item);

				if (cStack.getCustomItem() instanceof NetherrackArmor && NumberUtils.calculateChance(0.05)) {
					damager.setFireTicks(NumberUtils.randomInt(40, 120));
					break;
				}
			}
		}
	}

}
