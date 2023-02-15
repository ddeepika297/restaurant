package com.GBI.Restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

import com.GBI.Restaurant.controller.RecommendationEngine;

@SpringBootApplication
@ComponentScan({ "com.GBI.Restaurant.service", "com.GBI.Restaurant.model", "com.GBI.Restaurant" })
@EnableAutoConfiguration
@ConfigurationPropertiesScan("com.GBI.Restaurant")
@EntityScan("com.GBI.model.User")
public class RestaurantRecommendationApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(RestaurantRecommendationApplication.class);
	private final RecommendationEngine recommendationEngine;

	@Autowired
	public RestaurantRecommendationApplication(RecommendationEngine recommendationEngine) {
		this.recommendationEngine = recommendationEngine;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestaurantRecommendationApplication.class, args);

		// RecommendationEngine recommendationEngine = new RecommendationEngine(null);
	}

	@Override
	public void run(String[] args) {
		logger.info("executing getRestaurantRecommendations ");
		recommendationEngine.getRestaurantRecommendations();
	}

}
