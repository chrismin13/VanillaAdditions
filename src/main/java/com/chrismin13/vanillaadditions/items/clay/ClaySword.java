package com.chrismin13.vanillaadditions.items.clay;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ClaySword extends ClayItem {

	public ClaySword() {
		super(DamageableItem.WOODEN_SWORD, "vanilla_additions:clay_sword", "Clay Sword", "clay_sword");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.CLAY_BALL, Material.STICK));
	}

}
