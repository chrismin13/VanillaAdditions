package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneItem;

import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneDoubleAxe extends RedstoneItem implements DoubleAxeAbilities {

	public RedstoneDoubleAxe() {
		super(DamageableItem.STONE_AXE, "vanilla_additions:redstone_double_axe", "Redstone Double Axe",
				"redstone_double_axe");
		modifyCustomItem(this, Material.REDSTONE);
	}

}
