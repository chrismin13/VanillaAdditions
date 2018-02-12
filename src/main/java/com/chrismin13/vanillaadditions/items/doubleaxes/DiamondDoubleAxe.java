package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class DiamondDoubleAxe extends AverageDoubleAxe {

	public DiamondDoubleAxe() {
		super(DamageableItem.DIAMOND_AXE, Material.DIAMOND_AXE.getMaxDurability(), "vanilla_additions:diamond_double_axe",
				"Diamond Double Axe", "diamond_double_axe", Material.DIAMOND);
	}

}
