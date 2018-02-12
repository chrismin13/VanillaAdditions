package com.chrismin13.vanillaadditions.items.prismarine;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class PrismarineHoe extends PrismarineItem {

	public PrismarineHoe() {
		super(DamageableItem.DIAMOND_HOE, "vanilla_additions:prismarine_hoe", "Prismarine Hoe", "prismarine_hoe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.PRISMARINE_SHARD, Material.STICK));
	}

}
