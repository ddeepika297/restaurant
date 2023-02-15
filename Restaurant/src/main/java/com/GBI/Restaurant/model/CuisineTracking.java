package com.GBI.Restaurant.model;

public class CuisineTracking implements Comparable<CuisineTracking> {

	public CuisineEnum getType() {
		return type;
	}

	public void setType(CuisineEnum type) {
		this.type = type;
	}

	public int getNoOfOrders() {
		return noOfOrders;
	}

	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}

	public CuisineTracking(CuisineEnum type, int noOfOrders) {
		super();
		this.type = type;
		this.noOfOrders = noOfOrders;
	}

	private CuisineEnum type;
	private int noOfOrders;

	@Override
	public int compareTo(CuisineTracking o) {
		return noOfOrders;
	}

	@Override
	public String toString() {
		return "CuisineTracking [type=" + type + ", noOfOrders=" + noOfOrders + "]";
	}

}
