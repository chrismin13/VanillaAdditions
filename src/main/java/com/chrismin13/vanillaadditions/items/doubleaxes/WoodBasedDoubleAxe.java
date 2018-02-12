package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;

import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedDoubleAxe extends WoodBasedItem implements DoubleAxeAbilities {

	public WoodBasedDoubleAxe(byte materialData, String woodType, String textureName, String displayName) {
		super(DamageableItem.WOODEN_AXE, materialData, woodType, textureName, displayName, "wooden_double_axe");
		
		modifyCustomItem(this, new RecipeIngredient(Material.WOOD, materialData));
	}

}
