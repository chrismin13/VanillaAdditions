package com.chrismin13.vanillaadditions.items.lapis;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;

import us.fihgu.toolbox.item.DamageableItem;

public class LapisPickaxe extends LapisItem {

	public LapisPickaxe() {
		super(DamageableItem.IRON_PICKAXE, "vanilla_additions:lapis_pickaxe", "Lapis Pickaxe", "lapis_pickaxe");
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.LAPIS_LAZULI), new RecipeIngredient(Material.STICK)));
	}
}
