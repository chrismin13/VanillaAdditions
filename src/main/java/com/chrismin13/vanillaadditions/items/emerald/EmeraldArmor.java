package com.chrismin13.vanillaadditions.items.emerald;

import org.bukkit.Color;
import org.bukkit.Material;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageLeatherArmor;

public class EmeraldArmor extends AverageLeatherArmor {

	public EmeraldArmor(ArmorType armorType) {
		super(armorType, (armorType.getDiamondMaterial().getMaxDurability() * 2) + 1, "vanilla_additions:emerald_" + armorType.toString().toLowerCase(), "Emerald " + armorType.toIngameString(), Color.fromRGB(0,255, 76),
				Material.EMERALD, MaterialUtils.getBaseArmor(armorType.getDiamondMaterial()), MaterialUtils.getBaseArmorToughness(armorType.getDiamondMaterial()));
	}
}
