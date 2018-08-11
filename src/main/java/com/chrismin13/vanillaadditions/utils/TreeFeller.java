package com.chrismin13.vanillaadditions.utils;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.chrismin13.additionsapi.items.CustomItemStack;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import com.chrismin13.vanillaadditions.listeners.BlockBreakListener;

public class TreeFeller {

	private static JavaPlugin plugin = VanillaAdditions.getInstance();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean chop(Block block, Player player, CustomItemStack cStack) {
		List<Block> blocks = new LinkedList();
		Block highest = getHighestLog(block);
		if (isTree(highest, player, block)) {
			getBlocksToChop(block, highest, blocks);
			popLogs(blocks, block.getWorld(), player, cStack);
			return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public static void getBlocksToChop(Block block, Block highest, List<Block> blocks) {
		while (block.getY() <= highest.getY()) {
			if (!blocks.contains(block)) {
				blocks.add(block);
			}
			getBranches(block, blocks, block.getRelative(BlockFace.NORTH));
			getBranches(block, blocks, block.getRelative(BlockFace.NORTH_EAST));
			getBranches(block, blocks, block.getRelative(BlockFace.EAST));
			getBranches(block, blocks, block.getRelative(BlockFace.SOUTH_EAST));
			getBranches(block, blocks, block.getRelative(BlockFace.SOUTH));
			getBranches(block, blocks, block.getRelative(BlockFace.SOUTH_WEST));
			getBranches(block, blocks, block.getRelative(BlockFace.WEST));
			getBranches(block, blocks, block.getRelative(BlockFace.NORTH_WEST));
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST));
			}
			if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST))) {
				getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST));
			}
			if ((block.getData() == 3) || (block.getData() == 7) || (block.getData() == 11)
					|| (block.getData() == 15)) {
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST, 2));
				}
				if (!blocks.contains(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST, 2))) {
					getBranches(block, blocks, block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST, 2));
				}
			}
			if (((blocks.contains(block.getRelative(BlockFace.UP)))
					|| (!block.getRelative(BlockFace.UP).getType().toString().contains("LOG")))) {
				break;
			}
			block = block.getRelative(BlockFace.UP);
		}
	}

	public static void getBranches(Block block, List<Block> blocks, Block other) {
		if (!blocks.contains(other) && other.getType().toString().contains("LOG")) {
			getBlocksToChop(other, getHighestLog(other), blocks);
		}
	}

	public static Block getHighestLog(Block block) {
		boolean isLog = true;
		while (isLog) {
			if ((block.getRelative(BlockFace.UP).getType().toString().contains("LOG"))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().toString()
							.contains("LOG"))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().toString()
							.contains("LOG"))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().toString()
							.contains("LOG"))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().toString()
							.contains("LOG"))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType().toString()
							.contains("LOG"))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType().toString()
							.contains("LOG"))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType().toString()
							.contains("LOG"))
					|| (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType().toString()
							.contains("LOG"))) {
				if (block.getRelative(BlockFace.UP).getType().toString().contains("LOG")) {
					block = block.getRelative(BlockFace.UP);
				} else if (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().toString()
						.contains("LOG")) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().toString()
						.contains("LOG"))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().toString()
						.contains("LOG"))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().toString()
						.contains("LOG"))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST).getType().toString()
						.contains("LOG"))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_EAST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST).getType().toString()
						.contains("LOG"))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH_WEST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST).getType().toString()
						.contains("LOG"))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_EAST);
				} else if ((block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST).getType().toString()
						.contains("LOG"))) {
					block = block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH_WEST);
				}
			} else {
				isLog = false;
			}
		}
		return block;
	}

	@SuppressWarnings("deprecation")
	public static boolean isTree(Block block, Player player, Block first) {
		int counter = 0;
		if (block.getRelative(BlockFace.UP).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.DOWN).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.NORTH).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.EAST).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.SOUTH).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (block.getRelative(BlockFace.WEST).getType().toString().contains("LEAVES")) {
			counter++;
		}
		if (counter >= 2) {
			return true;
		}
		if (block.getData() == 1) {
			block = block.getRelative(BlockFace.UP);
			if (block.getRelative(BlockFace.UP).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (block.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (block.getRelative(BlockFace.NORTH).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (block.getRelative(BlockFace.EAST).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (block.getRelative(BlockFace.SOUTH).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (block.getRelative(BlockFace.WEST).getType().toString().contains("LEAVES")) {
				counter++;
			}
			if (counter >= 2) {
				return true;
			}
		}
		return false;
	}

	// @SuppressWarnings("deprecation")
	public static void popLogs(List<Block> blocks, final World world, Player player, final CustomItemStack cStack) {
		Long delay = 0L;
		// final Collection<? extends Player> players =
		// Bukkit.getOnlinePlayers();
		for (int counter = 0; counter < blocks.size(); counter++) {
			delay++;
			final Block currentBlock = (Block) blocks.get(counter);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				@Override
				public void run() {
					BlockBreakListener.blocksBeingBroken.add(currentBlock);
					BlockBreakEvent newEvent = new BlockBreakEvent(currentBlock, player);

					Bukkit.getPluginManager().callEvent(newEvent);
					BlockBreakListener.blocksBeingBroken.remove(currentBlock);
					if (!newEvent.isCancelled()) {
						if (cStack.getItemStack() != null) {
							currentBlock.breakNaturally(cStack.getItemStack());
							TreeFeller.popLeaves(currentBlock, cStack.getItemStack(), player);
						} else {
							currentBlock.breakNaturally();
							TreeFeller.popLeaves(currentBlock, null, player);
						}
					}
					// if (useParticleLIB)
					// ParticleEffect.BLOCK_CRACK.sendData(players, (double)
					// currentBlock.getX(),
					// (double) currentBlock.getY(), (double)
					// currentBlock.getZ(), -0.5D, 1D, 0.5D, 1D, 10,
					// Material.LOG.getId(), (byte) 0x01);
				}
			}, delay);
		}
	}

	public static void popLeaves(Block block, final ItemStack item, Player player) {
		Long delay = 0L;
		// final Collection<? extends Player> players =
		// Bukkit.getOnlinePlayers();
		for (int y = -3; y < 3 + 1; y++) {
			for (int x = -3; x < 3 + 1; x++) {
				for (int z = -3; z < 3 + 1; z++) {
					final Block target = block.getRelative(x, y, z);
					if ((target.getType().toString().contains("LEAVES"))) {
						delay++;
						Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
							// @SuppressWarnings("deprecation")
							@Override
							public void run() {
								BlockBreakListener.blocksBeingBroken.add(target);
								BlockBreakEvent newEvent = new BlockBreakEvent(target, player);

								Bukkit.getPluginManager().callEvent(newEvent);
								BlockBreakListener.blocksBeingBroken.remove(target);
								if (!newEvent.isCancelled()) {
									if (item != null)
										target.breakNaturally(item);
									else
										target.breakNaturally();
								}
								// if (useParticleLIB)
								// ParticleEffect.BLOCK_CRACK.sendData(players,
								// (double) target.getX(),
								// (double) target.getY(), (double)
								// target.getZ(), -0.5D, 1D, 0.5D, 1D, 10,
								// Material.LEAVES.getId(), (byte) 0x01);
							}
						}, delay / 5);
					}
				}
			}
		}
	}

	public boolean isLoneLog(Block block) {
		if (block.getRelative(BlockFace.UP).getType().toString().contains("LOG")) {
			return false;
		}
		if (block.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
			return false;
		}
		if (hasHorizontalCompany(block)) {
			return false;
		}
		if (hasHorizontalCompany(block.getRelative(BlockFace.UP))) {
			return false;
		}
		if (hasHorizontalCompany(block.getRelative(BlockFace.DOWN))) {
			return false;
		}
		return true;
	}

	public boolean hasHorizontalCompany(Block block) {
		if (block.getRelative(BlockFace.NORTH).getType().toString().contains("LOG")) {
			return true;
		}
		if (block.getRelative(BlockFace.NORTH_EAST).getType().toString().contains("LOG")) {
			return true;
		}
		if (block.getRelative(BlockFace.EAST).getType().toString().contains("LOG")) {
			return true;
		}
		if (block.getRelative(BlockFace.SOUTH_EAST).getType().toString().contains("LOG")) {
			return true;
		}
		if (block.getRelative(BlockFace.SOUTH).getType().toString().contains("LOG")) {
			return true;
		}
		if (block.getRelative(BlockFace.SOUTH_WEST).getType().toString().contains("LOG")) {
			return true;
		}
		if (block.getRelative(BlockFace.WEST).getType().toString().contains("LOG")) {
			return true;
		}
		if (block.getRelative(BlockFace.NORTH_WEST).getType().toString().contains("LOG")) {
			return true;
		}
		return false;
	}

}
