package com.chrismin13.vanillaadditions.listeners;

import java.util.ArrayList;
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

public class BlockBreakListener implements Listener {

	HashMap<UUID, BlockFace> lastBlockFace = new HashMap<>();
	public static ArrayList<Block> blocksBeingBroken = new ArrayList<>();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCustomItemBlockBreak(CustomItemBlockBreakEvent event) {
		if (event.isCancelled())
			return;
		CustomItem cItem = event.getCustomItem();
		CustomItemStack cStack = event.getCustomItemStack();
		BlockBreakEvent breakEvent = event.getBlockBreakEvent();
		Player player = breakEvent.getPlayer();
		Block block = breakEvent.getBlock();
		UUID uuid = player.getUniqueId();
		if (BlockBreakListener.blocksBeingBroken.contains(block))
			return;
		if (cItem instanceof DoubleAxeAbilities
				&& (block.getType().equals(Material.LOG) || block.getType().equals(Material.LOG_2))) {
			((DoubleAxeAbilities) cItem).chopTree(player, block, cStack);
		} else if (cItem instanceof SickleAbilities) {
			((SickleAbilities) cItem).onUse(cStack, block, player);
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
