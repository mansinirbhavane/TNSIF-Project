package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.FoodItem;
import com.tns.fooddeliverysystem.entities.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class FoodServices {
    private List<Restaurant> restaurants;

    public FoodServices() {
        restaurants = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        System.out.println("Restaurant added successfully!");
    }

    public void addFoodItemToRestaurant(int restaurantId, FoodItem foodItem) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.addFoodItem(foodItem);
            System.out.println("Food item added successfully!");
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public void removeFoodItemFromRestaurant(int restaurantId, int foodId) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.removeFoodItem(foodId);
            System.out.println("Food item removed successfully!");
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public void displayRestaurantsAndMenus() {
        System.out.println("Restaurants and Menus:");
        for (Restaurant r : restaurants) {
            System.out.println(r);
            for (FoodItem item : r.getMenu()) {
                System.out.println(item);
            }
        }
    }

    public Restaurant getRestaurantById(int id) {
        for (Restaurant r : restaurants) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurants;
    }
}
