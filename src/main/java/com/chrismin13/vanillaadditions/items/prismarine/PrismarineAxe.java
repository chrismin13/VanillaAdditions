package com.chrismin13.vanillaadditions.items.prismarine;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class PrismarineAxe extends PrismarineItem {

	public PrismarineAxe() {
		super(DamageableItem.DIAMOND_AXE, "vanilla_additions:prismarine_axe", "Prismarine Axe", "prismarine_axe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.PRISMARINE_SHARD, Material.STICK));
	}

}
