package com.chrismin13.vanillaadditions.items.slime;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimeHoe extends SlimeItem {

	public SlimeHoe() {
		super(DamageableItem.WOODEN_HOE, "vanilla_additions:slime_hoe", "Slime Hoe", "slime_hoe");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.SLIME_BALL, Material.STICK));
	}

}
