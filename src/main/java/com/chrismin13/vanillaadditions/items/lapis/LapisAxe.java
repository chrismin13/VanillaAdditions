package com.chrismin13.vanillaadditions.items.lapis;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;

import us.fihgu.toolbox.item.DamageableItem;

public class LapisAxe extends LapisItem {

	public LapisAxe() {
		super(DamageableItem.IRON_AXE, "vanilla_additions:lapis_axe", "Lapis Axe", "lapis_axe");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.LAPIS_LAZULI), new RecipeIngredient(Material.STICK)));
	}
}
