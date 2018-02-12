package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class IronDoubleAxe extends AverageDoubleAxe {

	public IronDoubleAxe() {
		super(DamageableItem.IRON_AXE, Material.IRON_AXE.getMaxDurability(), "vanilla_additions:iron_double_axe",
				"Iron Double Axe", "iron_double_axe", Material.IRON_INGOT);
	}

}
