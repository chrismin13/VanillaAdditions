package com.chrismin13.vanillaadditions.items.redstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class RedstonePickaxe extends RedstoneItem {

	public RedstonePickaxe() {
		super(DamageableItem.STONE_PICKAXE, "vanilla_additions:redstone_pickaxe", "Redstone Pickaxe", "redstone_pickaxe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.REDSTONE, Material.STICK));
	}

}
