package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneItem;

import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneChisel extends RedstoneItem implements ChiselAbilities {

	public RedstoneChisel() {
		super(DamageableItem.STONE_PICKAXE, "vanilla_additions:redstone_chisel", "Redstone Chisel",
				"redstone_chisel");
		modifyCustomItem(this, Material.REDSTONE);
	}

}
