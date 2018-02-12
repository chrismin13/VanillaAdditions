package com.chrismin13.vanillaadditions.items.slime;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;

public class SlimeArmor extends AverageLeatherArmor {

	public SlimeArmor(ArmorType armorType) {
		super(armorType, armorType.getGoldMaterial().getMaxDurability(),
				"vanilla_additions:slime_" + armorType.toString().toLowerCase(), "Slime " + armorType.toIngameString(),
				Color.fromRGB(125, 200, 115), Material.SLIME_BALL,
				MaterialUtils.getBaseArmor(armorType.getLeatherMaterial()),
				MaterialUtils.getBaseArmorToughness(armorType.getLeatherMaterial()));
		addAttribute(AttributeType.GENERIC_KNOCKBACK_RESISTANCE, -0.1, Operation.ADD_NUMBER);
	}
}
