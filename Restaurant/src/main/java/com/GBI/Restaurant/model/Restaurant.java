package com.GBI.Restaurant.model;

import java.util.Date;
import java.util.UUID;

public class Restaurant {
	public Restaurant() {
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", cuisineEnum=" + cuisineEnum + ", costBracket="
				+ costBracket + ", rating=" + rating + ", isRecommended=" + isRecommended + ", onboardedTime="
				+ onboardedTime + "]";
	}

	public Restaurant(CuisineEnum cuisineEnum, int costBracket, double rating, boolean isRecommended,
			Date onboardedTime) {
		this.restaurantId = UUID.randomUUID().toString();
		this.cuisineEnum = cuisineEnum;
		this.costBracket = costBracket;
		this.rating = rating;
		this.isRecommended = isRecommended;
		this.onboardedTime = onboardedTime;
	}

	public Restaurant(Builder builder) {
		this.restaurantId = UUID.randomUUID().toString();
		this.cuisineEnum = builder.cuisineEnum;
		this.costBracket = builder.costBracket;
		this.rating = builder.rating;
		this.isRecommended = builder.isRecommended;
		this.onboardedTime = builder.onboardedTime;
	}

	private String restaurantId;
	private CuisineEnum cuisineEnum;
	private int costBracket;
	private double rating;
	private boolean isRecommended;
	private Date onboardedTime;

	public static class Builder {

		public static Builder newInstance() {
			return new Builder();
		}

		private Builder() {
		}

		public Restaurant build() {
			return new Restaurant(this);
		}

		private CuisineEnum cuisineEnum;
		private int costBracket;
		private double rating;
		private boolean isRecommended;
		private Date onboardedTime;

		public Builder setCuisineEnum(CuisineEnum cuisineEnum) {
			this.cuisineEnum = cuisineEnum;
			return this;
		}

		public Builder setCostBracket(int costBracket) {
			this.costBracket = costBracket;
			return this;
		}

		public Builder setRating(double d) {
			this.rating = d;
			return this;
		}

		public Builder setRecommended(boolean isRecommended) {
			this.isRecommended = isRecommended;
			return this;
		}

		public Builder setOnboardedTime(Date onboardedTime) {
			this.onboardedTime = onboardedTime;
			return this;
		}

	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public CuisineEnum getCuisine() {
		return cuisineEnum;
	}

	public void setCuisine(CuisineEnum cuisineEnum) {
		this.cuisineEnum = cuisineEnum;
	}

	public int getCostBracket() {
		return costBracket;
	}

	public void setCostBracket(int costBracket) {
		this.costBracket = costBracket;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	public Date getOnboardedTime() {
		return onboardedTime;
	}

	public void setOnboardedTime(Date onboardedTime) {
		this.onboardedTime = onboardedTime;
	}

}
