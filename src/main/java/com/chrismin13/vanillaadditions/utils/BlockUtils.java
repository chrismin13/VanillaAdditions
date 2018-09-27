package com.chrismin13.vanillaadditions.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.RegisteredListener;

import com.chrismin13.additionsapi.items.CustomItemStack;

import fr.neatmonster.nocheatplus.checks.blockbreak.BlockBreakListener;

public class BlockUtils {

	public static Boolean ncpLoaded;
	public static RegisteredListener ncpListener;

	public static List<Block> getSquareRadius(Block block, int radius) {
		List<Block> blocks = new ArrayList<Block>();

		World world = block.getWorld();

		int centerX = block.getX();
		int centerY = block.getY();
		int centerZ = block.getZ();

		for (int x = centerX - radius; x < centerX + radius; x++)
			for (int z = centerZ - radius; z < centerZ + radius; z++)
				blocks.add(world.getBlockAt(x, centerY, z));

		return blocks;
	}

	private static ArrayList<Block> blocksBeingBroken = new ArrayList<>();

	public static void addIgnoreBlocks(Block... block) {
		for (Block blockToAdd : block)
			blocksBeingBroken.add(blockToAdd);
	}

	public static void removeIgnoreBlocks(Block... block) {
		for (Block blockToRemove : block)
			if (blocksBeingBroken.contains(blockToRemove))
				blocksBeingBroken.remove(blockToRemove);
	}

	public static ArrayList<Block> getIgnoreBlocks() {
		return blocksBeingBroken;
	}

	public static boolean isBlockIgnored(Block block) {
		return blocksBeingBroken.contains(block);
	}

	public static boolean breakBlock(Block block, CustomItemStack cStack, Player player) {
		return breakBlock(block, cStack, player, false);
	}

	public static boolean breakBlock(Block block, CustomItemStack cStack, Player player, boolean cancelDurability) {
		final Integer currentDurability;
		if (cancelDurability && cStack.getCustomItem().hasFakeDurability())
			currentDurability = cStack.getFakeDurability();
		else
			currentDurability = null;

		addIgnoreBlocks(block);
		BlockBreakEvent event = new BlockBreakEvent(block, player);

		if (ncpLoaded == null) {
			if (Bukkit.getPluginManager().isPluginEnabled("NoCheatPlus") && ncpListener == null) {
				for (RegisteredListener listener : event.getHandlers().getRegisteredListeners()) {
					if (listener.getListener().getClass().equals(BlockBreakListener.class)) {
						ncpListener = listener;
						ncpLoaded = true;
						break;
					}
				}
			} else {
				ncpLoaded = false;
			}
		}

		if (ncpLoaded)
			event.getHandlers().unregister(ncpListener);

		Bukkit.getPluginManager().callEvent(event);

		if (ncpLoaded)
			event.getHandlers().register(ncpListener);

		if (!event.isCancelled())
			if (cStack.getItemStack() != null)
				block.breakNaturally(cStack.getItemStack());
			else
				block.breakNaturally();
		removeIgnoreBlocks(block);
		
		if (currentDurability != null)
			cStack.setFakeDurability(currentDurability);
		
		return !event.isCancelled();
	}
}
