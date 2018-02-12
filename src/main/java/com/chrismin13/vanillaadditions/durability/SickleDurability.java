package com.chrismin13.vanillaadditions.durability;

import org.bukkit.Material;

import com.chrismin13.additionsapi.durability.ItemDurability;

public class SickleDurability extends ItemDurability {

	@SuppressWarnings("deprecation")
	public SickleDurability() {
		addSpecialBlock(Material.getMaterial(59), 1);
		addSpecialBlock(Material.getMaterial(141), 1);
		addSpecialBlock(Material.getMaterial(142), 1);
		addSpecialBlock(Material.getMaterial(207), 1);
		setBlockBreak(1);
		setEntityHit(2);
	}
	
}
