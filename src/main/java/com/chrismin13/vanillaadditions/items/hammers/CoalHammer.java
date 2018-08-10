package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.coal.CoalItem;

import us.fihgu.toolbox.item.DamageableItem;

public class CoalHammer extends CoalItem implements HammerAbilities {

	public CoalHammer() {
		super(DamageableItem.WOODEN_PICKAXE, "vanilla_additions:coal_hammer", "Coal Hammer",
				"coal_hammer");
		modifyCustomItem(this, Material.COAL);
	}

	@Override
	public int getCoalAmount() {
		return 4;
	}

	@Override
	public int getStickAmount() {
		return 2;
	}

}
