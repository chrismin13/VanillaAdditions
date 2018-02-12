package com.chrismin13.vanillaadditions.items.endstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStoneShovel extends EndStoneItem {

	public EndStoneShovel() {
		super(DamageableItem.STONE_SHOVEL, "vanilla_additions:end_stone_shovel", "End Stone Shovel", "end_stone_shovel");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.ENDER_STONE, Material.STICK));
	}

}