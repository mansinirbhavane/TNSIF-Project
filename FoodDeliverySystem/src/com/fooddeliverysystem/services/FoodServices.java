package com.fooddeliverysystem.services;

import com.fooddeliverysystem.entities.FoodItem;
import com.fooddeliverysystem.entities.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class FoodServices 
{
    private List<Restaurant> restaurants;

    public FoodServices() {
        restaurants = new ArrayList<>();

        // 🚀 Add sample data so customers can see menu & order immediately

        Restaurant r1 = new Restaurant(101, "Pizza Palace", "MG Road, Pune");
        r1.addFoodItem(new FoodItem(1, "Margherita Pizza", 250));
        r1.addFoodItem(new FoodItem(2, "Farmhouse Pizza", 350));
        r1.addFoodItem(new FoodItem(3, "Garlic Bread", 120));

        Restaurant r2 = new Restaurant(102, "Spice Hub", "FC Road, Pune");
        r2.addFoodItem(new FoodItem(4, "Paneer Butter Masala", 220));
        r2.addFoodItem(new FoodItem(5, "Butter Naan", 40));
        r2.addFoodItem(new FoodItem(6, "Veg Biryani", 180));

        Restaurant r3 = new Restaurant(103, "Burger Corner", "JM Road, Pune");
        r3.addFoodItem(new FoodItem(7, "Classic Veg Burger", 90));
        r3.addFoodItem(new FoodItem(8, "Cheese Burger", 120));
        r3.addFoodItem(new FoodItem(9, "French Fries", 60));

        restaurants.add(r1);
        restaurants.add(r2);
        restaurants.add(r3);
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        System.out.println("✅ Restaurant added successfully!");
    }

    public void addFoodItemToRestaurant(int restaurantId, FoodItem foodItem) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.addFoodItem(foodItem);
            System.out.println("✅ Food item added successfully!");
        } else {
            System.out.println("❌ Restaurant not found.");
        }
    }

    public void removeFoodItemFromRestaurant(int restaurantId, int foodId) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurant.removeFoodItem(foodId);
            System.out.println("✅ Food item removed successfully!");
        } else {
            System.out.println("❌ Restaurant not found.");
        }
    }

    public void displayRestaurantsAndMenus() {
        System.out.println("\n=== Restaurants and Menus ===");
        for (Restaurant r : restaurants) {
            System.out.println(r); // prints Restaurant ID and name
            for (FoodItem item : r.getMenu()) {
                System.out.println("   " + item); // prints food details
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