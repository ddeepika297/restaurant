package com.GBI.Restaurant.service.impl;

import com.GBI.Restaurant.model.CuisineEnum;
import com.GBI.Restaurant.service.AbstractCuisine;

public class NorthIndianCuisine extends AbstractCuisine {

	public NorthIndianCuisine() {
		super();
	}

	public void setCuisineType() {
		this.setType(CuisineEnum.NorthIndian);
	}

}
