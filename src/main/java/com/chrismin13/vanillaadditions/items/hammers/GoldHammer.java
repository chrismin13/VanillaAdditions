package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class GoldHammer extends AverageHammer {

	public GoldHammer() {
		super(DamageableItem.GOLDEN_PICKAXE, Material.GOLD_PICKAXE.getMaxDurability(), "vanilla_additions:golden_hammer",
				"Golden Hammer", "gold_hammer", Material.GOLD_INGOT);
	}

}
