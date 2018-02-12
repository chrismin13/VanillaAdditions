package com.chrismin13.vanillaadditions.items.obsidian;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianHoe extends ObsidianItem {

	public ObsidianHoe() {
		super(DamageableItem.IRON_HOE, "vanilla_additions:obsidian_hoe", "Obsidian Hoe", "obsidian_hoe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.OBSIDIAN, Material.STICK));
	}

}
