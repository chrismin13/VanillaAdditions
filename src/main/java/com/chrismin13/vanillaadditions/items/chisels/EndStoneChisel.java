package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneItem;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStoneChisel extends EndStoneItem implements ChiselAbilities {

	public EndStoneChisel() {
		super(DamageableItem.STONE_PICKAXE, "vanilla_additions:end_stone_chisel", "End Stone Chisel",
				"end_stone_chisel");
		modifyCustomItem(this, Material.ENDER_STONE);
	}

}
