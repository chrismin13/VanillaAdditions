package com.chrismin13.vanillaadditions.abilities;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import com.chrismin13.vanillaadditions.utils.BlockUtils;

public interface HammerAbilities {

	boolean onlyBreakSameType = VanillaAdditions.getInstance().getConfig().getBoolean("hammer.only-break-same-type");
	
	default void onUse(Block block, BlockFace face, CustomItemStack cStack, Player player) {
		ArrayList<Block> blocks = new ArrayList<>();
		switch (face) {
		case UP:
		case DOWN:
			blocks.add(block.getRelative(1, 0, 0));
			blocks.add(block.getRelative(1, 0, 1));
			blocks.add(block.getRelative(1, 0, -1));
			blocks.add(block.getRelative(-1, 0, 0));
			blocks.add(block.getRelative(-1, 0, 1));
			blocks.add(block.getRelative(-1, 0, -1));
			blocks.add(block.getRelative(0, 0, 1));
			blocks.add(block.getRelative(0, 0, -1));
			break;
		case WEST:
		case EAST:
			blocks.add(block.getRelative(0, 1, 0));
			blocks.add(block.getRelative(0, 1, 1));
			blocks.add(block.getRelative(0, 1, -1));
			blocks.add(block.getRelative(0, -1, 0));
			blocks.add(block.getRelative(0, -1, 1));
			blocks.add(block.getRelative(0, -1, -1));
			blocks.add(block.getRelative(0, 0, 1));
			blocks.add(block.getRelative(0, 0, -1));
			break;
		case NORTH:
		case SOUTH:
			blocks.add(block.getRelative(1, 0, 0));
			blocks.add(block.getRelative(1, 1, 0));
			blocks.add(block.getRelative(1, -1, 0));
			blocks.add(block.getRelative(-1, 0, 0));
			blocks.add(block.getRelative(-1, 1, 0));
			blocks.add(block.getRelative(-1, -1, 0));
			blocks.add(block.getRelative(0, 1, 0));
			blocks.add(block.getRelative(0, -1, 0));
			break;
		default:
			break;
		}
		for (Block blockToBreak : blocks) {
			if (shouldBreakBlock(blockToBreak, block.getType(), cStack)) {
				BlockUtils.breakBlock(blockToBreak, cStack, player);
			}
		}
	}

	default boolean shouldBreakBlock(Block blockToBreak, Material originalBlockMaterial, CustomItemStack cStack) {
		if (onlyBreakSameType) {
			return blockToBreak.getType().equals(originalBlockMaterial);
		} else {
			return !blockToBreak.getDrops(cStack.getItemStack()).isEmpty();
		}
	}
	
	default void modifyCustomItem(CustomTool cTool, Material craftingMaterial) {
		modifyCustomItem(cTool, new RecipeIngredient(craftingMaterial));
	}

	default void modifyCustomItem(CustomTool cTool, RecipeIngredient craftingIngredient) {
		cTool.getCustomRecipes().clear();
		cTool.addAllCustomRecipes(getRecipes(craftingIngredient, new RecipeIngredient(Material.STICK)));
		cTool.addAttackSpeed(getAttackSpeed(cTool.getMaterial()));
		cTool.addAttackDamage(getAttackDamage(cTool.getMaterial()));
	}

	default ArrayList<CustomShapedRecipe> getRecipes(RecipeIngredient craftingIngredient,
			RecipeIngredient recipeIngredient) {
		CustomShapedRecipe recipe = new CustomShapedRecipe().setShape("111", "120", "020")
				.setIngredient('1', craftingIngredient).setIngredient('2', recipeIngredient);
		ArrayList<CustomShapedRecipe> recipes = new ArrayList<>();
		recipes.add(recipe);
		recipes.add(new CustomShapedRecipe(recipe).setShape("111", "021", "020"));
		return recipes;
	}

	default float getAttackSpeed(Material material) {
		return MaterialUtils.getBaseSpeed(material) - 0.3F;
	}

	default float getAttackDamage(Material material) {
		return MaterialUtils.getBaseDamage(material) + 2F;
	}
}
