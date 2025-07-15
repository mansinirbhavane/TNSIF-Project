package com.fooddeliverysystem.entities;

public class OrderItem 
{
	private String itemName;
    private int quantity;
    private double price;

    public OrderItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    public String toString() {
        return itemName + " x" + quantity + " @ ₹" + price + " = ₹" + getTotalPrice();
    }

    // Getters
    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

}