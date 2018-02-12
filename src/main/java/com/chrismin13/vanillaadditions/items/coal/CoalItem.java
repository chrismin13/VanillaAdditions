package com.chrismin13.vanillaadditions.items.coal;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.items.AverageTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public abstract class CoalItem  extends AverageTexturedTool {

	public CoalItem(DamageableItem damageableItem, String customItemIdName, String displayName,
			String textureName) {
		super(damageableItem, Material.STONE_SWORD.getMaxDurability(), customItemIdName, displayName, textureName);
		setBurnTime((getStickAmount() * 100) + (getCoalAmount() * 800));
	}
	
	public abstract int getCoalAmount();
	public abstract int getStickAmount();
}
