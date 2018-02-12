package com.chrismin13.vanillaadditions.items;

import org.bukkit.Material;

import com.chrismin13.additionsapi.items.textured.CustomTexturedTool;

import us.fihgu.toolbox.item.DamageableItem;

public class AverageTexturedTool extends CustomTexturedTool {

	public AverageTexturedTool(DamageableItem damageableItem, int fakeDurability, Material itemMaterial,
			Material stickMaterial, String customItemIdName, String displayName, String textureName) {
		this(damageableItem, fakeDurability, customItemIdName, displayName, textureName);

		addAllCustomRecipes(getToolType().getCustomShapedRecipe(itemMaterial, stickMaterial));

	}

	public AverageTexturedTool(DamageableItem damageableItem, int fakeDurability, String customItemIdName,
			String displayName, String textureName) {
		super(damageableItem, customItemIdName, textureName);

		// Properties
		setDisplayName(displayName);
		setUnbreakable(true);
		setFakeDurability(fakeDurability);
		setEnchantable(true);
		setToolLikeAttributes(true);
		setUnbreakableVisibility(false);
		setAttributeVisibility(false);
		setCombinedInCrafting(true);
	}

}
