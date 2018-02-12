package com.chrismin13.vanillaadditions.items.prismarine;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class PrismarineSword extends PrismarineItem {

	public PrismarineSword() {
		super(DamageableItem.DIAMOND_SWORD, "vanilla_additions:prismarine_sword", "Prismarine Sword", "prismarine_sword");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.PRISMARINE_SHARD, Material.STICK));
	}

}
