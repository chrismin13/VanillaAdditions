package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneItem;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStoneHammer extends EndStoneItem implements HammerAbilities {

	public EndStoneHammer() {
		super(DamageableItem.STONE_PICKAXE, "vanilla_additions:end_stone_hammer", "End Stone Hammer",
				"end_stone_hammer");
		modifyCustomItem(this, Material.ENDER_STONE);
	}

}
