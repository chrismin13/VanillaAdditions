package com.chrismin13.vanillaadditions.items.wood;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedItem extends AverageTexturedTool {

	public WoodBasedItem(DamageableItem damageableItem, byte materialData, String woodType, String textureName,
			String displayName, String originalToolName) {
		super(damageableItem, 59, "vanilla_additions:" + woodType + "_" + originalToolName,
				displayName, textureName);
	}
	
	public WoodBasedItem(DamageableItem damageableItem, byte materialData, String woodType, String textureName, String displayName) {
		super(damageableItem, 59, "vanilla_additions:" + woodType + "_" + damageableItem.toString().toLowerCase(),
				displayName, textureName);
		
		addAllCustomRecipes(getToolType().getCustomShapedRecipe(new RecipeIngredient(Material.WOOD, materialData),
				new RecipeIngredient(Material.STICK)));
	}

}
