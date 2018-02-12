package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldItem;

import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldDoubleAxe extends EmeraldItem implements DoubleAxeAbilities {

	public EmeraldDoubleAxe() {
		super(DamageableItem.DIAMOND_AXE, "vanilla_additions:emerald_double_axe", "Emerald Double Axe",
				"emerald_double_axe");
		modifyCustomItem(this, Material.EMERALD);
	}

}
