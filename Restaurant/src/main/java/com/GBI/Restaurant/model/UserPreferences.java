package com.GBI.Restaurant.model;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.GBI.Restaurant.service.IUserService;

public class UserPreferences {
	User user;
	CuisineEnum[] primaryCuisine;
	CuisineEnum[] secondaryCuisine;
	int[] primaryCost;
	int[] secondaryCost;
	@Autowired
	IUserService userService;

	public UserPreferences() {
	}

	public UserPreferences(User user) {
		this.user = user;
	}

	public UserPreferences(CuisineEnum[] primaryCuisine, CuisineEnum[] secondaryCuisine, int[] primaryCost,
			int[] secondaryCost, User user) {
		this.user = user;
		this.primaryCuisine = primaryCuisine;
		this.secondaryCuisine = secondaryCuisine;
		this.primaryCost = primaryCost;
		this.secondaryCost = secondaryCost;
	}

	public User getUser() {
		return user;
	}

	public void init() {
		userService.setUserCuisinePreference(this);
		userService.setUserCostPreference(this);
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CuisineEnum[] getPrimaryCuisine() {
		return primaryCuisine;
	}

	public void setPrimaryCuisine(CuisineEnum[] primaryCuisine) {
		this.primaryCuisine = primaryCuisine;
	}

	public CuisineEnum[] getSecondaryCuisine() {
		return secondaryCuisine;
	}

	public void setSecondaryCuisine(CuisineEnum[] secondaryCuisine) {
		this.secondaryCuisine = secondaryCuisine;
	}

	public int[] getPrimaryCost() {
		return primaryCost;
	}

	public void setPrimaryCost(int[] primaryCost) {
		this.primaryCost = primaryCost;
	}

	public int[] getSecondaryCost() {
		return secondaryCost;
	}

	public void setSecondaryCost(int[] secondaryCost) {
		this.secondaryCost = secondaryCost;
	}

	@Override
	public String toString() {
		return "UserPreferences [user=" + user + ", primaryCuisine=" + Arrays.toString(primaryCuisine)
				+ ", secondaryCuisine=" + Arrays.toString(secondaryCuisine) + ", primaryCost="
				+ Arrays.toString(primaryCost) + ", secondaryCost=" + Arrays.toString(secondaryCost) + ", userService="
				+ userService + "]";
	}

}
