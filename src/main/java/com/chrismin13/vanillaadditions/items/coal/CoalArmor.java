package com.chrismin13.vanillaadditions.items.coal;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;

public class CoalArmor extends AverageLeatherArmor {

	public CoalArmor(ArmorType armorType) {
		super(armorType, 0, "vanilla_additions:coal_" + armorType.toString().toLowerCase(),
				"Coal " + armorType.toIngameString(), Color.fromRGB(46, 46, 46), Material.COAL,
				MaterialUtils.getBaseArmor(armorType.getLeatherMaterial()),
				MaterialUtils.getBaseArmorToughness(armorType.getLeatherMaterial()));
		setUnbreakable(false);
	}
}
