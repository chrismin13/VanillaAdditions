package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineItem;

import us.fihgu.toolbox.item.DamageableItem;

public class PrismarineSickle extends PrismarineItem implements SickleAbilities {

	public PrismarineSickle() {
		super(DamageableItem.DIAMOND_HOE, "vanilla_additions:prismarine_sickle", "Prismarine Sickle",
				"prismarine_sickle");

		modifyCustomItem(this, new RecipeIngredient(Material.PRISMARINE_SHARD));
	}

	@Override
	public int getBreakRadius() {
		return 5;
	}

}
