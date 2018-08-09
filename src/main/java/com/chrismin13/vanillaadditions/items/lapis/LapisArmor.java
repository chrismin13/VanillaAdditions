package com.chrismin13.vanillaadditions.items.lapis;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;

public class LapisArmor extends AverageLeatherArmor {

	public LapisArmor(ArmorType armorType) {
		super(armorType, armorType.getLeatherMaterial().getMaxDurability(),
				"vanilla_additions:lapis_" + armorType.toString().toLowerCase(), "Lapis " + armorType.toIngameString(),
				Color.fromRGB(34, 75, 175), new RecipeIngredient(Material.LAPIS_LAZULI), MaterialUtils.getBaseArmor(armorType.getIronMaterial()),
				MaterialUtils.getBaseArmorToughness(armorType.getIronMaterial()));
	}
}
