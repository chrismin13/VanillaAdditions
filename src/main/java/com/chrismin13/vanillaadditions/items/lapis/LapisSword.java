package com.chrismin13.vanillaadditions.items.lapis;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;

import us.fihgu.toolbox.item.DamageableItem;

public class LapisSword extends LapisItem {

	public LapisSword() {
		super(DamageableItem.IRON_SWORD, "vanilla_additions:lapis_sword", "Lapis Sword", "lapis_sword");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.INK_SACK, (byte) 4), new RecipeIngredient(Material.STICK)));
	}
}
