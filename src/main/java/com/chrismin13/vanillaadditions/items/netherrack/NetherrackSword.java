package com.chrismin13.vanillaadditions.items.netherrack;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class NetherrackSword extends NetherrackItem {

	public NetherrackSword() {
		super(DamageableItem.STONE_SWORD, "vanilla_additions:netherrack_sword", "Netherrack Sword", "netherrack_sword");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.NETHERRACK, Material.STICK));
	}

}
