package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.lapis.LapisItem;

import us.fihgu.toolbox.item.DamageableItem;

public class LapisHammer extends LapisItem implements HammerAbilities {

	public LapisHammer() {
		super(DamageableItem.IRON_PICKAXE, "vanilla_additions:lapis_hammer", "Lapis Hammer", "lapis_hammer");
		modifyCustomItem(this, new RecipeIngredient(Material.LAPIS_LAZULI));
	}

}
