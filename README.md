Notes
1) Have rearranged inputRestaurant in the form of map of maps, this would result in easily quering the data and providing the required result
2) Have used various design patters like strategy, factory and builder problem. These help in mainting the code and making it extensible 
3) Have put up just basic loggers
4) Haven't written junit, but tested the code from the main clas using a dummy example
5) The code has bee written keeping that there would be about 1000 restaurants only, if the size of restaurant further increases, then map-reduce would be required to order the input restaurants.



Problem stmt
# restaurant
Restaurant Recommendation Engine
Assume that you are building a recommendation engine for your food delivery app and product team gives you the spec with following requirements.

Your algorithm considers following criterias
Cuisine of the restaurant : North Indian, Chinese, South Indian etc
Cost bracket: 1,2,3,4,5 (Increasing order from cheap to costly)
Featured restaurants: Restaurants which are officially tested by our app and recommended.
New restaurants: Restaurants which are onboarded in the last 48hrs.
Rating: Average user rating for the restaurant (from 0.0 - 5.0)

For every user that orders from the app we track following parameters:
Cuisine of the restaurant
Cost bracket

Top most cuisine will be considered as a primary cuisine of the user and next 2 are considered as secondary. Similarly, the top most cost bracket will be considered as a primary cost bracket of the user and the next 2 are considered as secondary.


We want to sort all the restaurants available in the vicinity and show top 100 unique restaurants with the following logic:

Order
Condition
1
Featured restaurants of primary cuisine and primary cost bracket. If none, then all featured restaurants of primary cuisine, secondary cost and secondary cuisine, primary cost
2
All restaurants of Primary cuisine, primary cost bracket with rating >= 4
3
All restaurants of Primary cuisine, secondary cost bracket with rating >= 4.5
4
All restaurants of secondary cuisine, primary cost bracket with rating >= 4.5
5
Top 4 newly created restaurants by rating
6
All restaurants of Primary cuisine, primary cost bracket with rating < 4
7
All restaurants of Primary cuisine, secondary cost bracket with rating < 4.5
8
All restaurants of secondary cuisine, primary cost bracket with rating < 4.5
9
All restaurants of any cuisine, any cost bracket



Given the below classes. Implement the getRestaurantRecommendation function in any language of your choice:

Enum Cuisine {
	SouthIndian, NorthIndian, Chinese etc.
}

Class Restaurant {
	private string restaurantId
	private Cuisine cuisine
	private int costBracket
	private float rating
	private boolean isRecommended
	private Date onboardedTime
}

Class CuisineTracking {
	Private string type
	Private string noOfOrders
}

Class CuisineTracking {
	Private string type
	Private string noOfOrders
}

Class CostTracking {
	Private string type
	Private string noOfOrders
}

Class User {
	private CuisineTracking[]  cuisines
	private CostTracking[] costBracket
}

public string[] getRestaurantRecommendations(User user, Restaurant[] availableRestaurants){

	// Takes user and restaurant while returning back array of restaurant Ids in the right sorting order

}

Evaluation Criteria
Your solution will not only be evaluated on the correctness of your code but also the readability, maintainability and extensibility of your code. 
The code needs to be production quality. 
You can select any language of your choice to write code.
You can add code in this document or you can generate the code in any tool of your choice and share the link for the same.


