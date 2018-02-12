package com.chrismin13.vanillaadditions.items.coal;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class CoalAxe extends CoalItem {

	public CoalAxe() {
		super(DamageableItem.WOODEN_AXE, "vanilla_additions:coal_axe", "Coal Axe", "coal_axe");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.COAL, Material.STICK));
	}

	@Override
	public int getCoalAmount() {
		return 3;
	}

	@Override
	public int getStickAmount() {
		return 2;
	}

}
