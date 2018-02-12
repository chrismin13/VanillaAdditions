package com.chrismin13.vanillaadditions.items.prismarine;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class PrismarinePickaxe extends PrismarineItem {

	public PrismarinePickaxe() {
		super(DamageableItem.DIAMOND_PICKAXE, "vanilla_additions:prismarine_pickaxe", "Prismarine Pickaxe", "prismarine_pickaxe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.PRISMARINE_SHARD, Material.STICK));
	}

}
