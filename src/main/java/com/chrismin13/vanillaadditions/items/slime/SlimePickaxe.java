package com.chrismin13.vanillaadditions.items.slime;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimePickaxe extends SlimeItem {

	public SlimePickaxe() {
		super(DamageableItem.WOODEN_PICKAXE, "vanilla_additions:slime_pickaxe", "Slime Pickaxe", "slime_pickaxe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.SLIME_BALL, Material.STICK));
	}

}
