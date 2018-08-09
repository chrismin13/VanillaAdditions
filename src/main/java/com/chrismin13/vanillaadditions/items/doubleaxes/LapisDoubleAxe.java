package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.lapis.LapisItem;

import us.fihgu.toolbox.item.DamageableItem;

public class LapisDoubleAxe extends LapisItem implements DoubleAxeAbilities {

	public LapisDoubleAxe() {
		super(DamageableItem.IRON_AXE, "vanilla_additions:lapis_double_axe", "Lapis Double Axe", "lapis_double_axe");
		modifyCustomItem(this, new RecipeIngredient(Material.LAPIS_LAZULI));
	}

}
