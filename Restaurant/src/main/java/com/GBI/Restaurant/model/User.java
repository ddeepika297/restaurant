package com.GBI.Restaurant.model;

import java.util.Arrays;

public class User {

	public User() {
	}

	private CuisineTracking[] cuisines;
	private CostTracking[] costBracket;

	public User(CuisineTracking[] cuisines, CostTracking[] costBracket) {
		this.cuisines = cuisines;
		this.costBracket = costBracket;
	}

	public CuisineTracking[] getCuisines() {
		return cuisines;
	}

	public void setCuisines(CuisineTracking[] cuisines) {
		this.cuisines = cuisines;
	}

	public CostTracking[] getCostBracket() {
		return costBracket;
	}

	public void setCostBracket(CostTracking[] costBracket) {
		this.costBracket = costBracket;
	}

	@Override
	public String toString() {
		return "User [cuisines=" + Arrays.toString(cuisines) + ", costBracket=" + Arrays.toString(costBracket) + "]";
	}

}
