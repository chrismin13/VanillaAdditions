package com.chrismin13.vanillaadditions.items.endstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStoneSword extends EndStoneItem {

	public EndStoneSword() {
		super(DamageableItem.STONE_SWORD, "vanilla_additions:end_stone_sword", "End Stone Sword", "end_stone_sword");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.ENDER_STONE, Material.STICK));
	}

}
