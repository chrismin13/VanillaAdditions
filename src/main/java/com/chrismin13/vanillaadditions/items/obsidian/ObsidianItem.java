package com.chrismin13.vanillaadditions.items.obsidian;

import org.bukkit.inventory.EquipmentSlot;

import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;

import us.fihgu.toolbox.item.DamageableItem;

public class ObsidianItem extends AverageTexturedTool {

	public ObsidianItem(DamageableItem damageableItem, String customItemIdName, String displayName,
			String textureName) {
		super(damageableItem, 6247, customItemIdName, displayName, textureName);
		addAttackSpeed(MaterialUtils.getBaseSpeed(getMaterial()));
		addAttackDamage(MaterialUtils.getBaseDamage(getMaterial()));
		addAttribute(AttributeType.GENERIC_KNOCKBACK_RESISTANCE, 0.1, EquipmentSlot.HAND, Operation.ADD_NUMBER);
	}
}
