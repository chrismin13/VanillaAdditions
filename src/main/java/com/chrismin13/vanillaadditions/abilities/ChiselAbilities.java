package com.chrismin13.vanillaadditions.abilities;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;

import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.permissions.ItemPermissions;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.permissions.ChiselPermissions;

public interface ChiselAbilities {

	default boolean convertToChiseled(Block block) {
		Material type = block.getType();
		if (type == Material.SANDSTONE) {
			block.setType(Material.CHISELED_SANDSTONE);
		} else if (type == Material.CHISELED_SANDSTONE) {
			block.setType(Material.SANDSTONE);
		} else if (type == Material.INFESTED_STONE_BRICKS) {
			block.setType(Material.INFESTED_CHISELED_STONE_BRICKS);
		} else if (type == Material.INFESTED_CHISELED_STONE_BRICKS) {
			block.setType(Material.INFESTED_STONE_BRICKS);
		} else if (type == Material.STONE_BRICKS) {
			block.setType(Material.CHISELED_STONE_BRICKS);
		} else if (type == Material.CHISELED_STONE_BRICKS) {
			block.setType(Material.STONE_BRICKS);
		} else if (type == Material.QUARTZ_BLOCK) {
			block.setType(Material.CHISELED_QUARTZ_BLOCK);
		} else if (type == Material.CHISELED_QUARTZ_BLOCK) {
			block.setType(Material.QUARTZ_BLOCK);
		} else if (type == Material.RED_SANDSTONE) {
			block.setType(Material.CHISELED_RED_SANDSTONE);
		} else if (type == Material.CHISELED_RED_SANDSTONE) {
			block.setType(Material.RED_SANDSTONE);
		} else if (block.getBlockData() instanceof Directional) {
			Directional data = (Directional) block.getBlockData();
			BlockFace[] faces = (BlockFace[]) data.getFaces().toArray();
			int facesSize = faces.length;
			BlockFace face = data.getFacing();
			int currentFace = 0;

			for (BlockFace faceFromSet : faces) {
				if (faceFromSet.equals(face)) {
					break;
				}
				currentFace++;
			}

			if (currentFace < facesSize) {
				data.setFacing(faces[currentFace + 1]);
			} else {
				data.setFacing(faces[0]);
			}
			block.setBlockData(data);
		} else {
			return false;
		}
		return true;
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
