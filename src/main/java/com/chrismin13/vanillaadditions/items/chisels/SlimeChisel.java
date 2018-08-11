package com.chrismin13.vanillaadditions.items.chisels;

import org.bukkit.Material;

import com.chrismin13.additionsapi.recipes.RecipeIngredient;
import com.chrismin13.vanillaadditions.abilities.ChiselAbilities;
import com.chrismin13.vanillaadditions.items.slime.SlimeItem;

import us.fihgu.toolbox.item.DamageableItem;

public class SlimeChisel extends SlimeItem implements ChiselAbilities {

	public SlimeChisel() {
		super(DamageableItem.WOODEN_PICKAXE, "vanilla_additions:slime_chisel", "Slime Chisel",
				"slime_chisel");
		modifyCustomItem(this, Material.SLIME_BALL);
	}

}
