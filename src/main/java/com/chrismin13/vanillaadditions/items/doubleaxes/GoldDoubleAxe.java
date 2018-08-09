package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class GoldDoubleAxe extends AverageDoubleAxe {

	public GoldDoubleAxe() {
		super(DamageableItem.GOLDEN_AXE, Material.GOLDEN_AXE.getMaxDurability(), "vanilla_additions:golden_double_axe",
				"Golden Double Axe", "gold_double_axe", Material.GOLD_INGOT);
	}

}
