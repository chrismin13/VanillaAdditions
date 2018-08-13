package com.chrismin13.vanillaadditions.durability;

import org.bukkit.Material;

import com.chrismin13.additionsapi.durability.ItemDurability;

public class SickleDurability extends ItemDurability {

	public SickleDurability() {
		addSpecialBlock(Material.WHEAT, 1);
		addSpecialBlock(Material.CARROTS, 1);
		addSpecialBlock(Material.POTATOES, 1);
		addSpecialBlock(Material.BEETROOTS, 1);
		addSpecialBlock(Material.NETHER_WART, 1);
		setBlockBreak(1);
		setEntityHit(2);
	}
	
}
