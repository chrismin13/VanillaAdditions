package com.chrismin13.vanillaadditions.durability;

import org.bukkit.Material;

import com.chrismin13.additionsapi.durability.ItemDurability;

public class SickleDurability extends ItemDurability {

	public SickleDurability() {
		addSpecialBlock(Material.CROPS, 1);
		addSpecialBlock(Material.CARROT, 1);
		addSpecialBlock(Material.POTATO, 1);
		addSpecialBlock(Material.BEETROOT_BLOCK, 1);
		addSpecialBlock(Material.NETHER_WARTS, 1);
		setBlockBreak(1);
		setEntityHit(2);
	}
	
}
