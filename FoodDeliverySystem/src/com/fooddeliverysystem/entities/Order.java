package com.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private String customerName;
    private String address;
    private List<OrderItem> items;
    private double totalAmount;
    private DeliveryPerson assignedDeliveryPerson;

    public Order(String customerName, String address) {
        this.orderId = UUID.randomUUID().toString().substring(0, 8); // short unique ID
        this.customerName = customerName;
        this.address = address;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        totalAmount += item.getTotalPrice();
    }

    public void assignDeliveryPerson(DeliveryPerson dp) {
        this.assignedDeliveryPerson = dp;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public DeliveryPerson getAssignedDeliveryPerson() {
        return assignedDeliveryPerson;
    }

    public void generateReceipt() {
        System.out.println("🧾 Order Receipt - ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Delivery Address: " + address);
        for (OrderItem item : items) {
            System.out.println("  - " + item);
        }
        System.out.println("---------------------------------");
        System.out.printf("Total Amount: ₹%.2f%n", totalAmount);
        if (assignedDeliveryPerson != null) {
            System.out.println("Assigned Delivery Person: " + assignedDeliveryPerson.getName());
        } else {
            System.out.println("Assigned Delivery Person: None");
        }
    }

    @Override
    public String toString() {
        return "OrderID: " + orderId +
                ", Customer: " + customerName +
                ", Address: " + address +
                ", Total: ₹" + String.format("%.2f", totalAmount) +
                (assignedDeliveryPerson != null ? ", Assigned to: " + assignedDeliveryPerson.getName() : ", Not assigned");
    }
}