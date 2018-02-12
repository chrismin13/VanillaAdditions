package com.chrismin13.vanillaadditions.items.netherrack;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class NetherrackHoe extends NetherrackItem {

	public NetherrackHoe() {
		super(DamageableItem.STONE_HOE, "vanilla_additions:netherrack_hoe", "Netherrack Hoe", "netherrack_hoe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.NETHERRACK, Material.STICK));
	}

}
