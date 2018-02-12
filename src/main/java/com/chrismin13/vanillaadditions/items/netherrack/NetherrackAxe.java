package com.chrismin13.vanillaadditions.items.netherrack;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class NetherrackAxe extends NetherrackItem {

	public NetherrackAxe() {
		super(DamageableItem.STONE_AXE, "vanilla_additions:netherrack_axe", "Netherrack Axe", "netherrack_axe");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.NETHERRACK, Material.STICK));
	}

}
