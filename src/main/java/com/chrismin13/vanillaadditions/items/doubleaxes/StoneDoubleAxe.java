package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class StoneDoubleAxe extends AverageDoubleAxe {

	public StoneDoubleAxe() {
		super(DamageableItem.STONE_AXE, Material.STONE_AXE.getMaxDurability(), "vanilla_additions:stone_double_axe",
				"Stone Double Axe", "stone_double_axe", Material.COBBLESTONE);
	}

}
