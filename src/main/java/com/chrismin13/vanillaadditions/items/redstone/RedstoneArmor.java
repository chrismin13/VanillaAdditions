package com.chrismin13.vanillaadditions.items.redstone;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;

public class RedstoneArmor extends AverageLeatherArmor {

	public RedstoneArmor(ArmorType armorType) {
		super(armorType, 0,
				"vanilla_additions:redstone_" + armorType.toString().toLowerCase(),
				"Redstone " + armorType.toIngameString(), Color.fromRGB(205, 0, 0), Material.REDSTONE,
				MaterialUtils.getBaseArmor(armorType.getChainmailMaterial()),
				MaterialUtils.getBaseArmorToughness(armorType.getChainmailMaterial()));
		setUnbreakable(false);
	}
}
