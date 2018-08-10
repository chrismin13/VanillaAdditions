package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class StoneHammer extends AverageHammer {

	public StoneHammer() {
		super(DamageableItem.STONE_PICKAXE, Material.STONE_PICKAXE.getMaxDurability(), "vanilla_additions:stone_hammer",
				"Stone Hammer", "stone_hammer", Material.COBBLESTONE);
	}

}
