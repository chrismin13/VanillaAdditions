package com.chrismin13.vanillaadditions.items.sickles;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.SickleAbilities;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneItem;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStoneSickle extends EndStoneItem implements SickleAbilities {

	public EndStoneSickle() {
		super(DamageableItem.STONE_HOE, "vanilla_additions:end_stone_sickle", "End Stone Sickle", "end_stone_sickle");

		modifyCustomItem(this, new RecipeIngredient(Material.END_STONE));
	}

	@Override
	public int getBreakRadius() {
		return 2;
	}

}