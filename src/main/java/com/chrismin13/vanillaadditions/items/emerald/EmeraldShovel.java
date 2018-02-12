package com.chrismin13.vanillaadditions.items.emerald;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldShovel extends EmeraldItem {

	public EmeraldShovel() {
		super(DamageableItem.DIAMOND_SHOVEL, "vanilla_additions:emerald_shovel", "Emerald Shovel", "emerald_shovel");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.EMERALD, Material.STICK));
	}

}