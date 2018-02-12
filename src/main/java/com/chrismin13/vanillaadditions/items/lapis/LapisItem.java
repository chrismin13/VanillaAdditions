package com.chrismin13.vanillaadditions.items.lapis;

import org.bukkit.Material;

import com.chrismin13.vanillaadditions.items.AverageTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public class LapisItem extends AverageTexturedTool {

	public LapisItem(DamageableItem damageableItem, String customItemIdName, String displayName,
			String textureName) {
		super(damageableItem, Material.WOOD_SWORD.getMaxDurability(), customItemIdName, displayName, textureName);
	}
}
