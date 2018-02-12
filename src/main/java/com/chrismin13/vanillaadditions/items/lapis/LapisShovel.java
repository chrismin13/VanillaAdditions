package com.chrismin13.vanillaadditions.items.lapis;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;

import us.fihgu.toolbox.item.DamageableItem;

public class LapisShovel extends LapisItem {

	public LapisShovel() {
		super(DamageableItem.IRON_SHOVEL, "vanilla_additions:lapis_shovel", "Lapis Shovel", "lapis_shovel");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.INK_SACK, (byte) 4), new RecipeIngredient(Material.STICK)));
	}
}