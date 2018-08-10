package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackItem;

import us.fihgu.toolbox.item.DamageableItem;

public class NetherrackHammer extends NetherrackItem implements HammerAbilities {

	public NetherrackHammer() {
		super(DamageableItem.STONE_PICKAXE, "vanilla_additions:netherrack_hammer", "Netherrack Hammer",
				"netherrack_hammer");
		modifyCustomItem(this, Material.NETHERRACK);
	}

}
