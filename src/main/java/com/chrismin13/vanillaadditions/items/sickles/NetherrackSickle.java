package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackItem;

import us.fihgu.toolbox.item.DamageableItem;

public class NetherrackSickle extends NetherrackItem implements SickleAbilities {

	public NetherrackSickle() {
		super(DamageableItem.STONE_HOE, "vanilla_additions:netherrack_sickle", "Netherrack Sickle", "netherrack_sickle");

		modifyCustomItem(this, new RecipeIngredient(Material.NETHERRACK));
	}

	@Override
	public int getBreakRadius() {
		return 2;
	}

}
