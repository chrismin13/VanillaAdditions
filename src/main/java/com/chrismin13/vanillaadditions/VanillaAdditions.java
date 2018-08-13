package com.chrismin13.vanillaadditions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bstats.bukkit.Metrics;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.chrismin13.additionsapi.utils.Debug;
import com.chrismin13.vanillaadditions.listeners.ArmorStandListener;
import com.chrismin13.vanillaadditions.listeners.BlockBreakListener;
import com.chrismin13.vanillaadditions.listeners.BookListener;
import com.chrismin13.vanillaadditions.listeners.ChiselListener;
import com.chrismin13.vanillaadditions.listeners.CoalItemsListener;
import com.chrismin13.vanillaadditions.listeners.EnderBowListener;
import com.chrismin13.vanillaadditions.listeners.LapisItemsListener;
import com.chrismin13.vanillaadditions.listeners.NetherrackItemsListener;
import com.chrismin13.vanillaadditions.listeners.RedstoneItemsListener;
import com.chrismin13.vanillaadditions.listeners.SlimeBucketListener;
import com.chrismin13.vanillaadditions.listeners.SpongeListener;

public class VanillaAdditions extends JavaPlugin {

	private static JavaPlugin instance;

	public void onEnable() {
		instance = this;

		initializeConfig();

		new Metrics(this);

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new BlockBreakListener(), this);
		pm.registerEvents(new EnderBowListener(), this);
		pm.registerEvents(new Items(), this);
		pm.registerEvents(new SlimeBucketListener(), this);
		pm.registerEvents(new NetherrackItemsListener(), this);
		pm.registerEvents(new CoalItemsListener(), this);
		pm.registerEvents(new LapisItemsListener(), this);
		pm.registerEvents(new RedstoneItemsListener(), this);
		pm.registerEvents(new SpongeListener(), this);
		pm.registerEvents(new ChiselListener(), this);
		pm.registerEvents(new ArmorStandListener(), this);
		pm.registerEvents(new BookListener(), this);
	}

	public static ArrayList<Enchantment> blacklistedEnchantments;

	private void initializeConfig() {

		String path = getDataFolder() + File.separator + "config.yml";
		YamlConfiguration config = YamlConfiguration.loadConfiguration(new File(path));
		
		boolean versionChanged = false;

		if (config.getInt("config-version", 0) == 0) {
			config.set("config-version", 1);

			List<String> mechanics = config.getStringList("enabled-mechanics");
			mechanics.add("ARMOR_STANDS_WITH_ARMS");
			mechanics.add("ARMOR_STAND_ITEM_IN_OFF_HAND");
			config.set("enabled-mechanics", mechanics);

			versionChanged = true;
		}

		if (config.getInt("config-version") == 1) {
			config.set("config-version", 2);

			List<String> mechanics = config.getStringList("enabled-mechanics");
			mechanics.add("OPEN_BOOK_IN_ITEM_FRAME");
			config.set("enabled-mechanics", mechanics);

			versionChanged = true;
		}

		if (config.getInt("config-version") == 2) {
			config.set("config-version", 3);

			List<String> ench = config.getStringList("blacklisted-enchantments");
			ench.add("NULL");
			config.set("blacklisted-enchantments", ench);

			versionChanged = true;
		}

		if (config.getInt("config-version") == 3) {
			config.set("config-version", 4);
			
			config.set("hammer.only-break-same-type", false);
			
			versionChanged = true;
		}

		if (versionChanged) {
			try {
				config.options().header("-------=======----- Vanilla Additions by chrismin13 -----=======------- #"
						+ "\n= #" + "\n# If you want to enable or disable Custom Items, like Emerald Swords, use"
						+ "\n# the Configuration of the Additions API!" + "\n= #"
						+ "\n-------=======-------====== Configuration File =====-------=======------- #"
						+ "\n-----=======-------=======-------=======-------=======-------=======----- #" + "\n= #"
						+ "\n# config-version: This keeps track of the version of your Config. If new"
						+ "\n#                 values are added by default, this will increase."
						+ "\n#                 DO NOT CHANGE - IT CHANGES BY ITSELF WHEN NEEDED!" + "\n= #"
						+ "\n-----=======-------=======-------=======-------=======-------=======----- #" + "\n= #"
						+ "\n# enabled-recipes: This is a list of the recipes that will be added. This"
						+ "\n#                  does not include Custom Items, you can configure them"
						+ "\n#                  in the Additions API Config. Valid values are:"
						+ "\n#                  - SLABS_TO_FULL_BLOCKS (Converts two slabs, one on top of"
						+ "\n#                    the other, to the regular block)"
						+ "\n#                  - CLAY_CONVERSION (Converts a Clay Block to 4 Clay Balls)"
						+ "\n#                  - STAIRS_TO_BLOCKS (Converts a grid of 2x2 of Stairs to"
						+ "\n#                    a full block)" + "\n= #"
						+ "\n------=======-------=======-------=======-------=======-------=======----- #" + "\n= #"
						+ "\n# enabled-mechanics: This is a list of the game mechanics that will be enabled."
						+ "\n#                    This does not include Custom Items, you can configure them"
						+ "\n#                    in the Additions API Config. Valid values are:"
						+ "\n#                    - WET_SPONGE_TO_SPONGE (Convert Wet Sponge to normal,"
						+ "\n#                      dry Sponge when placed in the nether."
						+ "\n#                    - ARMOR_STANDS_WITH_ARMS (Add hands when an Armor Stand"
						+ "\n#                      is spawned)"
						+ "\n#                    - ARMOR_STAND_ITEM_IN_OFF_HAND (Add an item in the off"
						+ "\n#                      hand of an Armor Stand by holding it in your Off Hand)"
						+ "\n#                    - OPEN_BOOK_IN_ITEM_FRAME (Open any book in an Item"
						+ "\n#                      frame by right clicking on it! No need to take it out.) " + "\n= #"
						+ "\n------=======-------=======-------=======-------=======-------=======----- #" + "\n = #"
						+ "\n # blacklisted-enchantments: This list contains any enchantments that won't\n"
						+ "#                           be changed when enchanting the Lapis Items.\n"
						+ "#                           Their names can be found in the Spigot Docs:\n"
						+ "#                           http://bit.ly/2Ccin0C\n" + "= #\n"
						+ "------=======-------=======-------=======-------=======-------=======----- #" + "\r\n"
						+ "# hammer: Change properties for the hammer\r\n"
						+ "#         - only-break-same-type: Only break blocks that are of the same \r\n"
						+ "#                                 type as the one you originally mined.\r\n" + "= #\r\n"
						+ "------=======-------=======-------=======-------=======-------=======----- #");
				config.save(path);
			} catch (IOException e) {
				Debug.sayError(
						"Could not save config! Please check if the hard drive is full or the file is in use, e.g. Opened in another program, such as Notepad or Notepad++.");
				e.printStackTrace();
			}
		}

		saveDefaultConfig();

		Items.config = VanillaAdditions.getInstance().getConfig();

		ArrayList<Enchantment> blacklistedEnchantments = new ArrayList<>();
		try {
			if (this.getConfig().getStringList("blacklisted-enchantments") != null
					&& !this.getConfig().getStringList("blacklisted-enchantments").isEmpty()) {
				List<String> blacklist = this.getConfig().getStringList("blacklisted-enchantments");
				for (String ench : blacklist) {
					if (!ench.equalsIgnoreCase("NULL")) {
						String enchCap = ench.toUpperCase();
						blacklistedEnchantments.add(Enchantment.getByName(enchCap));
					}
				}
			}
		} catch (Exception e) {
			Debug.sayError("Vanilla Additions encountered a problem reading the Blacklisted Enchantments list for "
					+ "the Lapis Tools and Armor. Please check that you have set up the enchantments with the correct "
					+ "names, according to this list: http://bit.ly/2Ccin0C");
		}

		VanillaAdditions.blacklistedEnchantments = blacklistedEnchantments;
	}

	public static JavaPlugin getInstance() {
		return instance;
	}

}