package com.chrismin13.vanillaadditions.items.prismarine;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class PrismarineShovel extends PrismarineItem {

	public PrismarineShovel() {
		super(DamageableItem.DIAMOND_SHOVEL, "vanilla_additions:prismarine_shovel", "Prismarine Shovel", "prismarine_shovel");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.PRISMARINE_SHARD, Material.STICK));
	}

}