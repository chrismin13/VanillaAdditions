package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;

import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedSickle extends WoodBasedItem implements SickleAbilities {

	public WoodBasedSickle(byte materialData, String woodType, String textureName, String displayName) {
		super(DamageableItem.WOODEN_HOE, materialData, woodType, textureName, displayName, "wooden_sickle");

		modifyCustomItem(this, new RecipeIngredient(Material.WOOD, materialData));
	}

	@Override
	public int getBreakRadius() {
		return 1;
	}

}
