package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianItem;
import com.comphenix.attribute.Attributes.Attribute;
import com.comphenix.attribute.Attributes.AttributeType;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianDoubleAxe extends ObsidianItem implements DoubleAxeAbilities {

	public ObsidianDoubleAxe() {
		super(DamageableItem.IRON_AXE, "vanilla_additions:obsidian_double_axe", "Obsidian Double Axe",
				"obsidian_double_axe");
		addCustomRecipe(getRecipe(new RecipeIngredient(Material.OBSIDIAN), new RecipeIngredient(Material.STICK)));
		for (Attribute attribute : getAttributes()) {
			if (attribute.getAttributeType().equals(AttributeType.GENERIC_ATTACK_SPEED)) {
				attribute.setAmount(getAttackSpeed(getMaterial()) - 4D);
			}
		}
	}

}
