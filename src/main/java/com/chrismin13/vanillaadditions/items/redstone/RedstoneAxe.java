package com.chrismin13.vanillaadditions.items.redstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneAxe extends RedstoneItem {

	public RedstoneAxe() {
		super(DamageableItem.STONE_AXE, "vanilla_additions:redstone_axe", "Redstone Axe", "redstone_axe");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.REDSTONE, Material.STICK));
	}

}
