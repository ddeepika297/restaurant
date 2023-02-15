package com.GBI.Restaurant.model;

public class CostTracking implements Comparable<CostTracking> {
	public CostTracking(int type, int noOfOrders) {
		super();
		this.type = type;
		this.noOfOrders = noOfOrders;
	}

	private int type;
	private int noOfOrders;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getNoOfOrders() {
		return noOfOrders;
	}

	public void setNoOfOrders(int noOfOrders) {
		this.noOfOrders = noOfOrders;
	}

	@Override
	public int compareTo(CostTracking o) {
		return noOfOrders;
	}

	@Override
	public String toString() {
		return "CostTracking [type=" + type + ", noOfOrders=" + noOfOrders + "]";
	}

}
