package com.GBI.Restaurant.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GBI.Restaurant.model.CuisineEnum;
import com.GBI.Restaurant.model.Restaurant;
import com.GBI.Restaurant.model.Rule;
import com.GBI.Restaurant.model.User;
import com.GBI.Restaurant.model.UserPreferences;
import com.GBI.Restaurant.service.AbstractCuisine;
import com.GBI.Restaurant.service.IRestaurantRecommendationsService;
import com.GBI.Restaurant.service.IRuleService;
import com.GBI.Restaurant.service.IUserService;

@Service
public class RestaurantRecommendationsService implements IRestaurantRecommendationsService {
	private static final Logger logger = LoggerFactory.getLogger(RestaurantRecommendationsService.class);

	@Autowired
	public RestaurantRecommendationsService(IUserService defaultUserService, IRuleService defaultRuleService) {

		this.defaultUserService = defaultUserService;
		this.defaultRuleService = defaultRuleService;
	}

	IUserService defaultUserService;

	IRuleService defaultRuleService;

	@Override
	public Collection<Restaurant> getRestaurantRecommendations(User user, List<Restaurant> inputRestaurant) {
		UserPreferences userPreference = new UserPreferences(user);
		init(userPreference);
		HashMap<CuisineEnum, AbstractCuisine> cuisineBasedRestaurant = process(inputRestaurant);
		return getRestaurant(cuisineBasedRestaurant, userPreference);
		// return null;
	}

	private HashMap<CuisineEnum, AbstractCuisine> process(List<Restaurant> inputRestaurant) {
		logger.info("processing the input restaurants, to efficently query");
		HashMap<CuisineEnum, AbstractCuisine> cuisineBasedRestaurant = new HashMap<>();
		cuisineBasedRestaurant.put(CuisineEnum.NorthIndian, new NorthIndianCuisine());
		cuisineBasedRestaurant.put(CuisineEnum.SouthIndian, new SouthIndianCuisine());
		cuisineBasedRestaurant.put(CuisineEnum.Chinese, new ChineseCuisine());
		for (Restaurant restaurant : inputRestaurant) {
			CuisineEnum cuisine = restaurant.getCuisine();
			if (cuisine.equals(CuisineEnum.NorthIndian)) {
				AbstractCuisine northIndianCuisinie = cuisineBasedRestaurant.get(CuisineEnum.NorthIndian);
				northIndianCuisinie.add(restaurant);
				cuisineBasedRestaurant.put(cuisine, northIndianCuisinie);
			} else if (cuisine.equals(CuisineEnum.SouthIndian)) {
				AbstractCuisine southIndianCuisinie = cuisineBasedRestaurant.get(CuisineEnum.SouthIndian);
				southIndianCuisinie.add(restaurant);
				cuisineBasedRestaurant.put(cuisine, southIndianCuisinie);
			} else {

				AbstractCuisine chineseCuisinie = cuisineBasedRestaurant.get(CuisineEnum.Chinese);
				chineseCuisinie.add(restaurant);
				cuisineBasedRestaurant.put(cuisine, chineseCuisinie);

			}
		}
		for (AbstractCuisine rec : cuisineBasedRestaurant.values()) {
			rec.categorizeRestaurants();
		}
		return cuisineBasedRestaurant;
	}

	private Collection<Restaurant> getRestaurant(HashMap<CuisineEnum, AbstractCuisine> cuisineBasedRestaurant,
			UserPreferences userPreference) {
		List<Rule> rulesList = defaultRuleService.getRules(userPreference);
		HashMap<String, Restaurant> recommendedRestaurantList = new HashMap<>();
		for (Rule rule : rulesList) {

			defaultRuleService.applyRules(rule, cuisineBasedRestaurant, recommendedRestaurantList);
			if (recommendedRestaurantList.size() >= 100)
				break;
		}
		return recommendedRestaurantList.values();
	}

	private void init(UserPreferences userPreference) {
		logger.info("setting users primary and secondary preferences");
		defaultUserService.setUserCuisinePreference(userPreference);
		defaultUserService.setUserCostPreference(userPreference);
	}

}
