package com.chrismin13.vanillaadditions.items;

import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

import com.chrismin13.additionsapi.items.textured.CustomTexturedItem;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimeBucket extends CustomTexturedItem {

	public SlimeBucket() {
		super(DamageableItem.DIAMOND_HOE, "vanilla_additions:slime_bucket", "slime_bucket");
		// TEXTURES
		addTexture("jumping_slime_bucket");
		
		setUnbreakable(true);
		setDisplayName("Slime Bucket");
		setHoeAbilities(false);
		addAttribute(AttributeType.GENERIC_ATTACK_DAMAGE, 1.0D, EquipmentSlot.HAND, Operation.ADD_NUMBER);
		setAttributeVisibility(false);
		setUnbreakableVisibility(false);
		
		// CRAFTING RECIPE
		CustomShapedRecipe recipe = new CustomShapedRecipe().setIngredient('1', Material.SLIME_BALL).setIngredient('2', Material.BUCKET);
		addCustomRecipe(new CustomShapedRecipe(recipe).setShape("111", "111", "020"));
	}

	
	
}
