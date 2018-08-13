package com.chrismin13.vanillaadditions.items.doubleaxes;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.DoubleAxeAbilities;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianItem;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianDoubleAxe extends ObsidianItem implements DoubleAxeAbilities {

	public ObsidianDoubleAxe() {
		super(DamageableItem.IRON_AXE, "vanilla_additions:obsidian_double_axe", "Obsidian Double Axe",
				"obsidian_double_axe");
		modifyCustomItem(this, Material.OBSIDIAN);
	}

}
