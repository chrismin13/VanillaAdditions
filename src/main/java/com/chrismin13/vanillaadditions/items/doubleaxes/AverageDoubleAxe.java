package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public class AverageDoubleAxe extends AverageTexturedTool implements DoubleAxeAbilities {

	public AverageDoubleAxe(DamageableItem damageableItem, int fakeDurability, String customItemIdName,
			String displayName, String textureName, Material craftingIngredient) {
		super(damageableItem, fakeDurability, customItemIdName, displayName, textureName);
		
		modifyCustomItem(this, craftingIngredient);
	}

}
