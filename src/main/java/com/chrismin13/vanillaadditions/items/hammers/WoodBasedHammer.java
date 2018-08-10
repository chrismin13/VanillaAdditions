package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;

import us.fihgu.toolbox.item.DamageableItem;

public class WoodBasedHammer extends WoodBasedItem implements HammerAbilities {

	public WoodBasedHammer(Material material, String woodType, String textureName, String displayName) {
		super(DamageableItem.WOODEN_PICKAXE, woodType, textureName, displayName, "wooden_hammer");
		
		modifyCustomItem(this, new RecipeIngredient(material));
	}

}
