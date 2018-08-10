package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class DiamondHammer extends AverageHammer {

	public DiamondHammer() {
		super(DamageableItem.DIAMOND_PICKAXE, Material.DIAMOND_PICKAXE.getMaxDurability(), "vanilla_additions:diamond_hammer",
				"Diamond Hammer", "diamond_hammer", Material.DIAMOND);
	}

}
