package com.chrismin13.vanillaadditions.items.netherrack;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class NetherrackShovel extends NetherrackItem {

	public NetherrackShovel() {
		super(DamageableItem.STONE_SHOVEL, "vanilla_additions:netherrack_shovel", "Netherrack Shovel", "netherrack_shovel");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.NETHERRACK, Material.STICK));
	}

}