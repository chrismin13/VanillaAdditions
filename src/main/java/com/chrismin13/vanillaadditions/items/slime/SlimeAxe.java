package com.chrismin13.vanillaadditions.items.slime;

import org.bukkit.Material;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimeAxe extends SlimeItem {

	public SlimeAxe() {
		super(DamageableItem.WOODEN_AXE, "vanilla_additions:slime_axe", "Slime Axe", "slime_axe");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(Material.SLIME_BALL, Material.STICK));
	}

}
