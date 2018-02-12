package com.chrismin13.vanillaadditions.items.coal;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class CoalPickaxe extends CoalItem {

	public CoalPickaxe() {
		super(DamageableItem.WOODEN_PICKAXE, "vanilla_additions:coal_pickaxe", "Coal Pickaxe", "coal_pickaxe");

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
