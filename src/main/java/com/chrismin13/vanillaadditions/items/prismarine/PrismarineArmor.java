package com.chrismin13.vanillaadditions.items.prismarine;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;

public class PrismarineArmor extends AverageLeatherArmor {

	public PrismarineArmor(ArmorType armorType) {
		super(armorType, armorType.getIronMaterial().getMaxDurability(),
				"vanilla_additions:prismarine_" + armorType.toString().toLowerCase(),
				"Prismarine " + armorType.toIngameString(), Color.fromRGB(116, 183, 179), Material.PRISMARINE_SHARD,
				MaterialUtils.getBaseArmor(armorType.getDiamondMaterial()),
				MaterialUtils.getBaseArmorToughness(armorType.getDiamondMaterial()));
	}
}
