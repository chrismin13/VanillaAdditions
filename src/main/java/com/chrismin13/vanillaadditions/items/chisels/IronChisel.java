package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class IronChisel extends AverageChisel {

	public IronChisel() {
		super(DamageableItem.IRON_PICKAXE, Material.IRON_PICKAXE.getMaxDurability(), "vanilla_additions:iron_chisel",
				"Iron Chisel", "iron_chisel", Material.IRON_INGOT);
	}

}
