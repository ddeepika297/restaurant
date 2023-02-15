package com.GBI.Restaurant.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.GBI.Restaurant.model.CostBracketStruct;
import com.GBI.Restaurant.model.CuisineEnum;
import com.GBI.Restaurant.model.Restaurant;
import com.GBI.Restaurant.model.Rule;
import com.GBI.Restaurant.model.TypeOfRuleEnum;
import com.GBI.Restaurant.model.UserPreferences;
import com.GBI.Restaurant.service.AbstractCuisine;
import com.GBI.Restaurant.service.IRuleService;
import com.GBI.Restaurant.util.Constants;
import com.GBI.Restaurant.util.Helper;

@Service
public class DefaultRuleService implements IRuleService {

	private static final Logger logger = LoggerFactory.getLogger(DefaultRuleService.class);

	@Override
	public List<Rule> getRules(UserPreferences userPreference) {
		logger.info("set all rules according to doc provided");
		List<Rule> rules = new LinkedList<Rule>();
		CuisineEnum[] allCuisine = Helper.getAllCuisine();
		Rule rule1 = Rule.Builder.newInstance().setIsRecommended(true).setCuisine(userPreference.getPrimaryCuisine())
				.setCost(userPreference.getPrimaryCost()).build();
		Rule rule2 = Rule.Builder.newInstance().setIsRecommended(true).setCuisine(userPreference.getPrimaryCuisine())
				.setCost(userPreference.getSecondaryCost()).build();
		Rule rule3 = Rule.Builder.newInstance().setIsRecommended(true).setCuisine(userPreference.getSecondaryCuisine())
				.setCost(userPreference.getPrimaryCost()).build();
		Rule rule4 = new Rule(rule2, rule3, TypeOfRuleEnum.AND);
		rules.add(new Rule(rule1, rule4, TypeOfRuleEnum.OR));
		rules.add(Rule.Builder.newInstance().setCuisine(userPreference.getPrimaryCuisine())
				.setCost(userPreference.getPrimaryCost()).setMinimumRating(4).build());
		rules.add(Rule.Builder.newInstance().setCuisine(userPreference.getPrimaryCuisine())
				.setCost(userPreference.getSecondaryCost()).setMinimumRating(4.5).build());
		rules.add(Rule.Builder.newInstance().setCuisine(userPreference.getSecondaryCuisine())
				.setCost(userPreference.getSecondaryCost()).setMinimumRating(4.5).build());
		rules.add(Rule.Builder.newInstance().setNewlyCreated(true).build());
		rules.add(Rule.Builder.newInstance().setCuisine(userPreference.getPrimaryCuisine())
				.setCost(userPreference.getPrimaryCost()).build());
		rules.add(Rule.Builder.newInstance().setCuisine(userPreference.getPrimaryCuisine())
				.setCost(userPreference.getSecondaryCost()).build());
		rules.add(Rule.Builder.newInstance().setCuisine(userPreference.getSecondaryCuisine())
				.setCost(userPreference.getSecondaryCost()).build());
		rules.add(Rule.Builder.newInstance().setCuisine(allCuisine).build());
		return rules;
	}

	@Override
	public void applyRules(Rule rule, HashMap<CuisineEnum, AbstractCuisine> cuisineBasedRestaurant,
			HashMap<String, Restaurant> recommendedRestaurantList) {
		if (recommendedRestaurantList.values().size() >= 100)
			return;
		List<Restaurant> getMatachingRestuarants = applyRuleTypeAndGetMatchingRestaurants(rule, cuisineBasedRestaurant);
		for (Restaurant r : getMatachingRestuarants) {
			if (!recommendedRestaurantList.containsKey(r.getRestaurantId())) {
				recommendedRestaurantList.put(r.getRestaurantId(), r);
			}
			if (recommendedRestaurantList.values().size() >= 100)
				break;
		}
	}

	private List<Restaurant> applyRuleTypeAndGetMatchingRestaurants(Rule rule,
			HashMap<CuisineEnum, AbstractCuisine> cuisineBasedRestaurant) {
		TypeOfRuleEnum ruleType = rule.getTypeOfRule();
		if (ruleType == TypeOfRuleEnum.SINGLE) {
			return getMatchingRestaurant(rule, cuisineBasedRestaurant);

		} else if (ruleType == TypeOfRuleEnum.AND) {
			rule.setTypeOfRule(TypeOfRuleEnum.SINGLE);
			List<Restaurant> sublist1 = getMatchingRestaurant(rule, cuisineBasedRestaurant);
			List<Restaurant> sublist2 = applyRuleTypeAndGetMatchingRestaurants(rule.getSubRule(),
					cuisineBasedRestaurant);

			sublist1.addAll(sublist2);
			return sublist1;
		} else // TypeOfRuleEnum.OR
		{
			rule.setTypeOfRule(TypeOfRuleEnum.SINGLE);
			List<Restaurant> sublist1 = getMatchingRestaurant(rule, cuisineBasedRestaurant);
			if (!sublist1.isEmpty())
				return sublist1;
			List<Restaurant> sublist2 = applyRuleTypeAndGetMatchingRestaurants(rule.getSubRule(),
					cuisineBasedRestaurant);
			return sublist2;
		}
	}

	private List<Restaurant> getMatchingRestaurant(Rule rule,
			HashMap<CuisineEnum, AbstractCuisine> cuisineBasedRestaurant) {
		List<Restaurant> resList;
		if (rule.isNewlyCreated()) {
			resList = getnewlyCreatedRestaurantFromAllCuisine(cuisineBasedRestaurant);
		} else {
			resList = getRestaurant(rule.getCost(), rule.getCuisine(), rule.getMinimumRating(), rule.isRecommended(),
					cuisineBasedRestaurant);
		}
		return resList;
	}

	private List<Restaurant> getRestaurant(int[] costbracket, CuisineEnum[] cuisineLst, double minimumRating,
			boolean isRecommended, HashMap<CuisineEnum, AbstractCuisine> cuisineBasedRestaurant) {
		List<Restaurant> resList = new LinkedList<>();
		for (CuisineEnum cuisine : cuisineLst) {
			AbstractCuisine cuisineObj = cuisineBasedRestaurant.get(cuisine);
			if (costbracket == null || costbracket.length == 0) {
				costbracket = Helper.getAllCostBrackets();
			}
			if (cuisineLst == null || cuisineLst.length == 0) {
				cuisineLst = Helper.getAllCuisine();
			}
			for (int i : costbracket) {
				Map<Integer, CostBracketStruct> costBracketMap = cuisineObj.getCostBracketLst();
				if (!costBracketMap.containsKey(i))
					continue;
				List<Restaurant> sortedRestList;
				if (isRecommended) {
					sortedRestList = costBracketMap.get(i).getRecommendedRestaurantSortedBasedOnRating();
				} else {
					sortedRestList = costBracketMap.get(i).getNonRecommendedRestaurantSortedBasedOnRating();
				}
				if (minimumRating < 1) {
					resList.addAll(sortedRestList);
				} else {
					for (Restaurant res : sortedRestList) {
						if (res.getRating() >= minimumRating) {
							resList.add(res);
						} else
							break;
					}
				}
			}
		}
		return resList;
	}

	private List<Restaurant> getnewlyCreatedRestaurantFromAllCuisine(
			HashMap<CuisineEnum, AbstractCuisine> cuisineBasedRestaurant) {
		List<Restaurant> restaurantLst = new LinkedList<>();
		for (Entry<CuisineEnum, AbstractCuisine> rec : cuisineBasedRestaurant.entrySet()) {
			AbstractCuisine cuisine = rec.getValue();
			for (Entry<Integer, CostBracketStruct> cost : cuisine.getCostBracketLst().entrySet()) {
				restaurantLst.addAll(cost.getValue().getNewlyCreatedRestaurant());
			}
		}
		if (restaurantLst.size() > Constants.LIMIT) {
			restaurantLst = restaurantLst.subList(0, Constants.LIMIT);
		}
		return restaurantLst;

	}

}
