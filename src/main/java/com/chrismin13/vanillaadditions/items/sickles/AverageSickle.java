package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.durability.SickleDurability;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public abstract class AverageSickle extends AverageTexturedTool implements SickleAbilities {
	public AverageSickle(DamageableItem damageableItem, int fakeDurability, String customItemIdName, String displayName,
			String textureName, RecipeIngredient craftingIngredient) {
		super(damageableItem, fakeDurability, customItemIdName, displayName, textureName);

		modifyCustomItem(this, craftingIngredient);
		setDurabilityMechanics(new SickleDurability());
	}

	public AverageSickle(DamageableItem damageableItem, int fakeDurability, String customItemIdName, String displayName,
			String textureName, Material craftingMaterial) {
		this(damageableItem, fakeDurability, customItemIdName, displayName, textureName,
				new RecipeIngredient(craftingMaterial));
	}
}