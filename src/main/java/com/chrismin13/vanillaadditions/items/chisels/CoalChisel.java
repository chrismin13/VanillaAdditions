package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.coal.CoalItem;

import us.fihgu.toolbox.item.DamageableItem;

public class CoalChisel extends CoalItem implements ChiselAbilities {

	public CoalChisel() {
		super(DamageableItem.WOODEN_PICKAXE, "vanilla_additions:coal_chisel", "Coal Chisel",
				"coal_chisel");
		modifyCustomItem(this, Material.COAL);
	}

	@Override
	public int getCoalAmount() {
		return 1;
	}

	@Override
	public int getStickAmount() {
		return 1;
	}

}
