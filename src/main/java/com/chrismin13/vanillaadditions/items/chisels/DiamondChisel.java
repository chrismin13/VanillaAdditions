package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class DiamondChisel extends AverageChisel {

	public DiamondChisel() {
		super(DamageableItem.DIAMOND_PICKAXE, Material.DIAMOND_PICKAXE.getMaxDurability(), "vanilla_additions:diamond_chisel",
				"Diamond Chisel", "diamond_chisel", Material.DIAMOND);
	}

}
