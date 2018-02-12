package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldItem;

import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldSickle extends EmeraldItem implements SickleAbilities {

	public EmeraldSickle() {
		super(DamageableItem.DIAMOND_HOE, "vanilla_additions:emerald_sickle",
				"Emerald Sickle", "emerald_sickle");
		
		modifyCustomItem(this, new RecipeIngredient(Material.EMERALD));
	}

	@Override
	public int getBreakRadius() {
		return 5;
	}

}
