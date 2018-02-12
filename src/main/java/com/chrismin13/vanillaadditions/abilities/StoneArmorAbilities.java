package com.chrismin13.vanillaadditions.abilities;

import com.chrismin13.additionsapi.items.CustomArmor;
import com.comphenix.attribute.Attributes.AttributeType;
import com.comphenix.attribute.Attributes.Operation;

public interface StoneArmorAbilities {

	default void modifyCustomItem(CustomArmor cArmor) {
		cArmor.addAttribute(AttributeType.GENERIC_MOVEMENT_SPEED, -0.08F, Operation.ADD_PERCENTAGE);
	}
	
}
