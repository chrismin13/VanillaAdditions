package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.lapis.LapisItem;

import us.fihgu.toolbox.item.DamageableItem;

public class LapisSickle extends LapisItem implements SickleAbilities {

	public LapisSickle() {
		super(DamageableItem.IRON_HOE, "vanilla_additions:lapis_sickle", "Lapis Sickle", "lapis_sickle");

		modifyCustomItem(this, new RecipeIngredient(Material.LAPIS_LAZULI));
	}

	@Override
	public int getBreakRadius() {
		return 3;
	}

}