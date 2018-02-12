package com.chrismin13.vanillaadditions.items.obsidian;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;

public class ObsidianArmor extends AverageLeatherArmor {
	
	public ObsidianArmor(ArmorType armorType) {
		super(armorType, (armorType.getDiamondMaterial().getMaxDurability() * 4) + 3, "vanilla_additions:obsidian_" + armorType.toString().toLowerCase(), "Obsidian " + armorType.toIngameString(), Color.fromRGB(24, 17, 37),
				Material.OBSIDIAN, MaterialUtils.getBaseArmor(armorType.getIronMaterial()), MaterialUtils.getBaseArmorToughness(armorType.getIronMaterial()));
		addAttribute(AttributeType.GENERIC_KNOCKBACK_RESISTANCE, 0.1, Operation.ADD_NUMBER);
	}
	
}