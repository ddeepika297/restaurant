package com.GBI.Restaurant.util;

import java.util.Comparator;

import com.GBI.Restaurant.model.Restaurant;

public class SortRestuarantByRating implements Comparator<Restaurant> {

	@Override
	public int compare(Restaurant o1, Restaurant o2) {
		if (o1.getRating() > o2.getRating())
			return -1;
		return 1;
	}

}
