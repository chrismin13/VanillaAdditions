package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class IronHammer extends AverageHammer {

	public IronHammer() {
		super(DamageableItem.IRON_PICKAXE, Material.IRON_PICKAXE.getMaxDurability(), "vanilla_additions:iron_hammer",
				"Iron Hammer", "iron_hammer", Material.IRON_INGOT);
	}

}
