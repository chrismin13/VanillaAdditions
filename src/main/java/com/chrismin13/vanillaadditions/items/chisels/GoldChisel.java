package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class GoldChisel extends AverageChisel {

	public GoldChisel() {
		super(DamageableItem.GOLDEN_PICKAXE, Material.GOLD_PICKAXE.getMaxDurability(), "vanilla_additions:golden_chisel",
				"Golden Chisel", "gold_chisel", Material.GOLD_INGOT);
	}

}
