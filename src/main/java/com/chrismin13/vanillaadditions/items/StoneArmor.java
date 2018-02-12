package com.chrismin13.vanillaadditions.items;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.abilities.StoneArmorAbilities;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;

public class StoneArmor extends AverageLeatherArmor implements StoneArmorAbilities {

	public StoneArmor(ArmorType armorType) {
		super(armorType, 0,
				"vanilla_additions:stone_" + armorType.toString().toLowerCase(), "Stone " + armorType.toIngameString(),
				Color.fromRGB(103, 103,  103), Material.COBBLESTONE,
				MaterialUtils.getBaseArmor(armorType.getChainmailMaterial()),
				MaterialUtils.getBaseArmorToughness(armorType.getChainmailMaterial()));
		modifyCustomItem(this);
		setUnbreakable(false);
	}
}
