package com.chrismin13.vanillaadditions.items.emerald;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldPickaxe extends EmeraldItem {

	public EmeraldPickaxe() {
		super(DamageableItem.DIAMOND_PICKAXE, "vanilla_additions:emerald_pickaxe", "Emerald Pickaxe", "emerald_pickaxe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.EMERALD, Material.STICK));
	}

}
