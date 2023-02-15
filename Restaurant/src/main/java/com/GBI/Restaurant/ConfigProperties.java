package com.GBI.Restaurant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.GBI.Restaurant.model.Restaurant;
import com.GBI.Restaurant.model.User;
import com.GBI.Restaurant.model.UserPreferences;

@Configuration
public class ConfigProperties {
	@Bean
	public User user() {
		return new User();
	}

	@Bean
	public Restaurant restaurant() {
		return new Restaurant();
	}

	@Bean
	public UserPreferences userPreferences() {
		return new UserPreferences();
	}
}
