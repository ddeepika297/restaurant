package com.GBI.Restaurant.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.GBI.Restaurant.util.Helper;
import com.GBI.Restaurant.util.SortRestuarantByRating;

public class CostBracketStruct {
	private static final Logger logger = LoggerFactory.getLogger(CostBracketStruct.class);
	List<Restaurant> allRestaurant = new LinkedList<>();
	List<Restaurant> newlyCreatedRestaurant = new LinkedList<>();
	List<Restaurant> nonRecommendedRestaurantSortedBasedOnRating = new LinkedList<>();
	List<Restaurant> recommendedRestaurantSortedBasedOnRating = new LinkedList<>();
	List<Restaurant> recommendedRestaurant = new LinkedList<>();
	List<Restaurant> nonRecommendedRestaurant = new LinkedList<>();

	public void add(Restaurant restaurant) {
		allRestaurant.add(restaurant);
		logger.info("new res added");
	}

	public void categorizeRestaurants() {
		for (Restaurant restaurant : allRestaurant) {
			if (restaurant.getOnboardedTime() != null && Helper.inLast48hr(restaurant.getOnboardedTime()))
				newlyCreatedRestaurant.add(restaurant);
			else if (restaurant.isRecommended())
				recommendedRestaurant.add(restaurant);
			else
				nonRecommendedRestaurant.add(restaurant);
		}
		sortNonRecommendedRestaurantByRating();
		sortRecommendedRestaurantByRating();
		logger.info("categorization of restaurant done");
	}

	private void sortNonRecommendedRestaurantByRating() {
		nonRecommendedRestaurantSortedBasedOnRating = nonRecommendedRestaurant;
		Collections.sort(nonRecommendedRestaurantSortedBasedOnRating, new SortRestuarantByRating());
	}

	private void sortRecommendedRestaurantByRating() {
		recommendedRestaurantSortedBasedOnRating = recommendedRestaurant;
		Collections.sort(recommendedRestaurantSortedBasedOnRating, new SortRestuarantByRating());
	}

	public List<Restaurant> getAllRestaurant() {
		return allRestaurant;
	}

	public List<Restaurant> getNewlyCreatedRestaurant() {
		return newlyCreatedRestaurant;
	}

	public List<Restaurant> getNonRecommendedRestaurantSortedBasedOnRating() {
		return nonRecommendedRestaurantSortedBasedOnRating;
	}

	public List<Restaurant> getRecommendedRestaurantSortedBasedOnRating() {
		return recommendedRestaurantSortedBasedOnRating;
	}

	public List<Restaurant> getRecommendedRestaurant() {
		return recommendedRestaurant;
	}

	public List<Restaurant> getNonRecommendedRestaurant() {
		return nonRecommendedRestaurant;
	}

	@Override
	public String toString() {
		return "CostBracketStruct [allRestaurant=" + allRestaurant + ", newlyCreatedRestaurant="
				+ newlyCreatedRestaurant + ", nonRecommendedRestaurantSortedBasedOnRating="
				+ nonRecommendedRestaurantSortedBasedOnRating + ", recommendedRestaurantSortedBasedOnRating="
				+ recommendedRestaurantSortedBasedOnRating + ", recommendedRestaurant=" + recommendedRestaurant
				+ ", nonRecommendedRestaurant=" + nonRecommendedRestaurant + "]";
	}
}
