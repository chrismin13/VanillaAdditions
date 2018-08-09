package com.chrismin13.vanillaadditions.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupArrowEvent;

import com.chrismin13.additionsapi.events.bow.ArrowFromCustomBowHitEvent;
import com.chrismin13.vanillaadditions.VanillaAdditions;
import com.chrismin13.vanillaadditions.items.EnderBow;

public class EnderBowListener implements Listener {

	private List<Projectile> unpickableArrows = new ArrayList<Projectile>();

	@EventHandler
	public void onArrowHitFromCustomBow(ArrowFromCustomBowHitEvent customEvent) {
		if (customEvent.getCustomBow() instanceof EnderBow) {
			LivingEntity shooter = customEvent.getShooter();
			Location shooterLoc = shooter.getEyeLocation();
			Arrow arrow = (Arrow) customEvent.getProjectileHitEvent().getEntity();
			Location arrowLoc = arrow.getLocation();
			unpickableArrows.add(arrow);
			shooter.teleport(new Location(arrowLoc.getWorld(), arrowLoc.getX(), arrowLoc.getY(), arrowLoc.getZ(),
					shooterLoc.getYaw(), shooterLoc.getPitch()));
			shooter.damage(5, arrow);
			checkTimeLived(arrow);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onArrowPickup(PlayerPickupArrowEvent event) {
		if (!event.isCancelled() && unpickableArrows.contains(event.getArrow()))
			event.setCancelled(true);
	}

	public void checkTimeLived(Arrow arrow) {
		if (arrow != null)
			if (arrow.getTicksLived() >= 6000 || arrow.isDead() || !arrow.isValid()) {
				if (unpickableArrows.contains(arrow)) {
					unpickableArrows.remove(arrow);
				}
			} else {
				Bukkit.getScheduler().scheduleSyncDelayedTask(VanillaAdditions.getInstance(),
						() -> checkTimeLived(arrow), 6000);
			}
	}
}
