package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldItem;

import us.fihgu.toolbox.item.DamageableItem;

public class EmeraldChisel extends EmeraldItem implements ChiselAbilities {

	public EmeraldChisel() {
		super(DamageableItem.DIAMOND_PICKAXE, "vanilla_additions:emerald_chisel", "Emerald Chisel",
				"emerald_chisel");
		modifyCustomItem(this, Material.EMERALD);
	}

}
