package com.chrismin13.vanillaadditions.items.clay;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ClayHoe extends ClayItem {

	public ClayHoe() {
		super(DamageableItem.WOODEN_HOE, "vanilla_additions:clay_hoe", "Clay Hoe", "clay_hoe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.CLAY_BALL, Material.STICK));
	}

}
