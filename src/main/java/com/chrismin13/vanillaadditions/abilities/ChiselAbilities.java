package com.chrismin13.vanillaadditions.abilities;

import org.bukkit.Material;
import org.bukkit.SandstoneType;
import org.bukkit.block.Block;

import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.permissions.ItemPermissions;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.permissions.ChiselPermissions;

public interface ChiselAbilities {

	@SuppressWarnings("deprecation")
	default void convertToChiseled(Block block) {
		Material type = block.getType();
		byte data = block.getData();
		if (type == Material.SANDSTONE) {
			if (data == (byte) 0) {
				block.setTypeIdAndData(Material.SANDSTONE.getId(), SandstoneType.GLYPHED.getData(), true);
			} else if (data == SandstoneType.GLYPHED.getData()) {
				block.setTypeIdAndData(Material.SANDSTONE.getId(), (byte) 0, true);
			}
		} else if (type == Material.MONSTER_EGGS) {
			if (data == (byte) 2) {
				block.setTypeIdAndData(Material.MONSTER_EGGS.getId(), (byte) 5, true);
			} else if (data == (byte) 5) {
				block.setTypeIdAndData(Material.MONSTER_EGGS.getId(), (byte) 2, true);
			}
		} else if (type == Material.SMOOTH_BRICK) {
			if (data == (byte) 0) {
				block.setTypeIdAndData(Material.SMOOTH_BRICK.getId(), (byte) 3, true);
			} else if (data == (byte) 3) {
				block.setTypeIdAndData(Material.SMOOTH_BRICK.getId(), (byte) 0, true);
			}
		} else if (type == Material.QUARTZ_BLOCK) {
			if (data == (byte) 0) {
				block.setTypeIdAndData(Material.QUARTZ_BLOCK.getId(), (byte) 1, true);
			} else if (data == (byte) 1) {
				block.setTypeIdAndData(Material.QUARTZ_BLOCK.getId(), (byte) 0, true);
			}
		} else if (type == Material.RED_SANDSTONE) {
			if (data == (byte) 0) {
				block.setTypeIdAndData(Material.RED_SANDSTONE.getId(), (byte) 1, true);
			} else if (data == (byte) 1) {
				block.setTypeIdAndData(Material.RED_SANDSTONE.getId(), (byte) 0, true);
			}
		} else if (type.toString().endsWith("GLAZED_TERRACOTTA")) {
			if (data < (byte) 3)
				block.setData((byte) (data + 1));
			else
				block.setData((byte) 0);
		} else if (type.equals(Material.HUGE_MUSHROOM_1) || type
				.equals(Material.HUGE_MUSHROOM_2)) {
			if (data < (byte) 10)
				block.setData((byte) (data + 1));
			else if (data < (byte) 14)
				block.setData((byte) 14);
			else if (data < (byte) 15)
				block.setData((byte) 15);
			else
				block.setData((byte) 0);
		}
	}

	default void modifyCustomItem(CustomTool cTool, Material craftingMaterial) {
		modifyCustomItem(cTool, new RecipeIngredient(craftingMaterial));
	}

	default void modifyCustomItem(CustomTool cTool, RecipeIngredient craftingIngredient) {
		cTool.getCustomRecipes().clear();
		cTool.addCustomRecipe(getRecipe(craftingIngredient, new RecipeIngredient(Material.STICK)));
		ItemPermissions perm = cTool.getPermissions();
		cTool.setPermissions(new ChiselPermissions(perm.getPermissionPrefix(), perm.getType()));
	}

	default CustomShapedRecipe getRecipe(RecipeIngredient craftingIngredient, RecipeIngredient recipeIngredient) {
		return new CustomShapedRecipe().setShape("1", "2").setIngredient('1', craftingIngredient).setIngredient('2',
				recipeIngredient);
	}
}
