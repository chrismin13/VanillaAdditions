package com.chrismin13.vanillaadditions.items;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.items.CustomLeatherArmor;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;

public class AverageLeatherArmor extends CustomLeatherArmor {

	public AverageLeatherArmor(ArmorType armorType, int fakeDurability, String customItemIdName, String displayName,
			Color color) {
		super(armorType, 1, (short) 0, customItemIdName, color);

		// Properties
		setDisplayName(displayName);
		setUnbreakable(true);
		setFakeDurability(fakeDurability);
		setEnchantable(true);
		setUnbreakableVisibility(false);
		setCombinedInCrafting(true);
	}

	public AverageLeatherArmor(ArmorType armorType, int fakeDurability, String customItemIdName, String displayName,
			Color color, RecipeIngredient recipeIngredient) {
		this(armorType, fakeDurability, customItemIdName, displayName, color);

		addAllCustomRecipes(getArmorType().getCustomShapedRecipe(recipeIngredient));
	}

	public AverageLeatherArmor(ArmorType armorType, int fakeDurability, String customItemIdName, String displayName,
			Color color, RecipeIngredient recipeIngredient, double armor, double armorToughness) {
		this(armorType, fakeDurability, customItemIdName, displayName, color, recipeIngredient);

		addArmor(armor);
		addArmorToughness(armorToughness);
	}
	
	public AverageLeatherArmor(ArmorType armorType, int fakeDurability, String customItemIdName, String displayName,
			Color color, Material material) {
		this(armorType, fakeDurability, customItemIdName, displayName, color);

		addAllCustomRecipes(getArmorType().getCustomShapedRecipe(material));
	}

	public AverageLeatherArmor(ArmorType armorType, int fakeDurability, String customItemIdName, String displayName,
			Color color, Material material, double armor, double armorToughness) {
		this(armorType, fakeDurability, customItemIdName, displayName, color, material);

		addArmor(armor);
		addArmorToughness(armorToughness);
	}
}
