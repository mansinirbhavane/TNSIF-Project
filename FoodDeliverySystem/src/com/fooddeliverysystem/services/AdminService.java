package com.fooddeliverysystem.services;

import com.fooddeliverysystem.entities.*;

import java.util.*;

public class AdminService {
    private List<DeliveryPerson> deliveryPeople = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void addDeliveryPerson(DeliveryPerson dp) {
        deliveryPeople.add(dp);
        System.out.println("Delivery person added successfully!");
    }

    public List<DeliveryPerson> getDeliveryPeople() {
        return deliveryPeople;
    }

    public void placeOrder(String customerName, String address, Map<String, Integer> cartItems, double pricePerItem) {
        // Create order
        Order order = new Order(customerName, address);
        
        // Add each item to the order
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            OrderItem item = new OrderItem(itemName, quantity, pricePerItem);
            order.addItem(item);
        }

        orders.add(order);
        System.out.println("Order placed successfully with Order ID: " + order.getOrderId());
    }

    public void assignDeliveryPerson(String orderId, int deliveryPersonId) {
        Order order = getOrderById(orderId);
        DeliveryPerson dp = getDeliveryPersonById(deliveryPersonId);
        if (order != null && dp != null) {
            order.assignDeliveryPerson(dp);
            System.out.println("Delivery person assigned to order successfully!");
        } else {
            System.out.println("Order or Delivery Person not found.");
        }
    }

    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    private Order getOrderById(String id) {
        for (Order o : orders) {
            if (o.getOrderId().equals(id)) return o;
        }
        return null;
    }

    private DeliveryPerson getDeliveryPersonById(int id) {
        for (DeliveryPerson d : deliveryPeople) {
            if (d.getDeliveryPersonId() == id) return d;
        }
        return null;
    }
}