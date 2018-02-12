package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.clay.ClayItem;

import us.fihgu.toolbox.item.DamageableItem;

public class ClayChisel extends ClayItem implements ChiselAbilities {

	public ClayChisel() {
		super(DamageableItem.WOODEN_PICKAXE, "vanilla_additions:clay_chisel", "Clay Chisel",
				"clay_chisel");
		modifyCustomItem(this, Material.CLAY_BALL);
	}

}
