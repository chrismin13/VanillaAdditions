package com.chrismin13.vanillaadditions.items.endstone;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.items.AverageTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public class EndStoneItem extends AverageTexturedTool {

	public EndStoneItem(DamageableItem damageableItem, String customItemIdName, String displayName,
			String textureName) {
		super(damageableItem, Material.IRON_SWORD.getMaxDurability(), customItemIdName, displayName, textureName);
	}
}
