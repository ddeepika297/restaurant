package com.GBI.Restaurant.util;

import java.util.Date;

import com.GBI.Restaurant.model.CuisineEnum;

public class Helper {
	static final long TWO_DAYS = 2 * 24 * 60 * 60 * 1000;

	public static boolean inLast48hr(Date aDate) {
		return aDate.getTime() > System.currentTimeMillis() - TWO_DAYS;
	}

	public static CuisineEnum[] getAllCuisine() {
		CuisineEnum[] allCuisine = new CuisineEnum[CuisineEnum.values().length];
		int index = 0;
		for (CuisineEnum cuisine : CuisineEnum.values()) {
			allCuisine[index++] = cuisine;
		}
		return allCuisine;
	}

	public static int[] getAllCostBrackets() {
		return Constants.COST_BRACKETS;
		
	}
}
