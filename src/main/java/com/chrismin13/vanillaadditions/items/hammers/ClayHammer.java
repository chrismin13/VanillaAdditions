package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.clay.ClayItem;

import us.fihgu.toolbox.item.DamageableItem;

public class ClayHammer extends ClayItem implements HammerAbilities {

	public ClayHammer() {
		super(DamageableItem.WOODEN_PICKAXE, "vanilla_additions:clay_hammer", "Clay Hammer",
				"clay_hammer");
		modifyCustomItem(this, Material.CLAY_BALL);
	}

}
