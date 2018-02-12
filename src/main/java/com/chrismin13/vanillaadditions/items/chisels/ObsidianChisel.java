package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianItem;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianChisel extends ObsidianItem implements ChiselAbilities {

	public ObsidianChisel() {
		super(DamageableItem.IRON_PICKAXE, "vanilla_additions:obsidian_chisel", "Obsidian Chisel",
				"obsidian_chisel");
		addCustomRecipe(getRecipe(new RecipeIngredient(Material.OBSIDIAN), new RecipeIngredient(Material.STICK)));
	}

}
