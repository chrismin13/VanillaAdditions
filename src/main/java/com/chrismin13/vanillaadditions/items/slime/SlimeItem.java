package com.chrismin13.vanillaadditions.items.slime;

import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;

import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.AverageTexturedTool;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimeItem extends AverageTexturedTool{

	public SlimeItem(DamageableItem damageableItem, String customItemIdName, String displayName,
			String textureName) {
		super(damageableItem, Material.WOOD_SWORD.getMaxDurability(), customItemIdName, displayName, textureName);
		addAttackSpeed(MaterialUtils.getBaseSpeed(getMaterial()));
		addAttackDamage(MaterialUtils.getBaseDamage(getMaterial()));
		addAttribute(AttributeType.GENERIC_KNOCKBACK_RESISTANCE, -0.1, EquipmentSlot.HAND, Operation.ADD_NUMBER);
	}
}
