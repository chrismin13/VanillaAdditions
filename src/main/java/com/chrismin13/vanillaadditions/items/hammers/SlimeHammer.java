package com.chrismin13.vanillaadditions.items.hammers;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.abilities.HammerAbilities;
import com.chrismin13.vanillaadditions.items.slime.SlimeItem;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimeHammer extends SlimeItem implements HammerAbilities {

	public SlimeHammer() {
		super(DamageableItem.WOODEN_PICKAXE, "vanilla_additions:slime_hammer", "Slime Hammer",
				"slime_hammer");
		modifyCustomItem(this, Material.SLIME_BALL);
	}

}
