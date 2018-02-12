package com.chrismin13.vanillaadditions.permissions;

import com.chrismin13.additionsapi.permissions.ItemPermissions;
import com.chrismin13.additionsapi.permissions.PermissionType;

public class ChiselPermissions extends ItemPermissions {

	private String chisel;
	
	public ChiselPermissions(String permissionPrefix, PermissionType type) {
		super(permissionPrefix, type);
		chisel = this.getPermissionPrefix() + "." + this.getType().getPermission() + ".chisel";
		
	}

	/**
	 * @return the chisel
	 */
	public String getChisel() {
		return chisel;
	}

	/**
	 * @param chisel the chisel to set
	 */
	public void setChisel(String chisel) {
		this.chisel = chisel;
	}

}
