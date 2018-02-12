package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.clay.ClayItem;

import us.fihgu.toolbox.item.DamageableItem;

public class ClayDoubleAxe extends ClayItem implements DoubleAxeAbilities {

	public ClayDoubleAxe() {
		super(DamageableItem.WOODEN_AXE, "vanilla_additions:clay_double_axe", "Clay Double Axe",
				"clay_double_axe");
		modifyCustomItem(this, Material.CLAY_BALL);
	}

}
