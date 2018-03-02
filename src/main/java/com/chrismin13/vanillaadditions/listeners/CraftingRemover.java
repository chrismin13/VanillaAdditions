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
import com.chrismin13.vanillaadditions.utils.MaterialUtils;

public class CraftingRemover implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPrepareCrafting(PrepareItemCraftEvent event) {
		Recipe recipe = event.getRecipe();
		if (recipe == null || recipe.getResult() == null)
			return;
		Material result = recipe.getResult().getType();
		CraftingInventory inv = event.getInventory();
		ItemStack[] matrix = inv.getContents();
		if ((result.equals(Material.WOOD_SWORD) || result.equals(Material.WOOD_AXE)
				|| result.equals(Material.WOOD_PICKAXE) || result.equals(Material.WOOD_SPADE)
				|| result.equals(Material.WOOD_HOE)) && !AdditionsAPI.isCustomItem(inv.getResult())) {
			Byte woodType = null;
			for (int slot = 0; slot < matrix.length - 1; slot++) {
				if (matrix[slot] != null && matrix[slot].getType().equals(Material.WOOD)) {
					if (woodType == null) {
						woodType = matrix[slot].getData().getData();
					} else if (!woodType.equals(matrix[slot].getData().getData())) {
						inv.setResult(new ItemStack(Material.AIR));
						return;
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

}
