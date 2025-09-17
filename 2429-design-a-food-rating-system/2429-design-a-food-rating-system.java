class FoodRatings {
    private Map<String, String> foodsToCuisine;
    private Map<String, Integer> foodsToRating;

    private Map<String, PriorityQueue<Food>> cuisineToFood;


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodsToCuisine = new HashMap<>();
        foodsToRating = new HashMap<>();
        cuisineToFood = new HashMap<>();

        for (int i = 0; i < foods.length; ++i) {
            foodsToCuisine.put(foods[i], cuisines[i]);
            foodsToRating.put(foods[i], ratings[i]);

            cuisineToFood.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        foodsToRating.replace(food, newRating);
        
        String cuisine = foodsToCuisine.get(food);
        cuisineToFood.get(cuisine).add(new Food(newRating, food));
    }
    
    public String highestRated(String cuisine) {
        Food highest = cuisineToFood.get(cuisine).peek();

        while (foodsToRating.get(highest.food) != highest.rating) {
            cuisineToFood.get(cuisine).poll();
            highest = cuisineToFood.get(cuisine).peek();
        } 

        return highest.food;
    }
}

class Food implements Comparable<Food> {
    public int rating;
    public String food;

    public Food(int rating, String food) {
        this.rating = rating;
        this.food = food;
    }

    @Override
    public int compareTo(Food other) {
        if (rating == other.rating) {
            return food.compareTo(other.food);
        }

        return -1 * Integer.compare(rating, other.rating);
    }
}


/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */