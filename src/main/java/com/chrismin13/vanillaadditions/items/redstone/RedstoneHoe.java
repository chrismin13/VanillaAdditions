package com.chrismin13.vanillaadditions.items.redstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneHoe extends RedstoneItem {

	public RedstoneHoe() {
		super(DamageableItem.STONE_HOE, "vanilla_additions:redstone_hoe", "Redstone Hoe", "redstone_hoe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.REDSTONE, Material.STICK));
	}

}
