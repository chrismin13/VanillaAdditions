package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.coal.CoalItem;

import us.fihgu.toolbox.item.DamageableItem;

public class CoalDoubleAxe extends CoalItem implements DoubleAxeAbilities {

	public CoalDoubleAxe() {
		super(DamageableItem.WOODEN_AXE, "vanilla_additions:coal_double_axe", "Coal Double Axe",
				"coal_double_axe");
		modifyCustomItem(this, Material.COAL);
	}

	@Override
	public int getCoalAmount() {
		return 5;
	}

	@Override
	public int getStickAmount() {
		return 2;
	}

}
