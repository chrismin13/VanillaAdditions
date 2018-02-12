package com.chrismin13.vanillaadditions.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;

public class MobUtils {

	public static boolean spawnSlime(Block block, BlockFace face) {
		// Get the coordinates of the block
		Double x = (double) block.getX();
		Double y = (double) block.getY();
		Double z = (double) block.getZ();
		World world = block.getWorld();
		// Check the BlockFace and accordingly change the coordinates
		switch (face) {
		case UP:
			y = y + 1.0D;
			break;
		case DOWN:
			y = y - 1.0D;
			break;
		case EAST:
			x = x + 1.0D;
			break;
		case WEST:
			x = x - 1.0D;
			break;
		case SOUTH:
			z = z + 1.0D;
			break;
		case NORTH:
			z = z - 1.0D;
			break;
		default:
			break;
		}
		// Correct the coordiates so that they will be in the center of the
		// block
		x = x + 0.5;
		z = z + 0.5;
		// Make a new location
		Location location = new Location(world, x, y, z);
		// Get the block there
		Block newblock = location.getBlock();
		// Check if the block is "safe" for the Slime to spawn
		if (newblock.getType() != Material.AIR && !newblock.isLiquid())
			return false;
		// Spawn the slime and resize it
		Slime slime = (Slime) world.spawnEntity(location, EntityType.SLIME);
		slime.setSize(1);
		return true;
	}
	
}
