package com.chrismin13.vanillaadditions.items;

import org.bukkit.Material;

import com.chrismin13.additionsapi.items.textured.CustomTexturedBow;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;

public class EnderBow extends CustomTexturedBow {

	public EnderBow() {
		super(1, "vanilla_additions:ender_bow", "ender_bow");

		setDisplayName("Ender Bow");
		setUnbreakable(true);
		setUnbreakableVisibility(false);
		setFakeDurability(50);
		setEnchantable(true);
		setCombinedInCrafting(true);
		
		addCustomRecipe(new CustomShapedRecipe().setShape("020", "212", "020")
				.setIngredient('1', Material.BOW).setIngredient('2', Material.ENDER_PEARL));
	}

}
