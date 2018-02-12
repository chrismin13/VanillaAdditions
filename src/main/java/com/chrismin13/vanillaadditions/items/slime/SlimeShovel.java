package com.chrismin13.vanillaadditions.items.slime;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimeShovel extends SlimeItem {

	public SlimeShovel() {
		super(DamageableItem.WOODEN_SHOVEL, "vanilla_additions:slime_shovel", "Slime Shovel", "slime_shovel");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.SLIME_BALL, Material.STICK));
	}

}