package com.GBI.Restaurant.controller;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.GBI.Restaurant.model.CostTracking;
import com.GBI.Restaurant.model.CuisineEnum;
import com.GBI.Restaurant.model.CuisineTracking;
import com.GBI.Restaurant.model.Restaurant;
import com.GBI.Restaurant.model.User;
import com.GBI.Restaurant.service.IRestaurantRecommendationsService;

@Component
public class RecommendationEngine {
	private static final Logger logger = LoggerFactory.getLogger(RecommendationEngine.class);
	private final IRestaurantRecommendationsService restaurantRecommendationsService;

	@Autowired
	public RecommendationEngine(IRestaurantRecommendationsService restaurantRecommendationsService) {
		this.restaurantRecommendationsService = restaurantRecommendationsService;
	}

	public void getRestaurantRecommendations() {
		User u1 = createUser();
		List<Restaurant> inputRestaurant = getRestaurantList();
		Collection<Restaurant> restaurantList = restaurantRecommendationsService.getRestaurantRecommendations(u1,
				inputRestaurant);
		for (Restaurant restaurant : restaurantList) {
			System.out.println(restaurant.toString());
		}
	}

	private List<Restaurant> getRestaurantList() {
		logger.info("List of restaurant creation for testing purpose");
		List<Restaurant> restaurantLst = new LinkedList<>();
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(1).setCuisineEnum(CuisineEnum.Chinese)
				.setRating(4.81).setOnboardedTime(null).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(1).setCuisineEnum(CuisineEnum.Chinese)
				.setRating(4.71).setOnboardedTime(Date.from(Instant.now())).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(1).setCuisineEnum(CuisineEnum.Chinese)
				.setRating(1.1).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(1).setCuisineEnum(CuisineEnum.Chinese)
				.setRating(3.11).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(1).setCuisineEnum(CuisineEnum.Chinese)
				.setRating(5.18).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setRecommended(true).setCostBracket(2)
				.setCuisineEnum(CuisineEnum.Chinese).setRating(1.1).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(2).setCuisineEnum(CuisineEnum.Chinese)
				.setRating(3.31).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(3).setCuisineEnum(CuisineEnum.Chinese)
				.setRating(5.1).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setRecommended(true).setCostBracket(1)
				.setCuisineEnum(CuisineEnum.SouthIndian).setRating(4.91).setOnboardedTime(null).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(1).setCuisineEnum(CuisineEnum.SouthIndian)
				.setRating(4.1).setOnboardedTime(Date.from(Instant.now())).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(1).setCuisineEnum(CuisineEnum.SouthIndian)
				.setRating(5.0).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setRecommended(true).setCostBracket(2)
				.setCuisineEnum(CuisineEnum.NorthIndian).setRating(3.31).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setRecommended(true).setCostBracket(2)
				.setCuisineEnum(CuisineEnum.NorthIndian).setRating(5.1).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(2).setCuisineEnum(CuisineEnum.SouthIndian)
				.setRating(1.1).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setRecommended(true).setCostBracket(2)
				.setCuisineEnum(CuisineEnum.SouthIndian).setRating(3.15).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setRecommended(true).setCostBracket(3)
				.setCuisineEnum(CuisineEnum.NorthIndian).setRating(5.13).build());
		restaurantLst.add(Restaurant.Builder.newInstance().setCostBracket(3).setCuisineEnum(CuisineEnum.NorthIndian)
				.setRating(3.31).setOnboardedTime(Date.from(Instant.now())).build());
		return restaurantLst;
	}

	private static User createUser() {
		logger.info("user created for testing");
		CuisineTracking[] cuisines = new CuisineTracking[3];
		cuisines[0] = new CuisineTracking(CuisineEnum.NorthIndian, 66);
		cuisines[1] = new CuisineTracking(CuisineEnum.SouthIndian, 16);
		cuisines[2] = new CuisineTracking(CuisineEnum.Chinese, 60);
		CostTracking[] costBracket = new CostTracking[4];
		costBracket[0] = new CostTracking(1, 100);
		costBracket[1] = new CostTracking(3, 10);
		costBracket[2] = new CostTracking(2, 120);
		return new User(cuisines, costBracket);
	}
}
