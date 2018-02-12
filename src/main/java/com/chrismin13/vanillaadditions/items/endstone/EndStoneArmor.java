package com.chrismin13.vanillaadditions.items.endstone;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.abilities.StoneArmorAbilities;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;

public class EndStoneArmor extends AverageLeatherArmor implements StoneArmorAbilities {

	public EndStoneArmor(ArmorType armorType) {
		super(armorType, armorType.getIronMaterial().getMaxDurability(),
				"vanilla_additions:end_stone_" + armorType.toString().toLowerCase(),
				"End Stone " + armorType.toIngameString(), Color.fromRGB(237, 237, 154), Material.ENDER_STONE,
				MaterialUtils.getBaseArmor(armorType.getChainmailMaterial()),
				MaterialUtils.getBaseArmorToughness(armorType.getChainmailMaterial()));
		modifyCustomItem(this);
	}
}
