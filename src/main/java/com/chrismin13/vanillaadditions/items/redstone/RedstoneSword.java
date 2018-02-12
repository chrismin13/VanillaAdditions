package com.chrismin13.vanillaadditions.items.redstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneSword extends RedstoneItem {

	public RedstoneSword() {
		super(DamageableItem.STONE_SWORD, "vanilla_additions:redstone_sword", "Redstone Sword", "redstone_sword");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.REDSTONE, Material.STICK));
	}

}
