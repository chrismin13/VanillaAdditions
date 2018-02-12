package com.chrismin13.vanillaadditions.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.block.Block;

public class BlockUtils {
	public static List<Block> getSquareRadius(Block block, int radius) {
		List<Block> blocks = new ArrayList<Block>();

		World world = block.getWorld();

		int centerX = block.getX();
		int centerY = block.getY();
		int centerZ = block.getZ();

		for (int x = centerX - radius; x < centerX + radius; x++) {
			for (int y = centerY - radius; y < centerY + radius; y++) {
				for (int z = centerZ - radius; z < centerZ + radius; z++) {
					blocks.add(world.getBlockAt(x, y, z));
				}
			}
		}

		return blocks;
	}	
}
