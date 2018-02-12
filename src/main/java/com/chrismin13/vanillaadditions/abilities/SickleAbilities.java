package com.chrismin13.vanillaadditions.abilities;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.items.CustomTool;
import com.chrismin13.additionsapi.recipes.CustomShapedRecipe;
import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import com.chrismin13.vanillaadditions.utils.BlockUtils;

public interface SickleAbilities {

	@SuppressWarnings("deprecation")
	default void onUse(CustomItemStack cStack, Block block, Player player) {
		int m = block.getTypeId();
		if (m == 59 || m == 141 || m == 142 || m == 207) {
			player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
			List<Block> blocks = BlockUtils.getSquareRadius(block, getBreakRadius());

			Long delay = 0L;
			World world = block.getWorld();

			for (Block b : blocks) {
				int material = b.getTypeId();
				if (material == 59 || material == 141 || material == 142 || material == 207) {
					delay++;
					cStack.reduceDurability(player,
							cStack.getCustomItem().getDurabilityMechanics().getBlockBreak(block));
					Bukkit.getScheduler().scheduleSyncDelayedTask(VanillaAdditions.getInstance(), () -> {
						if (b.getTypeId() == material) {
							b.breakNaturally();
							// if (useParticleLIB)
							// ParticleEffect.BLOCK_CRACK.sendData(players,
							// b.getX(), b.getY(), b.getZ(), 2, 2, 2, 1,
							// 100, material, (byte) 0x01);
							world.playSound(b.getLocation(), Sound.BLOCK_GRASS_BREAK, 1.0F, 1.0F);
						}
					}, delay);
				}
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
