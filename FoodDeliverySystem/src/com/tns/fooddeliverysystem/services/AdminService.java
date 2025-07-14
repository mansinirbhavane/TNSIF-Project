package com.tns.fooddeliverysystem.services;

import com.tns.fooddeliverysystem.entities.*;

import java.util.*;

public class AdminService {
    private List<DeliveryPerson> deliveryPeople = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private int orderIdCounter = 1;

    public void addDeliveryPerson(DeliveryPerson dp) {
        deliveryPeople.add(dp);
        System.out.println("Delivery person added successfully!");
    }

    public List<DeliveryPerson> getDeliveryPeople() {
        return deliveryPeople;
    }

    public void placeOrder(String customerName, Map<FoodItem, Integer> cartItems, String address) {
        Order order = new Order(orderIdCounter++, customerName, cartItems, address);
        orders.add(order);
    }

    public void assignDeliveryPerson(int orderId, int deliveryPersonId) {
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

    private Order getOrderById(int id) {
        for (Order o : orders) {
            if (o.getOrderId() == id) return o;
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
