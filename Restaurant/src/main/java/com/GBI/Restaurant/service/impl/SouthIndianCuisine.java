package com.GBI.Restaurant.service.impl;

import com.GBI.Restaurant.model.CuisineEnum;
import com.GBI.Restaurant.service.AbstractCuisine;

public class SouthIndianCuisine extends AbstractCuisine {

	public SouthIndianCuisine() {
	}

	public void setCuisineType() {
		this.setType(CuisineEnum.SouthIndian);
	}

}
