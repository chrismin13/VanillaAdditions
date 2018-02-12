package com.chrismin13.vanillaadditions.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.utils.NumberUtils;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneArmor;
import com.chrismin13.vanillaadditions.items.redstone.RedstoneItem;

public class RedstoneItemsListener implements Listener {

	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<String> cooldown = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.isCancelled())
			return;

		Player player = event.getPlayer();
		PlayerInventory inv = player.getInventory();
		ItemStack item = inv.getItemInMainHand();
		if (!AdditionsAPI.isCustomItem(item) || !(new CustomItemStack(item).getCustomItem() instanceof RedstoneItem)) {
			item = inv.getItemInOffHand();
			if (!AdditionsAPI.isCustomItem(item)
					|| !(new CustomItemStack(item).getCustomItem() instanceof RedstoneItem))
				return;
		}
		CustomItemStack cStack = new CustomItemStack(item);
		if (!(cStack.getCustomItem() instanceof RedstoneItem))
			return;

		if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
			return;
		Block block = event.getClickedBlock();
		String serializedBlock = block.getWorld().getName() + ";" + block.getX() + ";" + block.getY() + ";"
				+ block.getZ();

		if (cooldown.contains(serializedBlock))
			return;

		if (block.getType() == Material.REDSTONE_LAMP_OFF) {

			Block redstoneBlock = block.getLocation().add(0, -1, 0).getBlock();
			if (!redstoneBlock.getState().getClass().getName().endsWith("CraftBlockState"))
				redstoneBlock = block.getLocation().add(0, -1, 0).getBlock();
			if (!redstoneBlock.getState().getClass().getName().endsWith("CraftBlockState"))
				redstoneBlock = block.getLocation().add(1, 0, 0).getBlock();
			if (!redstoneBlock.getState().getClass().getName().endsWith("CraftBlockState"))
				redstoneBlock = block.getLocation().add(-1, 0, 0).getBlock();
			if (!redstoneBlock.getState().getClass().getName().endsWith("CraftBlockState"))
				redstoneBlock = block.getLocation().add(0, 0, 1).getBlock();
			if (!redstoneBlock.getState().getClass().getName().endsWith("CraftBlockState")) 
				redstoneBlock = block.getLocation().add(0, 0, -1).getBlock();
			if (!redstoneBlock.getState().getClass().getName().endsWith("CraftBlockState")) 
				return;
			
			final Block b = redstoneBlock;
			Material type = b.getType();
			byte data = b.getData();

			b.setType(Material.REDSTONE_BLOCK);
			blocks.add(block);

			Bukkit.getScheduler().runTask(VanillaAdditions.getInstance(), () -> {
				b.setType(type);
				b.setData(data);
			});

		} else if (block.getType().equals(Material.REDSTONE_LAMP_ON)) {
			block.setType(Material.REDSTONE_LAMP_OFF);
		} else {
			return;
		}

		cooldown.add(serializedBlock);
		cStack.reduceDurability(player, 1);

		Bukkit.getScheduler().scheduleSyncDelayedTask(VanillaAdditions.getInstance(),
				() -> cooldown.remove(serializedBlock), 20);
	}

	@EventHandler
	public void onBlockRedstone(BlockRedstoneEvent event) {
		if (!blocks.contains(event.getBlock()))
			return;
		event.setNewCurrent(1);
		blocks.remove(event.getBlock());
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEnemyHit(EntityDamageByEntityEvent event) {
		if (event.isCancelled())
			return;

		if (!(event.getEntity() instanceof Player))
			return;
		Player player = (Player) event.getEntity();

		if (!player.hasPotionEffect(PotionEffectType.REGENERATION)) {
			for (ItemStack item : player.getInventory().getArmorContents()) {
				if (AdditionsAPI.isCustomItem(item)) {
					CustomItemStack cStack = new CustomItemStack(item);

					if (cStack.getCustomItem() instanceof RedstoneArmor && NumberUtils.calculateChance(0.05)) {
						int healthToAdd = NumberUtils.randomInt(150, 250);
						player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, healthToAdd, 1));
						break;
					}
				}
			}
		}
	}
}
