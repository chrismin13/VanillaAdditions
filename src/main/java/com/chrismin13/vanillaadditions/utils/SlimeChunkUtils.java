package com.chrismin13.vanillaadditions.utils;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Biome;

public class SlimeChunkUtils {

	public static boolean isSlimeChunk(Location location) {
		Chunk chunk = location.getChunk();
		int x = chunk.getX();
		int z = chunk.getZ();
		Long worldSeed = location.getWorld().getSeed();

		Random random = new Random(
				worldSeed + x * x * 4987142 + x * 5947611 + z * z * 4392871L + z * 389711 ^ 0x3AD8025F);
		if (random.nextInt(10) == 0)
			return true;

		Biome biome = location.getBlock().getBiome();
		if (biome.equals(Biome.SWAMP))
			return true;

		return false;
	}
}
