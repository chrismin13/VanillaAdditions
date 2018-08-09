package com.chrismin13.vanillaadditions.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.chrismin13.additionsapi.AdditionsAPI;
import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.additionsapi.utils.MaterialUtils;
import com.chrismin13.vanillaadditions.items.SlimeBucket;
import com.chrismin13.vanillaadditions.utils.MobUtils;
import com.chrismin13.vanillaadditions.utils.SlimeChunkUtils;

public class SlimeBucketListener implements Listener {

	List<UUID> playersInSlimeChunks = new ArrayList<UUID>();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerMove(PlayerMoveEvent event) {
		if (event.isCancelled() || event.getFrom() == null || event.getTo() == null)
			return;

		Location from = event.getFrom();
		Location to = event.getTo();
		if (from.getBlockX() == to.getBlockX() && from.getBlockZ() == to.getBlockZ())
			return;

		Player player = event.getPlayer();
		if (SlimeChunkUtils.isSlimeChunk(player.getLocation())) {
			changeToJumping(player);
		} else {
			changeToSimple(player);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onItemDrop(PlayerDropItemEvent event) {
		if (event.isCancelled())
			return;
		Item item = event.getItemDrop();
		ItemStack itemstack = item.getItemStack();
		if (!AdditionsAPI.isCustomItem(itemstack))
			return;
		CustomItemStack cStack = new CustomItemStack(itemstack);
		if (!(cStack.getCustomItem() instanceof SlimeBucket))
			return;
		cStack.setTexture("slime_bucket");
		item.setItemStack(cStack.getItemStack());
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onItemPickup(PlayerPickupItemEvent event) {
		if (event.isCancelled())
			return;
		Item item = event.getItem();
		ItemStack itemstack = item.getItemStack();
		if (!AdditionsAPI.isCustomItem(itemstack))
			return;
		CustomItemStack cStack = new CustomItemStack(itemstack);
		if (!(cStack.getCustomItem() instanceof SlimeBucket))
			return;
		Player player = event.getPlayer();
		if (SlimeChunkUtils.isSlimeChunk(player.getLocation())) {
			changeToJumping(player);
			cStack.setTexture("jumping_slime_bucket");
		} else {
			changeToSimple(player);
			cStack.setTexture("slime_bucket");
		}
		item.setItemStack(cStack.getItemStack());
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSlimeBucketMove(InventoryMoveItemEvent event) {
		if (event.isCancelled())
			return;
		ItemStack item = event.getItem();
		if (!AdditionsAPI.isCustomItem(item))
			return;
		CustomItemStack cStack = new CustomItemStack(item);
		if (!(cStack.getCustomItem() instanceof SlimeBucket))
			return;
		cStack.setTexture("slime_bucket");
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBucketSlimeClick(PlayerInteractEntityEvent event) {
		if (event.isCancelled())
			return;
		Entity entity = event.getRightClicked();
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();
		ItemStack item = null;
		UUID playeruuid = player.getUniqueId();
		if (entity instanceof Slime && (inventory.getItemInMainHand().getType().equals(Material.BUCKET)
				|| inventory.getItemInOffHand().getType().equals(Material.BUCKET))) {
			if (entity.isDead())
				return;
			Slime slime = (Slime) entity;
			if (slime.getSize() != 1)
				return;
			if (player.getGameMode() != GameMode.CREATIVE) {
				if (inventory.getItemInMainHand().getType().equals(Material.BUCKET)) {
					item = inventory.getItemInMainHand();
					int amount = item.getAmount() - 1;
					item.setAmount(amount);
					inventory.setItemInMainHand(item);
				} else if (inventory.getItemInOffHand().getType().equals(Material.BUCKET)) {
					item = inventory.getItemInOffHand();
					int amount = item.getAmount() - 1;
					item.setAmount(amount);
					inventory.setItemInOffHand(item);
				}
			}
			if (SlimeChunkUtils.isSlimeChunk(player.getLocation())) {
				if (!playersInSlimeChunks.contains(playeruuid))
					playersInSlimeChunks.add(playeruuid);
				player.getInventory().addItem(new CustomItemStack("vanilla_additions:slime_bucket")
						.setTexture("jumping_slime_bucket").getItemStack());
			} else {
				if (playersInSlimeChunks.contains(playeruuid))
					playersInSlimeChunks.remove(playeruuid);
				player.getInventory().addItem(new CustomItemStack("vanilla_additions:slime_bucket").getItemStack());
			}
			event.getRightClicked().remove();
		} else if (entity instanceof ItemFrame) {
			ItemFrame itemframe = (ItemFrame) entity;
			if (itemframe.getItem().getType() != Material.AIR)
				return;
			CustomItemStack cStack = null;
			if (AdditionsAPI.isCustomItem(inventory.getItemInMainHand())) {
				cStack = new CustomItemStack(inventory.getItemInMainHand());
				if (cStack.getCustomItem() instanceof SlimeBucket)
					cStack.setTexture("slime_bucket");
			} else if (AdditionsAPI.isCustomItem(inventory.getItemInOffHand())) {
				cStack = new CustomItemStack(inventory.getItemInOffHand());
				if (cStack.getCustomItem() instanceof SlimeBucket)
					cStack.setTexture("slime_bucket");
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onInventoryChange(InventoryClickEvent event) {
		if (event.getView().getTopInventory() == null || event.isCancelled())
			return;
		Inventory inventory = event.getInventory();
		ItemStack item = event.getCurrentItem();
		if (inventory.getHolder() != null && inventory.getHolder().toString().contains("CraftPlayer")) {
			if (AdditionsAPI.isCustomItem(item)) {
				CustomItemStack cStack = new CustomItemStack(item);
				if (cStack.getCustomItem() instanceof SlimeBucket) {
					if (SlimeChunkUtils.isSlimeChunk(event.getWhoClicked().getLocation())) {
						cStack.setTexture("jumping_slime_bucket");
					} else {
						cStack.setTexture("slime_bucket");
					}
				}
			}
		} else if (AdditionsAPI.isCustomItem(item)) {
			CustomItemStack cStack = new CustomItemStack(item);
			if (cStack.getCustomItem() instanceof SlimeBucket) {
				cStack.setTexture("slime_bucket");
				playersInSlimeChunks.remove(event.getWhoClicked().getUniqueId());
			}
		}
	}

	@EventHandler
	public void onSlimeBucketBlockClick(PlayerInteractEvent event) {
		if (event.isCancelled())
			return;
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();
		CustomItemStack cStack = null;
		if (AdditionsAPI.isCustomItem(inventory.getItemInMainHand())) {
			cStack = new CustomItemStack(inventory.getItemInMainHand());
		} else if (AdditionsAPI.isCustomItem(inventory.getItemInOffHand())) {
			cStack = new CustomItemStack(inventory.getItemInOffHand());
		} else {
			return;
		}
		if (!(cStack.getCustomItem() instanceof SlimeBucket))
			return;

		if (event.getAction() == Action.RIGHT_CLICK_BLOCK
				&& (!MaterialUtils.isInteractable(event.getClickedBlock().getType()) || player.isSneaking())) {
			if (event.getClickedBlock() == null)
				return;
			if (MobUtils.spawnSlime(event.getClickedBlock(), event.getBlockFace())
					&& !player.getGameMode().equals(GameMode.CREATIVE)) {
				cStack.getItemStack().setAmount(0);
				inventory.addItem(new ItemStack(Material.BUCKET));
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onTeleportWithSlimeBucket(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
		if (SlimeChunkUtils.isSlimeChunk(player.getLocation())) {
			changeToJumping(player);
		} else {
			changeToSimple(player);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onItemCraft(CraftItemEvent event) {
		if (event.isCancelled() || !AdditionsAPI.isCustomItem(event.getCurrentItem()))
			return;
		CustomItemStack cStack = new CustomItemStack(event.getCurrentItem());
		if (!(cStack.getCustomItem() instanceof SlimeBucket))
			return;
		if (SlimeChunkUtils.isSlimeChunk(event.getWhoClicked().getLocation()))
			cStack.setTexture("jumping_slime_bucket");
		else
			cStack.setTexture("slime_bucket");
	}

	public void changeToJumping(Player player) {
		if (!playersInSlimeChunks.contains(player.getUniqueId()))
			playersInSlimeChunks.add(player.getUniqueId());
		Inventory inventory = player.getInventory();
		for (ItemStack item : inventory.getContents()) {
			if (AdditionsAPI.isCustomItem(item)) {
				CustomItemStack cStack = new CustomItemStack(item);
				if (cStack.getCustomItem() instanceof SlimeBucket
						&& !cStack.getTexture().equals("jumping_slime_bucket"))
					cStack.setTexture("jumping_slime_bucket");
			}
		}
	}

	public void changeToSimple(Player player) {
		if (playersInSlimeChunks.contains(player.getUniqueId())) {
			playersInSlimeChunks.remove(player.getUniqueId());
		}
		Inventory inventory = player.getInventory();
		for (ItemStack item : inventory.getContents()) {
			if (AdditionsAPI.isCustomItem(item)) {
				CustomItemStack cStack = new CustomItemStack(item);
				if (cStack.getCustomItem() instanceof SlimeBucket && !cStack.getTexture().equals("slime_bucket")) {
					cStack.setTexture("slime_bucket");
				}
			}
		}
	}

}
