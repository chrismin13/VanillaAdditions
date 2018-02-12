package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;

import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedChisel extends WoodBasedItem implements ChiselAbilities {

	public WoodBasedChisel(byte materialData, String woodType, String textureName, String displayName) {
		super(DamageableItem.WOODEN_PICKAXE, materialData, woodType, textureName, displayName, "wooden_chisel");
		
		modifyCustomItem(this, new RecipeIngredient(Material.WOOD, materialData));
	}

}
