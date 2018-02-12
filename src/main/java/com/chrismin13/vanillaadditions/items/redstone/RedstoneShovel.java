package com.chrismin13.vanillaadditions.items.redstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneShovel extends RedstoneItem {

	public final String A = "%%__USER__%%REMOVE";
	public final String B = "%%__NONCE__%%REMOVE";
	
	public RedstoneShovel() {
		super(DamageableItem.STONE_SHOVEL, "vanilla_additions:redstone_shovel", "Redstone Shovel", "redstone_shovel");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.REDSTONE, Material.STICK));
	}
}