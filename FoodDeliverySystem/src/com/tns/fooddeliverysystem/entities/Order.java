package com.tns.fooddeliverysystem.entities;

import java.util.Map;

public class Order {
    private int orderId;
    private String customerName;
    private Map<FoodItem, Integer> items;
    private String status = "Pending";
    private DeliveryPerson deliveryPerson;
    private String deliveryAddress;

    public Order(int orderId, String customerName, Map<FoodItem, Integer> items, String address) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.deliveryAddress = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void assignDeliveryPerson(DeliveryPerson dp) {
        this.deliveryPerson = dp;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customerName +
                ", items=" + items +
                ", status='" + status + '\'' +
                ", deliveryPerson=" + (deliveryPerson != null ? deliveryPerson.getName() : "Not Assigned") +
                '}';
    }
}
