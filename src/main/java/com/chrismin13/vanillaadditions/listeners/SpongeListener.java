package com.chrismin13.vanillaadditions.listeners;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.chrismin13.vanillaadditions.Items;

public class SpongeListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockPlace(BlockPlaceEvent event) {
		if (event.isCancelled())
			return;
		
		if (Items.config.getStringList("enabled-mechanics") == null)
			return;
		List<String> mechanics = Items.config.getStringList("enabled-mechanics");
		
		Block block = event.getBlock();
		Material type = block.getType();
		Biome biome = block.getBiome();
		Byte durability = block.getData();
		// In Nether
		if (biome == Biome.HELL) {
			// Wet Sponge to Sponge
			if (mechanics.contains("WET_SPONGE_TO_SPONGE") && type == Material.SPONGE && durability == (byte) 1) {
				block.setData((byte) 0, true);
				Location l = block.getLocation();
				block.getWorld().spawnParticle(Particle.SMOKE_LARGE, l.getX() - 0.5D, l.getY() + 0.5, l.getZ() + 0.5D,
						10);
			}
		}
	}

}
