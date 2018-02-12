package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.slime.SlimeItem;
import com.comphenix.attribute.Attributes.Attribute;
import com.comphenix.attribute.Attributes.AttributeType;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimeDoubleAxe extends SlimeItem implements DoubleAxeAbilities {

	public SlimeDoubleAxe() {
		super(DamageableItem.WOODEN_AXE, "vanilla_additions:slime_double_axe", "Slime Double Axe",
				"slime_double_axe");
		addCustomRecipe(getRecipe(new RecipeIngredient(Material.SLIME_BALL), new RecipeIngredient(Material.STICK)));
		for (Attribute attribute : getAttributes()) {
			if (attribute.getAttributeType().equals(AttributeType.GENERIC_ATTACK_SPEED)) {
				attribute.setAmount(getAttackSpeed(getMaterial()) - 4D);
			}
		}
	}

}
