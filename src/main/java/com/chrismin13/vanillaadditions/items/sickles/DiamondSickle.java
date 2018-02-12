package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class DiamondSickle extends AverageSickle {

	public DiamondSickle() {
		super(DamageableItem.DIAMOND_HOE, Material.DIAMOND_HOE.getMaxDurability(), "vanilla_additions:diamond_sickle",
				"Diamond Sickle", "diamond_sickle", Material.DIAMOND);
	}

	@Override
	public int getBreakRadius() {
		return 5;
	}

}
