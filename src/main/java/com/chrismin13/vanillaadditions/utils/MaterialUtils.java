package com.chrismin13.vanillaadditions.utils;

public class MaterialUtils {

	public static String getWoodType(byte woodData) {
		switch (woodData) {
		case 0:
			return "oak";
		case 1:
			return "spruce";
		case 2:
			return "birch";
		case 3:
			return "jungle";
		case 4:
			return "acacia";
		case 5:
			return "dark_oak";
		default:
			return "oak";
		}
	}

}
