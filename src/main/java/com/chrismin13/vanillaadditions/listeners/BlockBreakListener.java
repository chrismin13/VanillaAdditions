package com.chrismin13.vanillaadditions.listeners;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.chrismin13.additionsapi.events.item.CustomItemBlockBreakEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.utils.BlockUtils;

public class BlockBreakListener implements Listener {

	HashMap<UUID, BlockFace> lastBlockFace = new HashMap<>();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCustomItemBlockBreak(CustomItemBlockBreakEvent event) {
		if (event.isCancelled())
			return;
		CustomItem cItem = event.getCustomItem();
		CustomItemStack cStack = event.getCustomItemStack();
		BlockBreakEvent breakEvent = event.getBlockBreakEvent();
		Player player = breakEvent.getPlayer();
		Block block = breakEvent.getBlock();
		Material material = block.getType();
		UUID uuid = player.getUniqueId();
		if (BlockUtils.isBlockIgnored(block))
			return;
		if (cItem instanceof DoubleAxeAbilities && (material.equals(Material.ACACIA_LOG)
				|| material.equals(Material.BIRCH_LOG) || material.equals(Material.DARK_OAK_LOG)
				|| material.equals(Material.JUNGLE_LOG) || material.equals(Material.SPRUCE_LOG))
				|| material.equals(Material.OAK_LOG)) {
			((DoubleAxeAbilities) cItem).chopTree(player, block, cStack);
		} else if (cItem instanceof SickleAbilities) {
			((SickleAbilities) cItem).onUse(breakEvent, cStack, block, player);
		} else if (cItem instanceof HammerAbilities && lastBlockFace.get(uuid) != null) {
			((HammerAbilities) cItem).onUse(block, lastBlockFace.get(uuid), cStack, player);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onInteract(PlayerInteractEvent event) {
		if (event.isCancelled())
			return;

		Action action = event.getAction();
		Player player = event.getPlayer();
		if (action.equals(Action.LEFT_CLICK_BLOCK))
			lastBlockFace.put(player.getUniqueId(), event.getBlockFace());
	}

}
