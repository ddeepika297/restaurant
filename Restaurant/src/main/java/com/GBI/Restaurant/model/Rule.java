package com.GBI.Restaurant.model;

import java.util.Arrays;

public class Rule {

	public Rule() {
	}

	public Rule(boolean isRecommended, boolean isNewlyCreated, int[] cost, CuisineEnum[] cuisine,
			TypeOfRuleEnum typeOfRule, Rule subRule, double minimumRating) {

		this.isRecommended = isRecommended;
		this.isNewlyCreated = isNewlyCreated;
		this.cost = cost;
		this.cuisine = cuisine;
		this.typeOfRule = typeOfRule;
		this.subRule = subRule;
		this.minimumRating = minimumRating;
	}

	boolean isRecommended;

	public boolean isRecommended() {
		return isRecommended;
	}

	public void setRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	public boolean isNewlyCreated() {
		return isNewlyCreated;
	}

	public void setNewlyCreated(boolean isNewlyCreated) {
		this.isNewlyCreated = isNewlyCreated;
	}

	public int[] getCost() {
		return cost;
	}

	public void setCost(int[] cost) {
		this.cost = cost;
	}

	public CuisineEnum[] getCuisine() {
		return cuisine;
	}

	public void setCuisine(CuisineEnum[] cuisine) {
		this.cuisine = cuisine;
	}

	public TypeOfRuleEnum getTypeOfRule() {
		return typeOfRule;
	}

	public void setTypeOfRule(TypeOfRuleEnum typeOfRule) {
		this.typeOfRule = typeOfRule;
	}

	public Rule getSubRule() {
		return subRule;
	}

	public void setSubRule(Rule subRule) {
		this.subRule = subRule;
	}

	public double getMinimumRating() {
		return minimumRating;
	}

	public void setMinimumRating(double minimumRating) {
		this.minimumRating = minimumRating;
	}

	boolean isNewlyCreated;
	int[] cost;
	CuisineEnum[] cuisine;
	TypeOfRuleEnum typeOfRule = TypeOfRuleEnum.SINGLE;
	Rule subRule;
	double minimumRating;

	public Rule(Builder builder) {
		this.isRecommended = builder.isRecommended;
		this.isNewlyCreated = builder.isNewlyCreated;
		this.cost = builder.cost;
		this.cuisine = builder.cuisine;
		this.typeOfRule = builder.typeOfRule;
		this.subRule = builder.subRule;
		this.minimumRating = builder.minimumRating;
	}

	public Rule(Rule rule1, Rule rule2, TypeOfRuleEnum typeOfRule) {
		this.isRecommended = rule1.isRecommended;
		this.isNewlyCreated = rule1.isNewlyCreated;
		this.cost = rule1.cost;
		this.cuisine = rule1.cuisine;
		this.minimumRating = rule1.minimumRating;
		this.typeOfRule = typeOfRule;
		this.subRule = rule2;

	}

	// Static class Builder
	public static class Builder {
		Rule subRule;
		boolean isRecommended;
		boolean isNewlyCreated;
		int[] cost;
		CuisineEnum[] cuisine;
		TypeOfRuleEnum typeOfRule = TypeOfRuleEnum.SINGLE;
		double minimumRating;

		public Rule getSubRule() {
			return subRule;
		}

		public Builder setSubRule(Rule subRule) {
			this.subRule = subRule;
			return this;
		}

		public Builder setMinimumRating(double minimumRating) {
			this.minimumRating = minimumRating;
			return this;
		}

		public Builder setTypeOfRule(TypeOfRuleEnum typeOfRule) {
			this.typeOfRule = typeOfRule;
			return this;
		}

		public static Builder newInstance() {
			return new Builder();
		}

		private Builder() {
		}

		// Setter methods
		public Builder setIsRecommended(boolean isRecommended) {
			this.isRecommended = isRecommended;
			return this;
		}

		public Builder setNewlyCreated(boolean isNewlyCreated) {
			this.isNewlyCreated = isNewlyCreated;
			return this;
		}

		public Builder setCost(int[] cost) {
			this.cost = cost;
			return this;
		}

		public Builder setCuisine(CuisineEnum[] cuisine) {
			this.cuisine = cuisine;
			return this;
		}

		// build method
		public Rule build() {
			return new Rule(this);
		}

	}

	@Override
	public String toString() {
		return "Rule [isRecommended=" + isRecommended + ", isNewlyCreated=" + isNewlyCreated + ", cost="
				+ Arrays.toString(cost) + ", cuisine=" + Arrays.toString(cuisine) + ", typeOfRule=" + typeOfRule
				+ ", subRule=" + subRule + ", minimumRating=" + minimumRating + "]";
	}

}
