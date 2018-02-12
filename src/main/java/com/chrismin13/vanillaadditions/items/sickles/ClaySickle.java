package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.clay.ClayItem;

import us.fihgu.toolbox.item.DamageableItem;

public class ClaySickle extends ClayItem implements SickleAbilities {

	public ClaySickle() {
		super(DamageableItem.WOODEN_HOE, "vanilla_additions:clay_sickle", "Clay Sickle", "clay_sickle");

		modifyCustomItem(this, new RecipeIngredient(Material.CLAY_BALL));
	}

	@Override
	public int getBreakRadius() {
		return 1;
	}

}