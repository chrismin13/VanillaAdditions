package com.chrismin13.vanillaadditions.items.endstone;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStoneAxe extends EndStoneItem {

	public EndStoneAxe() {
		super(DamageableItem.STONE_AXE, "vanilla_additions:end_stone_axe", "End Stone Axe", "end_stone_axe");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.END_STONE, Material.STICK));
	}

}
