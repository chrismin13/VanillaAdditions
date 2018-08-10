package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineItem;

import us.fihgu.toolbox.item.DamageableItem;

public class PrismarineHammer extends PrismarineItem implements HammerAbilities {

	public PrismarineHammer() {
		super(DamageableItem.DIAMOND_PICKAXE, "vanilla_additions:prismarine_hammer", "Prismarine Hammer",
				"prismarine_hammer");
		modifyCustomItem(this, Material.PRISMARINE_SHARD);
	}

}