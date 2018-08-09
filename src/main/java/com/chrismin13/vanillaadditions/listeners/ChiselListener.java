package com.chrismin13.vanillaadditions.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.chrismin13.additionsapi.events.item.CustomItemBlockBreakEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.utils.PermissionUtils;
import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.permissions.ChiselPermissions;

public class ChiselListener implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockBreak(CustomItemBlockBreakEvent customEvent) {
		if (customEvent.isCancelled())
			return;

		CustomItemStack cStack = customEvent.getCustomItemStack();
		if (!(cStack.getCustomItem() instanceof ChiselAbilities))
			return;

		BlockBreakEvent event = customEvent.getBlockBreakEvent();
		Block block = event.getBlock();
		CustomItem cItem = cStack.getCustomItem();
		ChiselAbilities chisel = (ChiselAbilities) cItem;
		if (!(cItem.getPermissions() instanceof ChiselPermissions))
			return;
		ChiselPermissions perm = (ChiselPermissions) cItem.getPermissions();
		Player player = event.getPlayer();

		if (!PermissionUtils.allowedAction(player, perm.getType(), perm.getChisel()))
			return;

		event.setCancelled(true);

		if (chisel.convertToChiseled(block))
			cStack.reduceDurability(player, 1);
	}

}
