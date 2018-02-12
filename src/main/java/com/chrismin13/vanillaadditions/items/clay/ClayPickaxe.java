package com.chrismin13.vanillaadditions.items.clay;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ClayPickaxe extends ClayItem {

	public ClayPickaxe() {
		super(DamageableItem.WOODEN_PICKAXE, "vanilla_additions:clay_pickaxe", "Clay Pickaxe", "clay_pickaxe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.CLAY_BALL, Material.STICK));
	}

}
