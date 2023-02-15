package com.GBI.Restaurant.service;

import com.GBI.Restaurant.model.UserPreferences;

public interface IUserService {

	void setUserCuisinePreference(UserPreferences userPreference);

	void setUserCostPreference(UserPreferences userPreference);
}
