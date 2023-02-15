package com.GBI.Restaurant.service;

import java.util.HashMap;
import java.util.Map;

import com.GBI.Restaurant.model.CostBracketStruct;
import com.GBI.Restaurant.model.CuisineEnum;
import com.GBI.Restaurant.model.Restaurant;

public abstract class AbstractCuisine {

	public AbstractCuisine() {
		this.costBracketLst = new HashMap<>();
	}

	CuisineEnum type;
	Map<Integer, CostBracketStruct> costBracketLst;

	abstract protected void setCuisineType();

	public void add(Restaurant restaurant) {
		int cost = restaurant.getCostBracket();
		CostBracketStruct costBracketStruct = costBracketLst.getOrDefault(cost, new CostBracketStruct());
		costBracketStruct.add(restaurant);
		costBracketLst.put(cost, costBracketStruct);
	}

	public void categorizeRestaurants() {
		for (CostBracketStruct rec : costBracketLst.values()) {
			rec.categorizeRestaurants();
		}
	}

	public CuisineEnum getType() {
		return type;
	}

	public void setType(CuisineEnum type) {
		this.type = type;
	}

	public Map<Integer, CostBracketStruct> getCostBracketLst() {
		return costBracketLst;
	}

	public void setCostBracketLst(Map<Integer, CostBracketStruct> costBracketLst) {
		this.costBracketLst = costBracketLst;
	}
}
