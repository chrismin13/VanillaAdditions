package com.chrismin13.vanillaadditions.items.obsidian;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianAxe extends ObsidianItem {

	public ObsidianAxe() {
		super(DamageableItem.IRON_AXE, "vanilla_additions:obsidian_axe", "Obsidian Axe", "obsidian_axe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.OBSIDIAN, Material.STICK));
	}

}
