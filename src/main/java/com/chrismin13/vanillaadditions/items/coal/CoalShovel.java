package com.chrismin13.vanillaadditions.items.coal;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class CoalShovel extends CoalItem {

	public CoalShovel() {
		super(DamageableItem.WOODEN_SHOVEL, "vanilla_additions:coal_shovel", "Coal Shovel", "coal_shovel");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.COAL, Material.STICK));
	}

	@Override
	public int getCoalAmount() {
		return 1;
	}

	@Override
	public int getStickAmount() {
		return 2;
	}

}