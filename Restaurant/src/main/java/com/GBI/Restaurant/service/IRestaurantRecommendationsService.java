package com.GBI.Restaurant.service;

import java.util.Collection;
import java.util.List;

import com.GBI.Restaurant.model.Restaurant;
import com.GBI.Restaurant.model.User;

public interface IRestaurantRecommendationsService {

	Collection<Restaurant> getRestaurantRecommendations(User user, List<Restaurant> inputRestaurant);

}
