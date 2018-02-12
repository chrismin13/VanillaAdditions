package com.chrismin13.vanillaadditions.items.endstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStonePickaxe extends EndStoneItem {

	public EndStonePickaxe() {
		super(DamageableItem.STONE_PICKAXE, "vanilla_additions:end_stone_pickaxe", "End Stone Pickaxe", "end_stone_pickaxe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.ENDER_STONE, Material.STICK));
	}

}
