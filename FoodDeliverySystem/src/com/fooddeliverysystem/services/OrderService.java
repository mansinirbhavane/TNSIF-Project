package com.fooddeliverysystem.services;

import com.fooddeliverysystem.entities.Order;
import com.fooddeliverysystem.entities.OrderItem;

public class OrderService{
    private Order currentOrder;

    /**
     * Start a new order with customer name & address
     */
    public void startNewOrder(String customerName, String address) {
        this.currentOrder = new Order(customerName, address);
        System.out.println("🛒 New order started for " + customerName + " at " + address);
    }

    /**
     * Add an item to the current order
     */
    public void addItemToOrder(String itemName, int quantity, double price) {
        if (currentOrder == null) {
            System.out.println("❌ No active order. Please start a new order first.");
            return;
        }
        OrderItem item = new OrderItem(itemName, quantity, price);
        currentOrder.addItem(item);
        System.out.println("✅ Added: " + itemName + " x" + quantity + " @ ₹" + price);
    }

    /**
     * Print the final bill
     */
    public void printFinalBill() {
        if (currentOrder != null) {
            currentOrder.generateReceipt();
        } else {
            System.out.println("❌ No order to print.");
        }
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}