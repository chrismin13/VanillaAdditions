package com.chrismin13.vanillaadditions.items.emerald;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldAxe extends EmeraldItem {

	public EmeraldAxe() {
		super(DamageableItem.DIAMOND_AXE, "vanilla_additions:emerald_axe", "Emerald Axe", "emerald_axe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.EMERALD, Material.STICK));
	}

}
