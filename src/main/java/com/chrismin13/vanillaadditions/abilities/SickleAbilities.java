package com.chrismin13.vanillaadditions.abilities;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import com.chrismin13.vanillaadditions.durability.SickleDurability;
import com.chrismin13.vanillaadditions.utils.BlockUtils;

public interface SickleAbilities {

	@SuppressWarnings("deprecation")
	default void onUse(BlockBreakEvent event, CustomItemStack cStack, Block block, Player player) {
		final Material material = block.getType();

		if (!isBreakable(material))
			return;

		player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
		List<Block> blocks = BlockUtils.getSquareRadius(block, getBreakRadius());
		if (block.getState().getData().getData() == (byte) 0)
			event.setCancelled(true);

		Bukkit.getScheduler().scheduleSyncDelayedTask(VanillaAdditions.getInstance(), () -> {
			block.setType(material);
			block.setData((byte) 0);
		});

		Long delay = 0L;
		for (Block blockToBreak : blocks) {
			if (isBreakable(blockToBreak.getType()) && blockToBreak.getState().getData().getData() != (byte) 0) {
				delay++;
				Bukkit.getScheduler().scheduleSyncDelayedTask(VanillaAdditions.getInstance(), () -> {
					if (isBreakable(blockToBreak.getType())
							&& blockToBreak.getState().getData().getData() != (byte) 0) {
						if (BlockUtils.breakBlock(blockToBreak, cStack, player))
							Bukkit.getScheduler().scheduleSyncDelayedTask(VanillaAdditions.getInstance(), () -> {
								blockToBreak.setType(material);
							});
					}
				}, delay);
			}
		}
	}

	default boolean isBreakable(Material material) {
		switch (material) {
		case CROPS:
		case POTATO:
		case CARROT:
		case BEETROOT_BLOCK:
		case NETHER_WARTS:
			return true;
		default:
			return false;
		}
	}

	default void modifyCustomItem(CustomTool cTool, RecipeIngredient craftingIngredient) {
		cTool.getCustomRecipes().clear();
		cTool.setHoeAbilities(false);
		cTool.addCustomRecipe(new CustomShapedRecipe().setShape("010", "001", "210")
				.setIngredient('1', craftingIngredient).setIngredient('2', Material.STICK));
		cTool.addCustomRecipe(new CustomShapedRecipe().setShape("010", "100", "012")
				.setIngredient('1', craftingIngredient).setIngredient('2', Material.STICK));
		cTool.setDurabilityMechanics(new SickleDurability());
	}

	public int getBreakRadius();

}
