package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneItem;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStoneDoubleAxe extends EndStoneItem implements DoubleAxeAbilities {

	public EndStoneDoubleAxe() {
		super(DamageableItem.STONE_AXE, "vanilla_additions:end_stone_double_axe", "End Stone Double Axe",
				"end_stone_double_axe");
		modifyCustomItem(this, Material.END_STONE);
	}

}
