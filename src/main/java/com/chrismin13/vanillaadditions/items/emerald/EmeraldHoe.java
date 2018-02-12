package com.chrismin13.vanillaadditions.items.emerald;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldHoe extends EmeraldItem {

	public EmeraldHoe() {
		super(DamageableItem.DIAMOND_HOE, "vanilla_additions:emerald_hoe", "Emerald Hoe", "emerald_hoe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.EMERALD, Material.STICK));
	}

}
