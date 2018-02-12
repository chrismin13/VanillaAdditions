package com.chrismin13.vanillaadditions.items.obsidian;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianPickaxe extends ObsidianItem {

	public ObsidianPickaxe() {
		super(DamageableItem.IRON_PICKAXE, "vanilla_additions:obsidian_pickaxe", "Obsidian Pickaxe", "obsidian_pickaxe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.OBSIDIAN, Material.STICK));
	}

}
