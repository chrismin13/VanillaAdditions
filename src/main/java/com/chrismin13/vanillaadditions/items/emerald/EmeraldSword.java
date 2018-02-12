package com.chrismin13.vanillaadditions.items.emerald;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldSword extends EmeraldItem {

	public EmeraldSword() {
		super(DamageableItem.DIAMOND_SWORD, "vanilla_additions:emerald_sword", "Emerald Sword", "emerald_sword");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.EMERALD, Material.STICK));
	}

}
