package com.chrismin13.vanillaadditions.items.netherrack;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;

public class NetherrackArmor extends AverageLeatherArmor {

	public NetherrackArmor(ArmorType armorType) {
		super(armorType, armorType.getLeatherMaterial().getMaxDurability() / 2,
				"vanilla_additions:netherrack_" + armorType.toString().toLowerCase(),
				"Netherrack " + armorType.toIngameString(), Color.fromRGB(166, 89, 89), Material.NETHERRACK,
				MaterialUtils.getBaseArmor(armorType.getChainmailMaterial()),
				MaterialUtils.getBaseArmorToughness(armorType.getChainmailMaterial()));
	}
}
