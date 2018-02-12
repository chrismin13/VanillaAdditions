package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackItem;

import us.fihgu.toolbox.item.DamageableItem;

public class NetherrackDoubleAxe extends NetherrackItem implements DoubleAxeAbilities {

	public NetherrackDoubleAxe() {
		super(DamageableItem.STONE_AXE, "vanilla_additions:netherrack_double_axe", "Netherrack Double Axe",
				"netherrack_double_axe");
		modifyCustomItem(this, Material.NETHERRACK);
	}

}
