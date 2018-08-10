package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneItem;

import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneHammer extends RedstoneItem implements HammerAbilities {

	public RedstoneHammer() {
		super(DamageableItem.STONE_PICKAXE, "vanilla_additions:redstone_hammer", "Redstone Hammer",
				"redstone_hammer");
		modifyCustomItem(this, Material.REDSTONE);
	}

}
