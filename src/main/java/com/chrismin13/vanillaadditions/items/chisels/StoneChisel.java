package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class StoneChisel extends AverageChisel {

	public StoneChisel() {
		super(DamageableItem.STONE_PICKAXE, Material.STONE_PICKAXE.getMaxDurability(), "vanilla_additions:stone_chisel",
				"Stone Chisel", "stone_chisel", Material.COBBLESTONE);
	}

}
