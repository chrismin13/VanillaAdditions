package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineItem;

import us.fihgu.toolbox.item.DamageableItem;

public class PrismarineDoubleAxe extends PrismarineItem implements DoubleAxeAbilities {

	public PrismarineDoubleAxe() {
		super(DamageableItem.DIAMOND_AXE, "vanilla_additions:prismarine_double_axe", "Prismarine Double Axe",
				"prismarine_double_axe");
		modifyCustomItem(this, Material.PRISMARINE_SHARD);
	}

}
