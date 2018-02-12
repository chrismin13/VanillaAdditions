package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public class AverageChisel extends AverageTexturedTool implements ChiselAbilities {

	public AverageChisel(DamageableItem damageableItem, int fakeDurability, String customItemIdName,
			String displayName, String textureName, Material craftingIngredient) {
		super(damageableItem, fakeDurability, customItemIdName, displayName, textureName);
		
		modifyCustomItem(this, craftingIngredient);
	}

}
