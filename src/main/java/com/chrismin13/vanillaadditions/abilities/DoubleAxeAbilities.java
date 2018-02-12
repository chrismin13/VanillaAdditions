package com.chrismin13.vanillaadditions.abilities;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.utils.TreeFeller;

public interface DoubleAxeAbilities {

	default void chopTree(Player player, Block block, CustomItemStack cStack) {
		TreeFeller.chop(block, player, cStack);
	}

	default void modifyCustomItem(CustomTool cTool, Material craftingMaterial) {
		modifyCustomItem(cTool, new RecipeIngredient(craftingMaterial));
	}
	
	default void modifyCustomItem(CustomTool cTool, RecipeIngredient craftingIngredient) {
		cTool.getCustomRecipes().clear();
		cTool.addAttackSpeed(getAttackSpeed(cTool.getMaterial()));
		cTool.addAttackDamage(MaterialUtils.getBaseDamage(cTool.getMaterial()));
		cTool.addCustomRecipe(getRecipe(craftingIngredient, new RecipeIngredient(Material.STICK)));
	}

	default float getAttackSpeed(Material material) {
		return MaterialUtils.getBaseSpeed(material) - 0.3F;
	}
	
	default CustomShapedRecipe getRecipe(RecipeIngredient craftingIngredient, RecipeIngredient recipeIngredient) {
		return new CustomShapedRecipe().setShape("111", "121", "020").setIngredient('1', craftingIngredient)
				.setIngredient('2', recipeIngredient);
	}
}
