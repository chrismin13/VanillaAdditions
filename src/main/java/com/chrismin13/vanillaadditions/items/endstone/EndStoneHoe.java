package com.chrismin13.vanillaadditions.items.endstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStoneHoe extends EndStoneItem {

	public EndStoneHoe() {
		super(DamageableItem.STONE_HOE, "vanilla_additions:end_stone_hoe", "End Stone Hoe", "end_stone_hoe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.END_STONE, Material.STICK));
	}

}
