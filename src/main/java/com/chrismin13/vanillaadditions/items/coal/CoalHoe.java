package com.chrismin13.vanillaadditions.items.coal;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class CoalHoe extends CoalItem {

	public CoalHoe() {
		super(DamageableItem.WOODEN_HOE, "vanilla_additions:coal_hoe", "Coal Hoe", "coal_hoe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.COAL, Material.STICK));
	}

	@Override
	public int getCoalAmount() {
		return 2;
	}

	@Override
	public int getStickAmount() {
		return 2;
	}

}
