package com.chrismin13.vanillaadditions.items.clay;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ClayAxe extends ClayItem {

	public ClayAxe() {
		super(DamageableItem.WOODEN_AXE, "vanilla_additions:clay_axe", "Clay Axe", "clay_axe");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.CLAY_BALL, Material.STICK));
	}

}
