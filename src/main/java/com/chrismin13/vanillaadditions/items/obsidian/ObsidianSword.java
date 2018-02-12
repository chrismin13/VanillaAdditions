package com.chrismin13.vanillaadditions.items.obsidian;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianSword extends ObsidianItem {

	public ObsidianSword() {
		super(DamageableItem.IRON_SWORD, "vanilla_additions:obsidian_sword", "Obsidian Sword", "obsidian_sword");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.OBSIDIAN, Material.STICK));
	}

}
