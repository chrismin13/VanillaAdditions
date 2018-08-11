package com.chrismin13.vanillaadditions.abilities;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.CropState;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.material.Crops;
import org.bukkit.material.MaterialData;

import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import com.chrismin13.vanillaadditions.listeners.BlockBreakListener;
import com.chrismin13.vanillaadditions.utils.BlockUtils;

public interface SickleAbilities {

	default void onUse(BlockBreakEvent event, CustomItemStack cStack, Block block, Player player) {
		final Material material = block.getType();
		MaterialData md = block.getState().getData();

		if (!(md instanceof Crops))
			return;

		player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
		List<Block> blocks = BlockUtils.getSquareRadius(block, getBreakRadius());
		Crops crops = (Crops) md;
		if (crops.getState().equals(CropState.SEEDED))
			event.setCancelled(true);

		Long delay = 0L;
		for (Block blockToBreak : blocks) {
			if (blockToBreak.getState().getData() instanceof Crops) {
				delay++;

				final boolean toBreak;
				if (!((Crops) blockToBreak.getState().getData()).getState().equals(CropState.SEEDED))
					toBreak = true;
				else
					toBreak = false;

				Bukkit.getScheduler().scheduleSyncDelayedTask(VanillaAdditions.getInstance(), () -> {
					if (blockToBreak.getType() == material && toBreak) {
						BlockBreakListener.blocksBeingBroken.add(blockToBreak);
						BlockBreakEvent newEvent = new BlockBreakEvent(blockToBreak, player);

						Bukkit.getPluginManager().callEvent(newEvent);
						BlockBreakListener.blocksBeingBroken.remove(blockToBreak);
						if (!newEvent.isCancelled()) {
							blockToBreak.breakNaturally(cStack.getItemStack());
							
								Bukkit.getScheduler().scheduleSyncDelayedTask(VanillaAdditions.getInstance(), () -> {
									blockToBreak.setType(material);
								});
						}
					}
				}, delay);
			}
		}
	}

	default void modifyCustomItem(CustomTool cTool, RecipeIngredient craftingIngredient) {
		cTool.getCustomRecipes().clear();
		cTool.setHoeAbilities(false);
		cTool.addCustomRecipe(new CustomShapedRecipe().setShape("010", "001", "210")
				.setIngredient('1', craftingIngredient).setIngredient('2', Material.STICK));
		cTool.addCustomRecipe(new CustomShapedRecipe().setShape("010", "100", "012")
				.setIngredient('1', craftingIngredient).setIngredient('2', Material.STICK));
	}

	public int getBreakRadius();

}
