package com.chrismin13.vanillaadditions.items.slime;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimeSword extends SlimeItem {

	public SlimeSword() {
		super(DamageableItem.WOODEN_SWORD, "vanilla_additions:slime_sword", "Slime Sword", "slime_sword");

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.SLIME_BALL, Material.STICK));
	}

}
