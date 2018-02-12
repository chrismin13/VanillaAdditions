package com.chrismin13.vanillaadditions.items.obsidian;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianShovel extends ObsidianItem {

	public ObsidianShovel() {
		super(DamageableItem.IRON_SHOVEL, "vanilla_additions:obsidian_shovel", "Obsidian Shovel", "obsidian_shovel");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.OBSIDIAN, Material.STICK));
	}

}