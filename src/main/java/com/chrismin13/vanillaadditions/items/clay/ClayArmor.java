package com.chrismin13.vanillaadditions.items.clay;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;

public class ClayArmor extends AverageLeatherArmor {

	public ClayArmor(ArmorType armorType) {
		super(armorType, armorType.getGoldMaterial().getMaxDurability(),
				"vanilla_additions:clay_" + armorType.toString().toLowerCase(),
				"Clay " + armorType.toIngameString(), Color.fromRGB(165, 169, 185), Material.CLAY_BALL,
				MaterialUtils.getBaseArmor(armorType.getLeatherMaterial()),
				MaterialUtils.getBaseArmorToughness(armorType.getLeatherMaterial()));
	}
}
