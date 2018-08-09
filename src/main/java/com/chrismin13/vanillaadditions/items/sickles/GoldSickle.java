package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class GoldSickle extends AverageSickle {

	public GoldSickle() {
		super(DamageableItem.GOLDEN_HOE, Material.GOLDEN_HOE.getMaxDurability(), "vanilla_additions:golden_sickle",
				"Golden Sickle", "gold_sickle", Material.GOLD_INGOT);
	}

	@Override
	public int getBreakRadius() {
		return 4;
	}

}
