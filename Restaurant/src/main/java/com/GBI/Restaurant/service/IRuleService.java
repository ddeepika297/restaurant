package com.GBI.Restaurant.service;

import java.util.HashMap;
import java.util.List;

import com.GBI.Restaurant.model.CuisineEnum;
import com.GBI.Restaurant.model.Restaurant;
import com.GBI.Restaurant.model.Rule;
import com.GBI.Restaurant.model.UserPreferences;

public interface IRuleService {

	List<Rule> getRules(UserPreferences userPreference);

	void applyRules(Rule rule, HashMap<CuisineEnum, AbstractCuisine> cuisineBasedRestaurant, HashMap<String, Restaurant> recommendedRestaurantList);
}
