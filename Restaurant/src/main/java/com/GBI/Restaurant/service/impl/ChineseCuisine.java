package com.GBI.Restaurant.service.impl;

import com.GBI.Restaurant.model.CuisineEnum;
import com.GBI.Restaurant.service.AbstractCuisine;

public class ChineseCuisine extends AbstractCuisine {
	public ChineseCuisine() {
		super();
	}

	public void setCuisineType() {
		this.setType(CuisineEnum.Chinese);
	}
}
