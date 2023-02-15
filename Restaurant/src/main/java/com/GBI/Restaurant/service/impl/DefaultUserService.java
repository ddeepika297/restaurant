package com.GBI.Restaurant.service.impl;

import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.GBI.Restaurant.model.CostTracking;
import com.GBI.Restaurant.model.CuisineEnum;
import com.GBI.Restaurant.model.CuisineTracking;
import com.GBI.Restaurant.model.UserPreferences;
import com.GBI.Restaurant.service.IUserService;

@Service
public class DefaultUserService implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);

	@Override
	public void setUserCuisinePreference(UserPreferences userPreference) {
		CuisineTracking[] cuisine = userPreference.getUser().getCuisines();
		Arrays.sort(cuisine, Collections.reverseOrder());
		// setup PrimaryCusisine
		if (cuisine.length > 0) {
			CuisineEnum[] primaryCuisine = { cuisine[0].getType() };
			userPreference.setPrimaryCuisine(primaryCuisine);
		}
		// setup secondaryCuisine
		if (cuisine.length == 1) {
			CuisineEnum[] secondaryCuisine = { cuisine[1].getType() };
			userPreference.setSecondaryCuisine(secondaryCuisine);
		} else if (cuisine.length > 2) {
			CuisineEnum[] secondaryCuisine = { cuisine[1].getType(), cuisine[2].getType() };
			userPreference.setSecondaryCuisine(secondaryCuisine);
		}
		logger.info("setCuisinePreference for user");
	}

	@Override
	public void setUserCostPreference(UserPreferences userPreference) {
		CostTracking[] cost = userPreference.getUser().getCostBracket();
		Arrays.sort(cost, Collections.reverseOrder());
		// setup PrimaryCost
		if (cost.length > 0) {
			int[] primaryCost = { cost[0].getType() };
			userPreference.setPrimaryCost(primaryCost);
		}
		// setup secondaryCost
		if (cost.length > 1) {
			int[] secondaryCost = { cost[1].getType() };
			userPreference.setSecondaryCost(secondaryCost);
		}
		if (cost.length > 2) {
			int[] secondaryCost = { cost[1].getType(), cost[2].getType() };
			userPreference.setSecondaryCost(secondaryCost);
		}
		logger.info("setCostPreference for user");
	}
}
