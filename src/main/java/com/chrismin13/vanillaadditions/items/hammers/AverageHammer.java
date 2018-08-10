package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public class AverageHammer extends AverageTexturedTool implements HammerAbilities {

	public AverageHammer(DamageableItem damageableItem, int fakeDurability, String customItemIdName,
			String displayName, String textureName, Material craftingIngredient) {
		super(damageableItem, fakeDurability, customItemIdName, displayName, textureName);
		
		modifyCustomItem(this, craftingIngredient);
	}

}
