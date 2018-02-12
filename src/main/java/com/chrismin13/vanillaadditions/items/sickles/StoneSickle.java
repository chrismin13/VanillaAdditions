package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class StoneSickle extends AverageSickle {

	public StoneSickle() {
		super(DamageableItem.STONE_HOE, Material.STONE_HOE.getMaxDurability(), "vanilla_additions:stone_sickle",
				"Stone Sickle", "stone_sickle", Material.COBBLESTONE);
	}

	@Override
	public int getBreakRadius() {
		return 2;
	}

}
