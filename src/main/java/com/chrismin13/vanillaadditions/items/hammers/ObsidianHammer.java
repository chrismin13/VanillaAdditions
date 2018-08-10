package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianItem;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianHammer extends ObsidianItem implements HammerAbilities {

	public ObsidianHammer() {
		super(DamageableItem.IRON_PICKAXE, "vanilla_additions:obsidian_hammer", "Obsidian Hammer",
				"obsidian_hammer");
		modifyCustomItem(this, Material.OBSIDIAN);
	}

}
