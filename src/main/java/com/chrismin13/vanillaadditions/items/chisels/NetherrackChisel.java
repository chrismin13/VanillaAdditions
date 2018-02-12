package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackItem;

import us.fihgu.toolbox.item.DamageableItem;

public class NetherrackChisel extends NetherrackItem implements ChiselAbilities {

	public NetherrackChisel() {
		super(DamageableItem.STONE_PICKAXE, "vanilla_additions:netherrack_chisel", "Netherrack Chisel",
				"netherrack_chisel");
		modifyCustomItem(this, Material.NETHERRACK);
	}

}
