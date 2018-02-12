package com.chrismin13.vanillaadditions.items.redstone;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.items.AverageTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public class RedstoneItem  extends AverageTexturedTool{

	public RedstoneItem(DamageableItem damageableItem, String customItemIdName, String displayName,
			String textureName) {
		super(damageableItem, Material.STONE_SWORD.getMaxDurability(), customItemIdName, displayName, textureName);
	}
}
