package com.chrismin13.vanillaadditions.items.netherrack;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class NetherrackPickaxe extends NetherrackItem {

	public NetherrackPickaxe() {
		super(DamageableItem.STONE_PICKAXE, "vanilla_additions:netherrack_pickaxe", "Netherrack Pickaxe", "netherrack_pickaxe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.NETHERRACK, Material.STICK));
	}

}
