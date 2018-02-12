package com.chrismin13.vanillaadditions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.text.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;

import com.chrismin13.additionsapi.enums.ArmorType;
import com.chrismin13.additionsapi.events.AdditionsAPIInitializationEvent;
import com.chrismin13.additionsapi.items.CustomItem;
import com.chrismin13.vanillaadditions.items.EnderBow;
import com.chrismin13.vanillaadditions.items.SlimeBucket;
import com.chrismin13.vanillaadditions.items.StoneArmor;
import com.chrismin13.vanillaadditions.items.chisels.ClayChisel;
import com.chrismin13.vanillaadditions.items.chisels.CoalChisel;
import com.chrismin13.vanillaadditions.items.chisels.DiamondChisel;
import com.chrismin13.vanillaadditions.items.chisels.EmeraldChisel;
import com.chrismin13.vanillaadditions.items.chisels.EndStoneChisel;
import com.chrismin13.vanillaadditions.items.chisels.GoldChisel;
import com.chrismin13.vanillaadditions.items.chisels.IronChisel;
import com.chrismin13.vanillaadditions.items.chisels.LapisChisel;
import com.chrismin13.vanillaadditions.items.chisels.NetherrackChisel;
import com.chrismin13.vanillaadditions.items.chisels.ObsidianChisel;
import com.chrismin13.vanillaadditions.items.chisels.PrismarineChisel;
import com.chrismin13.vanillaadditions.items.chisels.RedstoneChisel;
import com.chrismin13.vanillaadditions.items.chisels.SlimeChisel;
import com.chrismin13.vanillaadditions.items.chisels.StoneChisel;
import com.chrismin13.vanillaadditions.items.chisels.WoodBasedChisel;
import com.chrismin13.vanillaadditions.items.clay.ClayArmor;
import com.chrismin13.vanillaadditions.items.clay.ClayAxe;
import com.chrismin13.vanillaadditions.items.clay.ClayHoe;
import com.chrismin13.vanillaadditions.items.clay.ClayPickaxe;
import com.chrismin13.vanillaadditions.items.clay.ClayShovel;
import com.chrismin13.vanillaadditions.items.clay.ClaySword;
import com.chrismin13.vanillaadditions.items.coal.CoalArmor;
import com.chrismin13.vanillaadditions.items.coal.CoalAxe;
import com.chrismin13.vanillaadditions.items.coal.CoalHoe;
import com.chrismin13.vanillaadditions.items.coal.CoalPickaxe;
import com.chrismin13.vanillaadditions.items.coal.CoalShovel;
import com.chrismin13.vanillaadditions.items.coal.CoalSword;
import com.chrismin13.vanillaadditions.items.doubleaxes.ClayDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.CoalDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.DiamondDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.EmeraldDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.EndStoneDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.GoldDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.IronDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.LapisDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.NetherrackDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.ObsidianDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.PrismarineDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.RedstoneDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.SlimeDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.StoneDoubleAxe;
import com.chrismin13.vanillaadditions.items.doubleaxes.WoodBasedDoubleAxe;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldArmor;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldAxe;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldHoe;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldPickaxe;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldShovel;
import com.chrismin13.vanillaadditions.items.emerald.EmeraldSword;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneArmor;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneAxe;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneHoe;
import com.chrismin13.vanillaadditions.items.endstone.EndStonePickaxe;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneShovel;
import com.chrismin13.vanillaadditions.items.endstone.EndStoneSword;
import com.chrismin13.vanillaadditions.items.lapis.LapisArmor;
import com.chrismin13.vanillaadditions.items.lapis.LapisAxe;
import com.chrismin13.vanillaadditions.items.lapis.LapisHoe;
import com.chrismin13.vanillaadditions.items.lapis.LapisPickaxe;
import com.chrismin13.vanillaadditions.items.lapis.LapisShovel;
import com.chrismin13.vanillaadditions.items.lapis.LapisSword;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackArmor;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackAxe;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackHoe;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackPickaxe;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackShovel;
import com.chrismin13.vanillaadditions.items.netherrack.NetherrackSword;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianArmor;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianAxe;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianHoe;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianPickaxe;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianShovel;
import com.chrismin13.vanillaadditions.items.obsidian.ObsidianSword;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineArmor;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineAxe;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineHoe;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarinePickaxe;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineShovel;
import com.chrismin13.vanillaadditions.items.prismarine.PrismarineSword;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneArmor;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneAxe;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneHoe;
import com.chrismin13.vanillaadditions.items.redstone.RedstonePickaxe;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneShovel;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneSword;
import com.chrismin13.vanillaadditions.items.sickles.ClaySickle;
import com.chrismin13.vanillaadditions.items.sickles.CoalSickle;
import com.chrismin13.vanillaadditions.items.sickles.DiamondSickle;
import com.chrismin13.vanillaadditions.items.sickles.EmeraldSickle;
import com.chrismin13.vanillaadditions.items.sickles.EndStoneSickle;
import com.chrismin13.vanillaadditions.items.sickles.GoldSickle;
import com.chrismin13.vanillaadditions.items.sickles.IronSickle;
import com.chrismin13.vanillaadditions.items.sickles.LapisSickle;
import com.chrismin13.vanillaadditions.items.sickles.NetherrackSickle;
import com.chrismin13.vanillaadditions.items.sickles.ObsidianSickle;
import com.chrismin13.vanillaadditions.items.sickles.PrismarineSickle;
import com.chrismin13.vanillaadditions.items.sickles.RedstoneSickle;
import com.chrismin13.vanillaadditions.items.sickles.SlimeSickle;
import com.chrismin13.vanillaadditions.items.sickles.StoneSickle;
import com.chrismin13.vanillaadditions.items.sickles.WoodBasedSickle;
import com.chrismin13.vanillaadditions.items.slime.SlimeArmor;
import com.chrismin13.vanillaadditions.items.slime.SlimeAxe;
import com.chrismin13.vanillaadditions.items.slime.SlimeHoe;
import com.chrismin13.vanillaadditions.items.slime.SlimePickaxe;
import com.chrismin13.vanillaadditions.items.slime.SlimeShovel;
import com.chrismin13.vanillaadditions.items.slime.SlimeSword;
import com.chrismin13.vanillaadditions.items.wood.WoodBasedItem;
import com.chrismin13.vanillaadditions.listeners.CraftingRemover;

import us.fihgu.toolbox.item.DamageableItem;

public class Items implements Listener {

	public static FileConfiguration config;

	@EventHandler
	public void onInitialization(AdditionsAPIInitializationEvent event) {
		event.addResourcePackFromPlugin(VanillaAdditions.getInstance(), "VanillaAdditions-1.1.zip");

		String version = Bukkit.getServer().getVersion();

		// REMOVE VANILLA WOOD RECIPES
		if (version.contains("1.9") || version.contains("1.10") || version.contains("1.11")) {
			List<Material> coincidingMaterials = Arrays.asList(Material.WOOD_SWORD, Material.WOOD_AXE,
					Material.WOOD_PICKAXE, Material.WOOD_SPADE, Material.WOOD_HOE);
			Iterator<Recipe> recipes = Bukkit.recipeIterator();
			while (recipes.hasNext())
				if (coincidingMaterials.contains(recipes.next().getResult().getType()))
					recipes.remove();
		} else {
			Bukkit.getPluginManager().registerEvents(new CraftingRemover(), VanillaAdditions.getInstance());
		}

		for (CustomItem cItem : Arrays.asList(
				// EMERALD ITEM
				new EmeraldSword(), new EmeraldAxe(), new EmeraldPickaxe(), new EmeraldShovel(), new EmeraldHoe(),
				new EmeraldDoubleAxe(), new EmeraldSickle(), new EmeraldChisel(),
				// OBSIDIAN ITEM
				new ObsidianSword(), new ObsidianAxe(), new ObsidianPickaxe(), new ObsidianShovel(), new ObsidianHoe(),
				new ObsidianDoubleAxe(), new ObsidianSickle(), new ObsidianChisel(),
				// END STONE ITEMS
				new EndStoneSword(), new EndStoneAxe(), new EndStonePickaxe(), new EndStoneShovel(), new EndStoneHoe(),
				new EndStoneDoubleAxe(), new EndStoneSickle(), new EndStoneChisel(),
				// NETHERRACK ITEMS
				new NetherrackSword(), new NetherrackAxe(), new NetherrackPickaxe(), new NetherrackShovel(),
				new NetherrackHoe(), new NetherrackDoubleAxe(), new NetherrackSickle(), new NetherrackChisel(),
				// COAL ITEMS
				new CoalSword(), new CoalAxe(), new CoalPickaxe(), new CoalShovel(), new CoalHoe(), new CoalDoubleAxe(),
				new CoalSickle(), new CoalChisel(),
				// LAPIS ITEMS
				new LapisSword(), new LapisAxe(), new LapisPickaxe(), new LapisShovel(), new LapisHoe(),
				new LapisDoubleAxe(), new LapisSickle(), new LapisChisel(),
				// REDSTONE ITEMS
				new RedstoneSword(), new RedstoneAxe(), new RedstonePickaxe(), new RedstoneShovel(), new RedstoneHoe(),
				new RedstoneDoubleAxe(), new RedstoneSickle(), new RedstoneChisel(),
				// PRISMARINE ITEMS
				new PrismarineSword(), new PrismarineAxe(), new PrismarinePickaxe(), new PrismarineShovel(),
				new PrismarineHoe(), new PrismarineDoubleAxe(), new PrismarineSickle(), new PrismarineChisel(),
				// CLAY ITEMS
				new ClaySword(), new ClayAxe(), new ClayPickaxe(), new ClayShovel(), new ClayHoe(), new ClayDoubleAxe(),
				new ClaySickle(), new ClayChisel(),
				// SLIME ITEMS
				new SlimeSword(), new SlimeAxe(), new SlimePickaxe(), new SlimeShovel(), new SlimeHoe(),
				new SlimeDoubleAxe(), new SlimeSickle(), new SlimeChisel(),
				// DOUBLE AXES
				new StoneDoubleAxe(), new IronDoubleAxe(), new GoldDoubleAxe(), new DiamondDoubleAxe(),
				// SICKLES
				new StoneSickle(), new IronSickle(), new GoldSickle(), new DiamondSickle(),
				// CHISELS
				new StoneChisel(), new IronChisel(), new GoldChisel(), new DiamondChisel()))
			event.addCustomItem(cItem);

		for (ArmorType armorType : ArmorType.values()) {
			// EMERALD ARMOR
			event.addCustomItem(new EmeraldArmor(armorType));
			// OBSIDIAN ARMOR
			event.addCustomItem(new ObsidianArmor(armorType));
			// STONE ARMOR
			event.addCustomItem(new StoneArmor(armorType));
			// END STONE ARMOR
			event.addCustomItem(new EndStoneArmor(armorType));
			// NETHERRACK ARMOR
			event.addCustomItem(new NetherrackArmor(armorType));
			// COAL ARMOR
			event.addCustomItem(new CoalArmor(armorType));
			// LAPIS ARMOR
			event.addCustomItem(new LapisArmor(armorType));
			// REDSTONE ARMOR
			event.addCustomItem(new RedstoneArmor(armorType));
			// PRISMARINE ARMOR
			event.addCustomItem(new PrismarineArmor(armorType));
			// CLAY ARMOR
			event.addCustomItem(new ClayArmor(armorType));
			// SLIME ARMOR
			event.addCustomItem(new SlimeArmor(armorType));
		}

		// WOOD TOOLS
		for (String string : Arrays.asList("oak;0;oak", "spruce;1;spruce", "birch;2;birch", "jungle;3;jungle",
				"acacia;4;acacia", "dark_oak;5;big_oak")) {
			String[] split = string.split(";");
			for (DamageableItem dItem : Arrays.asList(DamageableItem.WOODEN_SWORD, DamageableItem.WOODEN_AXE,
					DamageableItem.WOODEN_PICKAXE, DamageableItem.WOODEN_SHOVEL, DamageableItem.WOODEN_HOE)) {
				event.addCustomItem(new WoodBasedItem(dItem, Byte.parseByte(split[1]), split[0],
						split[2] + "_" + dItem.getTextureName(),
						WordUtils.capitalize(split[0].replaceAll("_", " ").toLowerCase() + " "
								+ dItem.toString().replaceAll("_", " ").toLowerCase())));
			}
			// Double Axe
			event.addCustomItem(
					new WoodBasedDoubleAxe(Byte.parseByte(split[1]), split[0], split[2] + "_wood_double_axe",
							WordUtils.capitalize(split[0].replaceAll("_", " ").toLowerCase()) + " Wooden Double Axe"));
			// Sickle
			event.addCustomItem(new WoodBasedSickle(Byte.parseByte(split[1]), split[0], split[2] + "_wood_sickle",
					WordUtils.capitalize(split[0].replaceAll("_", " ").toLowerCase()) + " Wooden Sickle"));
			// Chisel
			event.addCustomItem(new WoodBasedChisel(Byte.parseByte(split[1]), split[0], split[2] + "_wood_chisel",
					WordUtils.capitalize(split[0].replaceAll("_", " ").toLowerCase()) + " Wooden Chisel"));
		}

		// ENDER BOW
		event.addCustomItem(new EnderBow());

		// SLIME BUCKETS
		event.addCustomItem(new SlimeBucket());

		addCustomCraftingRecipes();
	}

	private static void addCustomCraftingRecipes() {

		List<String> recipes = config.getStringList("enabled-recipes");

		// === SLABS TO FULL BLOCKS === //
		if (recipes.contains("SLABS_TO_FULL_BLOCKS")) {
			addHalfSlabCombo(Material.STEP, Material.STONE);
			addHalfSlabCombo(Material.STEP, 3, Material.COBBLESTONE);
			addHalfSlabCombo(Material.STEP, 4, Material.BRICK);
			addHalfSlabCombo(Material.STEP, 6, Material.NETHER_BRICK);
			addHalfSlabCombo(Material.WOOD_STEP, Material.WOOD);
			addHalfSlabCombo(Material.WOOD_STEP, 1, Material.WOOD, 1);
			addHalfSlabCombo(Material.WOOD_STEP, 2, Material.WOOD, 2);
			addHalfSlabCombo(Material.WOOD_STEP, 3, Material.WOOD, 3);
			addHalfSlabCombo(Material.WOOD_STEP, 4, Material.WOOD, 4);
			addHalfSlabCombo(Material.WOOD_STEP, 5, Material.WOOD, 5);
		}

		// === CLAY CONVERSION === //
		if (recipes.contains("CLAY_CONVERSION")) {
			addSingleMaterialToItem(Material.CLAY, Material.CLAY_BALL, 4);
		}

		// === STAIRS TO BLOCK === //
		if (recipes.contains("STAIRS_TO_BLOCKS")) {
			addFourMaterialsToItem(Material.WOOD_STAIRS, Material.WOOD, 2);
			addFourMaterialsToItem(Material.SPRUCE_WOOD_STAIRS, Material.WOOD, 1, 2);
			addFourMaterialsToItem(Material.BIRCH_WOOD_STAIRS, Material.WOOD, 2, 2);
			addFourMaterialsToItem(Material.JUNGLE_WOOD_STAIRS, Material.WOOD, 3, 2);
			addFourMaterialsToItem(Material.ACACIA_STAIRS, Material.WOOD, 4, 2);
			addFourMaterialsToItem(Material.DARK_OAK_STAIRS, Material.WOOD, 5, 2);
			addFourMaterialsToItem(Material.COBBLESTONE_STAIRS, Material.COBBLESTONE, 2);
			addFourMaterialsToItem(Material.BRICK_STAIRS, Material.BRICK, 2);
			addFourMaterialsToItem(Material.SMOOTH_STAIRS, Material.SMOOTH_BRICK, 2);
			addFourMaterialsToItem(Material.NETHER_BRICK_STAIRS, Material.NETHER_BRICK, 2);
			addFourMaterialsToItem(Material.SANDSTONE_STAIRS, Material.SANDSTONE, 2);
			addFourMaterialsToItem(Material.QUARTZ_STAIRS, Material.QUARTZ_BLOCK, 2);
			addFourMaterialsToItem(Material.RED_SANDSTONE_STAIRS, Material.RED_SANDSTONE, 2);
			addFourMaterialsToItem(Material.PURPUR_SLAB, Material.PURPUR_BLOCK, 2);
		}

	}

	public static void addHalfSlabCombo(Material original, Material result) {
		addHalfSlabCombo(original, 1, 0, result, 1, 0);
	}

	public static void addHalfSlabCombo(Material original, int durabilityoriginal, Material result) {
		addHalfSlabCombo(original, 1, durabilityoriginal, result, 1, 0);
	}

	public static void addHalfSlabCombo(Material original, int durabilityoriginal, Material result,
			int durabilityresult) {
		addHalfSlabCombo(original, 1, durabilityoriginal, result, 1, durabilityresult);
	}

	@SuppressWarnings("deprecation")
	public static void addHalfSlabCombo(Material original, int quantityoriginal, int durabilityoriginal,
			Material result, int quantityresult, int durabilityresult) {

		ItemStack item = new ItemStack(result, quantityresult, (short) durabilityresult);

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("1", "1");

		ItemRecipe1.setIngredient('1', original, durabilityoriginal);

		Bukkit.getServer().addRecipe(ItemRecipe1);
	}

	// === SICKLES === //

	@SuppressWarnings("deprecation")
	public static void addTwoItemsCombo(Material materialtop, int durabilitytop, Material materialbottom,
			int durabilitybottom, ItemStack item) {

		ShapedRecipe ItemRecipe1 = new ShapedRecipe(item);

		ItemRecipe1.shape("1", "2");
		ItemRecipe1.setIngredient('1', materialtop, durabilitytop);
		ItemRecipe1.setIngredient('2', materialbottom, durabilitybottom);
		Bukkit.getServer().addRecipe(ItemRecipe1);
	}

	public static void addTwoItemsCombo(Material materialtop, Material materialbottom, ItemStack item) {
		addTwoItemsCombo(materialtop, 0, materialbottom, 0, item);
	}

	// === CLAY CONVERSION === //

	@SuppressWarnings("deprecation")
	public static void addSingleMaterialToItem(Material input, int inputdurability, ItemStack output) {
		ShapedRecipe ItemRecipe1 = new ShapedRecipe(output);

		ItemRecipe1.shape("1");
		ItemRecipe1.setIngredient('1', input, inputdurability);
		Bukkit.getServer().addRecipe(ItemRecipe1);

	}

	public static void addSingleMaterialToItem(Material input, Material output) {
		addSingleMaterialToItem(input, 0, new ItemStack(output, 1, (short) 0));
	}

	public static void addSingleMaterialToItem(Material input, int inputdurability, Material output) {
		addSingleMaterialToItem(input, inputdurability, new ItemStack(output, 1, (short) 0));
	}

	public static void addSingleMaterialToItem(Material input, int inputdurability, Material output,
			int outputdurability) {
		addSingleMaterialToItem(input, inputdurability, new ItemStack(output, 1, (short) outputdurability));
	}

	public static void addSingleMaterialToItem(Material input, Material output, int outputdurability,
			int outputquantity) {
		addSingleMaterialToItem(input, 0, new ItemStack(output, outputquantity, (short) outputdurability));
	}

	public static void addSingleMaterialToItem(Material input, int inputdurability, Material output,
			int outputdurability, int outputquantity) {
		addSingleMaterialToItem(input, inputdurability,
				new ItemStack(output, outputquantity, (short) outputdurability));
	}

	public static void addSingleMaterialToItem(Material input, Material output, int outputquantity) {
		addSingleMaterialToItem(input, 0, new ItemStack(output, outputquantity, (short) 0));
	}

	// === STAIRS === //

	@SuppressWarnings("deprecation")
	public static void addStair(Material input, int inputdurability, ItemStack output) {
		ShapedRecipe ItemRecipe1 = new ShapedRecipe(output);

		ItemRecipe1.shape("100", "110", "111");
		ItemRecipe1.setIngredient('1', input, inputdurability);
		Bukkit.getServer().addRecipe(ItemRecipe1);

		ShapedRecipe ItemRecipe2 = new ShapedRecipe(output);

		ItemRecipe2.shape("001", "011", "111");
		ItemRecipe2.setIngredient('1', input, inputdurability);
		Bukkit.getServer().addRecipe(ItemRecipe2);
	}

	public static void addStair(Material input, Material output) {
		addStair(input, 0, new ItemStack(output, 1, (short) 0));
	}

	public static void addStair(Material input, int inputdurability, Material output) {
		addStair(input, inputdurability, new ItemStack(output, 1, (short) 0));
	}

	public static void addStair(Material input, int inputdurability, Material output, int outputdurability) {
		addStair(input, inputdurability, new ItemStack(output, 1, (short) outputdurability));
	}

	public static void addStair(Material input, Material output, int outputdurability, int outputquantity) {
		addStair(input, 0, new ItemStack(output, outputquantity, (short) outputdurability));
	}

	public static void addStair(Material input, int inputdurability, Material output, int outputdurability,
			int outputquantity) {
		addStair(input, inputdurability, new ItemStack(output, outputquantity, (short) outputdurability));
	}

	public static void addStair(Material input, Material output, int outputquantity) {
		addStair(input, 0, new ItemStack(output, outputquantity, (short) 0));
	}

	// === STAIRS TO BLOCK === //

	@SuppressWarnings("deprecation")
	public static void addFourMaterialsToItem(Material input, int inputdurability, ItemStack output) {
		ShapedRecipe ItemRecipe1 = new ShapedRecipe(output);

		ItemRecipe1.shape("11", "11");
		ItemRecipe1.setIngredient('1', input, inputdurability);
		Bukkit.getServer().addRecipe(ItemRecipe1);
	}

	public static void addFourMaterialsToItem(Material input, Material output) {
		addFourMaterialsToItem(input, 0, new ItemStack(output, 1, (short) 0));
	}

	public static void addFourMaterialsToItem(Material input, int inputdurability, Material output) {
		addFourMaterialsToItem(input, inputdurability, new ItemStack(output, 1, (short) 0));
	}

	public static void addFourMaterialsToItem(Material input, int inputdurability, Material output,
			int outputdurability) {
		addFourMaterialsToItem(input, inputdurability, new ItemStack(output, 1, (short) outputdurability));
	}

	public static void addFourMaterialsToItem(Material input, Material output, int outputdurability,
			int outputquantity) {
		addFourMaterialsToItem(input, 0, new ItemStack(output, outputquantity, (short) outputdurability));
	}

	public static void addFourMaterialsToItem(Material input, int inputdurability, Material output,
			int outputdurability, int outputquantity) {
		addFourMaterialsToItem(input, inputdurability, new ItemStack(output, outputquantity, (short) outputdurability));
	}

	public static void addFourMaterialsToItem(Material input, Material output, int outputquantity) {
		addFourMaterialsToItem(input, 0, new ItemStack(output, outputquantity, (short) 0));
	}

	// === NUGGETS / SHARDS === //

	public static ItemStack increaseAmount(ItemStack item, int amount) {
		item.setAmount(amount);
		return item;
	}

	@SuppressWarnings("deprecation")
	public static void addFullTableToItem(Material input, int inputdurability, ItemStack output) {
		ShapedRecipe ItemRecipe1 = new ShapedRecipe(output);

		ItemRecipe1.shape("111", "111", "111");
		ItemRecipe1.setIngredient('1', input, inputdurability);
		Bukkit.getServer().addRecipe(ItemRecipe1);
	}

	public static void addFullTableToItem(Material input, Material output) {
		addFullTableToItem(input, 0, new ItemStack(output, 1, (short) 0));
	}

	public static void addFullTableToItem(Material input, int inputdurability, Material output) {
		addFullTableToItem(input, inputdurability, new ItemStack(output, 1, (short) 0));
	}

	public static void addFullTableToItem(Material input, int inputdurability, Material output, int outputdurability) {
		addFullTableToItem(input, inputdurability, new ItemStack(output, 1, (short) outputdurability));
	}

	public static void addFullTableToItem(Material input, Material output, int outputdurability, int outputquantity) {
		addFullTableToItem(input, 0, new ItemStack(output, outputquantity, (short) outputdurability));
	}

	public static void addFullTableToItem(Material input, int inputdurability, Material output, int outputdurability,
			int outputquantity) {
		addFullTableToItem(input, inputdurability, new ItemStack(output, outputquantity, (short) outputdurability));
	}

	public static void addFullTableToItem(Material input, Material output, int outputquantity) {
		addFullTableToItem(input, 0, new ItemStack(output, outputquantity, (short) 0));
	}

	public static void addFullTableToItem(ItemStack input, ItemStack output) {
		addFullTableToItem(input.getType(), input.getDurability(), output);
	}

	public static void addFullTableToItem(ItemStack input, Material output) {
		addFullTableToItem(input.getType(), input.getDurability(), new ItemStack(output, 1, (short) 0));
	}

	public static void addFullTableToItem(ItemStack input, Material output, int outputquantity) {
		addFullTableToItem(input.getType(), input.getDurability(), new ItemStack(output, outputquantity, (short) 0));
	}

	//@EventHandler
	//public void onChat(PlayerChatEvent event) {
	//	int noOfItemsToIgnore = Integer.parseInt(event.getMessage());
	//	int itemRN = 0;
	//	for (CustomItemStack cStack : AdditionsAPI.getAllCustomItemStacks()) {
	//		if (noOfItemsToIgnore <= itemRN)
	//		event.getPlayer().getInventory().addItem(cStack.getItemStack());
	//		itemRN++;
	//	}
	//}

}