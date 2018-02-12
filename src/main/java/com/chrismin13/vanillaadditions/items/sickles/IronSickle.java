package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class IronSickle extends AverageSickle {

	public IronSickle() {
		super(DamageableItem.IRON_HOE, Material.IRON_HOE.getMaxDurability(), "vanilla_additions:iron_sickle",
				"Iron Sickle", "iron_sickle", Material.IRON_INGOT);
	}

	@Override
	public int getBreakRadius() {
		return 3;
	}

}
