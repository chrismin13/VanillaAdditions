package com.chrismin13.vanillaadditions.items.clay;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ClayShovel extends ClayItem {

	public ClayShovel() {
		super(DamageableItem.WOODEN_SHOVEL, "vanilla_additions:clay_shovel", "Clay Shovel", "clay_shovel");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.CLAY_BALL, Material.STICK));
	}

}