package com.chrismin13.vanillaadditions.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.items.CustomItemStack;

public class CraftingRemover implements Listener {
/**
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPrepareCrafting(PrepareItemCraftEvent event) {
		Recipe recipe = event.getRecipe();
		if (recipe == null || recipe.getResult() == null)
			return;
		Material result = recipe.getResult().getType();
		CraftingInventory inv = event.getInventory();
		ItemStack[] matrix = inv.getContents();
		if ((result.equals(Material.WOODEN_SWORD) || result.equals(Material.WOODEN_AXE)
				|| result.equals(Material.WOODEN_PICKAXE) || result.equals(Material.WOODEN_SPADE)
				|| result.equals(Material.WOODEN_HOE)) && !AdditionsAPI.isCustomItem(inv.getResult())) {
			Byte woodType = null;
			for (int slot = 0; slot < matrix.length - 1; slot++) {
				if (matrix[slot] != null) {
					Material maybeWood = matrix[slot].getType();
					if (maybeWood.equals(Material.ACACIA_WOOD) || maybeWood.equals(Material.BIRCH_WOOD)
							|| maybeWood.equals(Material.DARK_OAK_WOOD) || maybeWood.equals(Material.OAK_WOOD)
							|| maybeWood.equals(Material.SPRUCE_WOOD) || maybeWood.equals(Material.JUNGLE_WOOD)) {
						if (woodType == null) {
							woodType = matrix[slot].getData().getData();
						} else if (!woodType.equals(matrix[slot].getData().getData())) {
							inv.setResult(new ItemStack(Material.AIR));
							return;
						}
					}
				}
			}
			if (woodType == null)
				return;
			// Creates the ID of the Custom Item, gets it and sets it.
			String idString = "vanilla_additions:" + MaterialUtils.getWoodType(woodType) + "_"
					+ result.toString().toLowerCase().replace("wood", "wooden").replace("spade", "shovel");
			inv.setResult(new CustomItemStack(idString).getItemStack());
		}
	}
*/
}
